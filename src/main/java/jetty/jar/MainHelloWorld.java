package jetty.jar;

import org.eclipse.jetty.server.Server;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
public class MainHelloWorld {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloworldHandler());
        server.start();
        server.join();
    }
}
