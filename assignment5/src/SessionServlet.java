import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Using Cookies
        Cookie cookie = new Cookie("username", "GuestUser");
        response.addCookie(cookie);

        // Using URL Rewriting
        String encodedURL = response.encodeURL("welcome.jsp");

        // Using HttpSession
        HttpSession session = request.getSession();
        session.setAttribute("theme", "dark-mode");

        // Response Output
        out.println("<html><body>");
        out.println("<h2>Session Management</h2>");
        out.println("<p>Cookie Set: username = GuestUser</p>");
        out.println("<p><a href='" + encodedURL + "'>Go to Welcome Page</a></p>");
        out.println("</body></html>");
    }
}
