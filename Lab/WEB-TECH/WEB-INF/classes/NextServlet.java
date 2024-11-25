import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NextServlet")
public class NextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        response.getWriter().println("<title>Next Page</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Arial', sans-serif; background-color: #f4f7fc; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        response.getWriter().println(".next-container { text-align: center; background: #fff; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); }");
        response.getWriter().println("h1 { color: #4a90e2; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='next-container'>");
        response.getWriter().println("<h1>Hello again, " + username + "!</h1>");
        response.getWriter().println("<p>You are now on the next page.</p>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
