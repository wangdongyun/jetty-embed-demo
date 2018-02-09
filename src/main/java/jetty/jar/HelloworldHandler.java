package jetty.jar;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
public class HelloworldHandler extends AbstractHandler {

    private String msg;

    public HelloworldHandler(){}

    public HelloworldHandler(String msg){
        this.msg = msg;
    }

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException,
            ServletException {
//        getContextPath

        System.out.println("request context: "+request.getContextPath());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write back response
        response.getWriter().println("<h1>"+msg+"</h1>");

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

}
