import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletUser svtUser = new ServletUser();

        final ServletContextHandler handler1 = new ServletContextHandler();
        handler1.addServlet(new ServletHolder(svtUser), "/user/*");
        handler1.addServlet(ServletProduct.class, "/product/*");
        handler1.addServlet("ServletCart", "/cart/*");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("./resources/static");
        resourceHandler.setDirectoriesListed(true);

        final ContextHandler handler2= new ContextHandler("/path/*");
        handler2.setHandler(resourceHandler);

        server.setHandler(new ContextHandlerCollection() {{
            addHandler(handler1);
            addHandler(handler2);
        }});

        server.start();
        server.join();
    }
}
