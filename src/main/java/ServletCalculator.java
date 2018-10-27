import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletCalculator extends HttpServlet {
    private Calculator calculator;

    public ServletCalculator(Calculator calc) {
        this.calculator = calc;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> m = req.getParameterMap();
        if (m.isEmpty()) {
            resp.getWriter().write(String.valueOf(calculator.add()));
        } else {
            calculator.setData(m.get("x")[0],m.get("y")[0]);
        }
    }
}
