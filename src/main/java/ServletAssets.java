import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletAssets extends HttpServlet {
    static Logger log = LoggerFactory.getLogger(ServletAssets.class);
    private final static String PATH = "./static";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("=============");
        log.info(req.getServletPath());
        log.info(req.getPathInfo());
        log.info("=============");
        //PrintWriter writer = resp.getWriter();
        //ServletOutputStream outputStream = resp.getOutputStream();
    }
}
