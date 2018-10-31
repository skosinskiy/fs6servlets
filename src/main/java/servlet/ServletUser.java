package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // one parameter
        String id = req.getParameter("id");
        PrintWriter w = resp.getWriter();
        // all parameters
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);

        // method
        String method = req.getMethod();
        System.out.println(method);

        // path
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);

        // servletPath
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        // Get Cookies
        Cookie[] cookies = req.getCookies();
        //System.out.println(Arrays.toString(cookies));

        // Set-Cookie
//        for (int i = 0; i < 10; i++) {
//            resp.addCookie(new Cookie("ABC"+i,"XYZ"+i));
//        }
        //resp.addCookie(new Cookie("ABC","XYZ"));

        // Remove Cookie
//        Cookie cookie = new Cookie("ABC", "XYZ");
//        cookie.setMaxAge(0);
//        resp.addCookie(cookie);

        w.write(String.format("Hello id=%s from servlet.ServletUser!", id));
    }
}
