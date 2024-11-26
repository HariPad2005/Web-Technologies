import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Variable to store the page visit count
    private int pageCount = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Increment the page visit counter
        synchronized (this) {
            pageCount++;
        }

        // Set the content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML Dashboard with visit count
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Dashboard</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f9; color: #333; }");
        out.println("header { background-color: #007BFF; color: white; padding: 20px; text-align: center; }");
        out.println("main { padding: 20px; text-align: center; }");
        out.println(".bag-list { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 20px; margin-top: 30px; }");
        out.println(".bag { border: 1px solid #ddd; border-radius: 5px; background-color: white; padding: 15px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }");
        out.println(".bag h3 { margin-top: 0; }");
        out.println(".bag p { margin: 10px 0; }");
        out.println(".visit-count { margin-top: 30px; font-size: 18px; color: #555; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<h1>Welcome to the World of Bags!</h1>");
        out.println("<p>Explore the best bags for all your needs.</p>");
        out.println("</header>");
        out.println("<main>");
        out.println("<h2>Bag Categories</h2>");
        out.println("<div class='bag-list'>");
        out.println("<div class='bag'>");
        out.println("<h3>Backpacks</h3>");
        out.println("<p>Spacious and durable backpacks for travel and school.</p>");
        out.println("</div>");
        out.println("<div class='bag'>");
        out.println("<h3>Duffle Bags</h3>");
        out.println("<p>Sturdy and stylish duffle bags for gym and weekend trips.</p>");
        out.println("</div>");
        out.println("<div class='bag'>");
        out.println("<h3>Messenger Bags</h3>");
        out.println("<p>Perfect for office and casual outings.</p>");
        out.println("</div>");
        out.println("<div class='bag'>");
        out.println("<h3>Totes</h3>");
        out.println("<p>Elegant totes for shopping and everyday use.</p>");
        out.println("</div>");
        out.println("<div class='bag'>");
        out.println("<h3>Clutches</h3>");
        out.println("<p>Compact clutches for special occasions.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='visit-count'>");
        out.println("<p>Total Page Visits: " + pageCount + "</p>");
        out.println("</div>");
        out.println("</main>");
        out.println("</body>");
        out.println("</html>");
    }
}
