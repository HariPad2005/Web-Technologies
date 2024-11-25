import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html lang='en'>");
            response.getWriter().println("<head>");
            response.getWriter().println("<meta charset='UTF-8'>");
            response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            response.getWriter().println("<title>Welcome to World of Bags</title>");
            response.getWriter().println("<style>");
            response.getWriter().println("body { font-family: Arial, sans-serif; background-color: #f9fafc; color: #333; margin: 0; padding: 0; text-align: center; }");
            response.getWriter().println(".welcome-container { margin-top: 50px; padding: 20px; background-color: white; display: inline-block; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); }");
            response.getWriter().println("h1 { color: #5a4fcf; }");
            response.getWriter().println("p { font-size: 16px; color: #555; margin-bottom: 15px; }");
            response.getWriter().println(".bag-item { background-color: #e6e6f9; padding: 10px; margin: 10px; border-radius: 5px; }");
            response.getWriter().println("</style>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<div class='welcome-container'>");
            response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
            response.getWriter().println("<p>You have entered the enchanting World of Bags!</p>");
            response.getWriter().println("<div class='bag-item'><strong>Backpack:</strong> A spacious option for travelers and students.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Duffle:</strong> Perfect for gym or weekend trips.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Messenger:</strong> A stylish choice for casual or office use.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Tote:</strong> Ideal for shopping or day outings.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Clutch:</strong> Compact and elegant for evening events.</div>");
            response.getWriter().println("</div>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
        } else {
            response.getWriter().println("Please log in first.");
        }
    }
}
