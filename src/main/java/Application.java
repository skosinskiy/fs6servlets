import calc.CalculatorManager;
//import org.alexr.trace.filter.FilterServletPrinter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.*;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) throws Exception {
        // full Jetty documentation available here
        // https://www.eclipse.org/jetty/documentation/9.4.12.v20180830/
        Server server = new Server(8080);
        ApplicationCore core = new ApplicationCore();
        //ApplicationCore core = ApplicationCore.build();

        ServletContextHandler handler = new ServletContextHandler();

        //handler.addServlet(ServletProduct.class, "/product/*");

        handler.addServlet(ServletAssets.class, "/assets/*");
        handler.addServlet(new ServletHolder(new ServletLogin(core)), "/login");
        handler.addServlet(new ServletHolder(new ServletLogout(core)), "/logout");
        handler.addServlet(new ServletHolder(new ServletCalculator(core)), "/calc/*");
        handler.addServlet(new ServletHolder(new ServletList(core)), "/list/*");
        handler.addServlet(new ServletHolder(new ServletDelete(core)), "/delete/*");
        handler.addServlet(new ServletHolder(new ServletRedirectTo("/login")), "/*");

        //handler.addFilter(FilterServletPrinter.class, "/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
