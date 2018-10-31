package servlet;

import calc.CalculatorManager;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ServletLogout extends HttpServlet {
    private final FreeMarker freeMarker;
    private final NumberGenerator numberGenerator;
    private final LoginServer<String> loginServer;
    private final CalculatorManager manager;

    public ServletLogout(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager) {
        this.freeMarker = freeMarker;
        this.numberGenerator = numberGenerator;
        this.loginServer = loginServer;
        this.manager = manager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            // current user
            int id = Integer.parseInt(cookies[0].getValue());
            // clear cookies
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
            // message
            freeMarker.render("logoutMessage.html", new HashMap<String, Object>(){{ put("name", loginServer.getName(id));}}, resp);
            // clear id
            numberGenerator.remove(id);
            // clear login
            loginServer.logout(id);
            // remove calculator
            manager.remove(id);
        }
    }
}
