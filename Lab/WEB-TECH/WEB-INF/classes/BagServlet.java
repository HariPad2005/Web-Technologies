import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BagServlet")
public class BagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bagName = request.getParameter("bagName");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Sample bag details
        String details = getBagDetails(bagName);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Bag Details</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; color: #333; margin: 0; padding: 20px; }");
        out.println("h1 { color: #4CAF50; text-align: center; }");
        out.println(".container { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); max-width: 400px; margin: 30px auto; }");
        out.println("p { font-size: 16px; line-height: 1.6; }");
        out.println("a { display: inline-block; margin-top: 20px; text-decoration: none; background-color: #4CAF50; color: white; padding: 10px 15px; border-radius: 4px; }");
        out.println("a:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Bag Details</h1>");
        out.println("<div class='container'>");

        if (details != null) {
            out.println("<p><strong>Bag Name:</strong> " + bagName + "</p>");
            out.println("<p><strong>Details:</strong> " + details + "</p>");
        } else {
            out.println("<p>No details found for bag <strong>" + bagName + "</strong>.</p>");
        }

        out.println("<a href=\"ex5b_bagfinder.html\">Back to Search</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

    private String getBagDetails(String bagName) {
        // Mock database with bag details
       switch (bagName.toLowerCase()) {
    case "backpack":
        return "A spacious backpack suitable for travel and school.";
    case "duffle":
        return "A sturdy duffle bag for gym and weekend trips.";
    case "messenger":
        return "A stylish messenger bag perfect for office and casual use.";
    case "tote":
        return "A large tote bag with ample space, perfect for shopping or carrying essentials.";
    case "clutch":
        return "A sleek and compact clutch bag, ideal for evening parties and formal events.";
    case "satchel":
        return "A durable satchel bag, great for work or school with its timeless design.";
    case "hobo":
        return "A casual and roomy hobo bag, perfect for daily use.";
    case "sling":
        return "A lightweight sling bag, convenient for travel and carrying essentials hands-free.";
    case "briefcase":
        return "A classic briefcase for professionals, designed to carry laptops and documents.";
    case "bucket":
        return "A trendy bucket bag with a unique design, suitable for casual outings.";
    default:
        return null;
}

    }
}
