import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);


        //server.setHandler(new ServletContextHandler(){{
        //    addServlet(new ServletHolder(new ServletAssets()),"/assets/*");


        server.start();
        server.join();
    }
}
