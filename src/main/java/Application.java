import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        // full Jetty documentation available here
        // https://www.eclipse.org/jetty/documentation/9.4.12.v20180830/
        Server server = new Server(8080);
        CalculatorManager manager = new CalculatorManager();

        ServletUser svtUser = new ServletUser();

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new ServletCalculator(manager)), "/calc/*");
        handler.addServlet(new ServletHolder(svtUser), "/user/*");
        handler.addServlet(ServletProduct.class, "/product/*");
        handler.addServlet(ServletAssets.class, "/assets/*");
        handler.addServlet("ServletCart", "/cart/*");
        handler.addServlet(ServletIndex.class, "/");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
