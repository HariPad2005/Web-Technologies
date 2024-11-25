import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginWithCookie")
public class LoginWithCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("user".equals(username) && "password".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(3600); // 1 hour
            response.addCookie(cookie);
            response.sendRedirect("WelcomeWithCookie");
        } else {
            response.getWriter().println("Invalid login credentials");
        }
    }
}
