import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServletCalculator extends HttpServlet {
    private CalculatorManager manager;

    public ServletCalculator(CalculatorManager manager) {
        this.manager = manager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            // TODO create cookie
            // TODO create calculator
        } else {
            // TODO parse cookie
            // TODO get calculator
        }
        // TODO stub!
        Calculator calculator = new Calculator(0);

        Map<String, String[]> m = req.getParameterMap();
        if (m.isEmpty()) {
            resp.getWriter().write(String.valueOf(calculator.add()));
        } else {
            calculator.setData(m.get("x")[0],m.get("y")[0]);
        }
        long l = System.currentTimeMillis();
    }
}
