import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletAA svtAA = new ServletAA();

        ServletHolder holderAA = new ServletHolder(svtAA);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(holderAA, "/aa/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
