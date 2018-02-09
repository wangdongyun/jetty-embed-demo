package jetty.war;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
public class OneWebApp {
    //TODO: 这里可以使用CommonCli 支持启动命令传入各种参数
    //TODO: 这里也可以使用默认的 配置文件 等等
    public static void main(String[] args) throws Exception {


        // Create a basic jetty server object that will listen on port 8080.
        // Note that if you set this to port 0 then a randomly available port
        // will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server(8080);


        // Setup JMX
//        MBeanContainer mbContainer = new MBeanContainer(
//                ManagementFactory.getPlatformMBeanServer());
//        server.addBean(mbContainer);

        // The WebAppContext is the entity that controls the environment in
        // which a web application lives and breathes. In this example the
        // context path is being set to "/" so it is suitable for serving root
        // context requests and then we see it setting the location of the war.
        // A whole host of other configurations are available, ranging from
        // configuring to support annotation scanning in the webapp (through
        // PlusConfiguration) to choosing where the webapp will unpack itself.
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");

//        war包的目录通过参数传入
        webapp.setWar(args[0]);


//        File warFile = new File(
//                "../../tests/test-jmx/jmx-webapp/target/jmx-webapp");
//        webapp.setWar(warFile.getAbsolutePath());

//        webapp.setWar();
        // A WebAppContext is a ContextHandler as well so it needs to be set to
        // the server so it is aware of where to send the appropriate requests.
        server.setHandler(webapp);

        // Start things up!
        server.start();

        server.dumpStdErr();

        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        // See http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
        server.join();
    }
}
