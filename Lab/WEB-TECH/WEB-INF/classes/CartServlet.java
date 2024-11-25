import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String item = request.getParameter("item");

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='en'>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        response.getWriter().println("<title>Cart Summary</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Arial', sans-serif; background-color: #f4f7fc; margin: 0; padding: 0; display: flex; align-items: center; justify-content: center; height: 100vh; }");
        response.getWriter().println(".cart-summary { background: #fff; padding: 20px 40px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); text-align: center; max-width: 400px; width: 100%; }");
        response.getWriter().println("h1 { color: #5a67d8; margin-bottom: 15px; }");
        response.getWriter().println("p { color: #333; font-size: 16px; margin-bottom: 10px; }");
        response.getWriter().println(".cart-item { margin-top: 15px; background-color: #ebf4ff; padding: 10px; border-radius: 5px; color: #2a4365; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='cart-summary'>");

        if (item != null) {
            response.getWriter().println("<h1>Item Added to Cart</h1>");
            response.getWriter().println("<div class='cart-item'>" + item + "</div>");
            response.getWriter().println("<p>Happy shopping! Add more items or proceed to checkout.</p>");
        } else {
            response.getWriter().println("<h1>Your Cart is Empty</h1>");
            response.getWriter().println("<p>Looks like you haven’t added anything yet!</p>");
        }

        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
