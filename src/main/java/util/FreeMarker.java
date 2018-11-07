package util;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.FreemarkerContent;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class FreeMarker {
    /**
     * logger instance
     */
    private static final Logger LOG = LoggerFactory.getLogger(FreeMarker.class);

    /**
     * Configuration Instance
     */
    private final Configuration config;

    public FreeMarker(final String path) {
        this.config = new Configuration(Configuration.VERSION_2_3_28) {{
            try {
                setDirectoryForTemplateLoading(new File(path));
                setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
                setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                setLogTemplateExceptions(false);
                setWrapUncheckedExceptions(true);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }};
    }

    public void render(final String templateFile, final HttpServletResponse resp) throws IOException {
        render(templateFile, new HashMap<>(), resp);
    }

    public void render(final String templateFile, FreemarkerContent content, final HttpServletResponse resp) throws IOException {
        render(templateFile, content.get(), resp);
    }

    public void render(final String templateFile, final Map<String, Object> data, final HttpServletResponse resp) throws IOException {
        try {
            resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
            config.getTemplate(templateFile).process(data, resp.getWriter());
        } catch (TemplateException e) {
            LOG.info(e.getMessage());
        }
    }
}
