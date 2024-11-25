import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeWithCookie")
public class WelcomeWithCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        response.getWriter().println("<title>Welcome - World of Bags</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Arial', sans-serif; background-color: #f9fafc; margin: 0; padding: 0; display: flex; align-items: center; justify-content: center; height: 100vh; }");
        response.getWriter().println(".welcome-container { background: #fff; padding: 20px 40px; border-radius: 10px; box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2); text-align: center; max-width: 500px; width: 100%; }");
        response.getWriter().println("h1 { color: #5a4fcf; margin-bottom: 15px; }");
        response.getWriter().println("p { color: #333; font-size: 18px; }");
        response.getWriter().println(".bag-list { margin-top: 15px; }");
        response.getWriter().println(".bag-item { background-color: #e6e6f9; padding: 10px; margin: 5px 0; border-radius: 5px; text-align: left; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='welcome-container'>");

        if (username != null) {
            response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
            response.getWriter().println("<p>Explore the enchanting world of bags:</p>");
            response.getWriter().println("<div class='bag-list'>");
            response.getWriter().println("<div class='bag-item'><strong>Backpack:</strong> Spacious and trendy for school or travel.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Duffle:</strong> Perfect for gym or weekend trips.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Messenger:</strong> Stylish choice for work or casual outings.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Tote:</strong> Ideal for shopping or daily errands.</div>");
            response.getWriter().println("<div class='bag-item'><strong>Clutch:</strong> Elegant for evening events.</div>");
            response.getWriter().println("</div>");
        } else {
            response.getWriter().println("<h1>Session Expired!</h1>");
            response.getWriter().println("<p>Please log in again to continue.</p>");
        }

        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
