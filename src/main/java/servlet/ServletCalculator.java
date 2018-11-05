package servlet;

import calc.Calculator;
import calc.CalculatorManager;
import db.SQLOperations;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ServletCalculator extends HttpServlet {
    private final FreeMarker freeMarker;
    private final NumberGenerator numberGenerator;
    private final LoginServer<String> loginServer;
    private final CalculatorManager manager;
    private final SQLOperations sqlOperations;

    public ServletCalculator(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager, SQLOperations sql) {
        this.freeMarker = freeMarker;
        this.numberGenerator = numberGenerator;
        this.loginServer = loginServer;
        this.manager = manager;
        this.sqlOperations = sql;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Calculator calc;
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            resp.sendRedirect("/login");
        } else {
            // TODO RENDER FORM
            Cookie c = cookies[0];
            // parse cookie
            int id = Integer.parseInt(c.getValue());
            // get the calculator
            calc = manager.get(id);
            Map<String, String[]> m = req.getParameterMap();
            StringBuilder content = new StringBuilder();
            if (!m.isEmpty()) {
                calc.setData(m.get("x")[0],m.get("y")[0]);

                content.append("Data successfully set");
            } else {
                try {
                    content.append(String.format("calculated: %d\n", calc.add()));
                } catch (IllegalArgumentException e) {
                    content.append(e.getMessage());
                }
            }
            resp.getWriter().write(content.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // all cookies
        Cookie[] cookies = req.getCookies();
        // one cookie
        Cookie c = cookies[0];
        // parse cookie
        int id = Integer.parseInt(c.getValue());
        // get the calculator
        Calculator calc = manager.get(id);

        // TODO PROCESS FORM AND MAKE CALCULATION
        Map<String, String[]> m = req.getParameterMap();

        StringBuilder content = new StringBuilder();
        // try to make calculations
        try {
            content.append(String.format("calculated: %d\n", calc.add()));
        } catch (IllegalArgumentException e) {
            content.append(e.getMessage());
        }
        resp.getWriter().write(content.toString());
    }
}
