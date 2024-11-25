import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowUserDetailsServlet")
public class ShowUserDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String username = request.getParameter("username");

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        response.getWriter().println("<title>Welcome User</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Arial', sans-serif; background-color: #f9fafb; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        response.getWriter().println(".welcome-container { text-align: center; background: #fff; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); }");
        response.getWriter().println("h1 { color: #4a90e2; }");
        response.getWriter().println("p { font-size: 16px; color: #333; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='welcome-container'>");
        response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
        response.getWriter().println("<p>User ID: " + userId + "</p>");
        response.getWriter().println("<form action='NextServlet' method='post'>");
        response.getWriter().println("<input type='hidden' name='username' value='" + username + "'>");
        response.getWriter().println("<button type='submit'>Proceed</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
