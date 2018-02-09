package jetty.jar;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
public class OneConext {
    //如果只有一个context 意义不是很大
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        // Add a single handler on context "/hello"
        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        context.setHandler(new HelloworldHandler());

        // Can be accessed using http://localhost:8080/hello

        server.setHandler(context);

        // Start the server
        server.start();
        server.join();
    }
}
