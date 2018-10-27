import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ServletCalculator extends HttpServlet {
    private Calculator calculator;

    public ServletCalculator(Calculator calc) {
        this.calculator = calc;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calculator.setData(1,2);

        int add = calculator.add();
    }
}
