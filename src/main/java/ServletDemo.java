import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet{
    private String msg;
    private ExampleService exampleService = new ExampleService();


    @Override
    public void init() throws ServletException {
        msg = exampleService.returnMessage();
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        // Setting up the content type of webpage
        response.setContentType("text/html");
        // Writing message to the web page
        PrintWriter out = response.getWriter();
        out.println("<h1>" + msg + "</h1>");
    }

    @Override
    public void destroy() {
        /* leaving empty for now this can be
         * used when we want to do something at the end
         * of Servlet life cycle
         */
    }
}