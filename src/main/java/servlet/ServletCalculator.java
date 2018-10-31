package servlet;

import calc.Calculator;
import calc.CalculatorManager;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

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

    public ServletCalculator(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager) {
        this.freeMarker = freeMarker;
        this.numberGenerator = numberGenerator;
        this.loginServer = loginServer;
        this.manager = manager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Calculator calc;
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            // create calculator
            calc = manager.getOrCreate();
            // create cookie
            resp.addCookie(new Cookie("id", String.valueOf(calc.getId())));
        } else {
            Cookie c = cookies[0];
            // parse cookie
            int id = Integer.parseInt(c.getValue());
            // get the calculator
            calc = manager.getOrCreate(id);
        }

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