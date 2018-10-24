import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletAA svtAA = new ServletAA();

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(svtAA), "/aa/*");
        handler.addServlet(ServletProduct.class, "/product/*");
        handler.addServlet("ServletCart", "/cart/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
