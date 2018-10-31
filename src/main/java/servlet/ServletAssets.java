package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServletAssets extends HttpServlet {
    static Logger log = LoggerFactory.getLogger(ServletAssets.class);
    private final static String PATH = "static";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("=============");
        File f = new File(PATH, req.getPathInfo());
        log.info(f.getAbsolutePath());
        log.info("=============");
        Files.copy(Paths.get(PATH, req.getPathInfo()), resp.getOutputStream());
        //PrintWriter writer = resp.getWriter();
        //ServletOutputStream outputStream = resp.getOutputStream();
    }
}
