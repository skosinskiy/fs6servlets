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

public class ServletLogin extends HttpServlet {
    private final FreeMarker freeMarker;
    private final NumberGenerator numberGenerator;
    private final LoginServer<String> loginServer;
    private final CalculatorManager manager;

    public ServletLogin(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager) {
        this.freeMarker = freeMarker;
        this.numberGenerator = numberGenerator;
        this.loginServer = loginServer;
        this.manager = manager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            freeMarker.render("unloggedWelcome.html", resp);
        } else {
            freeMarker.render("loggedWelcome.html", new HashMap<String, Object>() {{ put("name", loginServer.getName(cookies[0].getValue()));}}, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        // create new id
        int new_id = numberGenerator.create();
        // put pair id, name into HashMap
        loginServer.login(new_id, name);
        // create calculator with new id
        manager.getOrCreate(new_id);
        // set a cookie
        resp.addCookie(new Cookie("UID", String.valueOf(new_id)));
        // redirect
        resp.sendRedirect("/user/login");
        // create a calculator
        manager.getOrCreate(new_id);
    }
}
