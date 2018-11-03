import calc.CalculatorManager;
import org.alexr.trace.filter.FilterServletPrinter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.*;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Application {
    public static void main(String[] args) throws Exception {
        // full Jetty documentation available here
        // https://www.eclipse.org/jetty/documentation/9.4.12.v20180830/
        Server server = new Server(8080);

        FreeMarker freeMarker = new FreeMarker("templates");
        CalculatorManager manager = new CalculatorManager();
        NumberGenerator numberGenerator = new NumberGenerator();
        LoginServer<String> loginServer = new LoginServer<>();

        //ServletUser svtUser = new ServletUser();

        ServletContextHandler handler = new ServletContextHandler();

        //handler.addServlet(ServletProduct.class, "/product/*");
        //handler.addServlet("servlet.ServletCart", "/cart/*");
        //handler.addServlet(ServletIndex.class, "/");
        //handler.addServlet(new ServletHolder(svtUser), "/user/*");

        handler.addServlet(ServletAssets.class, "/assets/*");
        handler.addServlet(new ServletHolder(new ServletLogin(freeMarker, numberGenerator, loginServer, manager)), "/login");
        handler.addServlet(new ServletHolder(new ServletLogout(freeMarker, numberGenerator, loginServer, manager)), "/logout");
        handler.addServlet(new ServletHolder(new ServletCalculator(freeMarker, numberGenerator, loginServer, manager)), "/calc/*");
        handler.addServlet(new ServletHolder(new ServletRedirectTo("/login")), "/*");

        handler.addFilter(FilterServletPrinter.class, "/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
