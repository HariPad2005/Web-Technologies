import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; // Updated for Oracle
    private static final String DB_USER = "system"; // Replace with your Oracle username
    private static final String DB_PASSWORD = "cscorner"; // Replace with your Oracle password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user details from the form
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert user details into the database
            String query = "INSERT INTO users (name, dob, username, email, password) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, dob); // Ensure the date format matches Oracle's requirements
            stmt.setString(3, username);
            stmt.setString(4, email);
            stmt.setString(5, password); // Ensure to hash this in a real application

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
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
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<header>");
                out.println("<h1>Welcome to the World of Bags, " + name + "!</h1>");
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
                out.println("</main>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<h1>Registration Failed.</h1>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Registration Failed. Please try again.</h1>");
        }
    }
}
