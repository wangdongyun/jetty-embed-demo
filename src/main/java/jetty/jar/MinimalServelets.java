package jetty.jar;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
public class MinimalServelets {

    public static void main(String[] args) throws Exception {
        // Create a basic jetty server object that will listen on port 8080.
        // Note that if you set this to port 0 then a randomly available port
        // will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server(8080);

        // The ServletHandler is a dead simple way to create a context handler
        // that is backed by an instance of a Servlet.
        // This handler then needs to be registered with the Server object.
//        ServletHandler handler = new ServletHandler();
//        HandlerList handlerList = new HandlerList();
//        handlerList.setHandlers(new Handler[]{handler,new DefaultHandler()});
//        server.setHandler(handlerList);

        // Passing in the class for the Servlet allows jetty to instantiate an
        // instance of that Servlet and mount it on a given context path.

        // IMPORTANT:
        // This is a raw Servlet, not a Servlet that has been configured
        // through a web.xml @WebServlet annotation, or anything similar.
//        DispatcherServlet.setContextConfigLocation();

        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);

        context.setContextPath("/");

        ServletHolder servletHolder = new ServletHolder();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(){

        };
        dispatcherServlet.setContextConfigLocation("classpath:spring-app.xml");
        servletHolder.setServlet(dispatcherServlet);
        context.addServlet(servletHolder,"/*");

        server.setHandler(context);
        // Start things up!
        server.start();

//        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:spring-app.xml");

        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        // See
        // http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
        server.join();

    }



    //在实际的项目当中我们可以使用spring-mvc-servlet
    public static class HelloServlet extends HttpServlet
    {
        @Override
        protected void doGet( HttpServletRequest request,
                              HttpServletResponse response ) throws ServletException,
                IOException
        {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello from HelloServlet</h1>");
        }
    }
}
