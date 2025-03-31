import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hardcoded credentials
        String correctUser = "admin";
        String correctPass = "password123";

        // Getting input from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals(correctUser) && password.equals(correctPass)) {
            // Create session and redirect
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // Redirect back to login page with error
            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Invalid Credentials! Try again.</h3>");
            out.println("<a href='login.html'>Go back to Login</a>");
            out.println("</body></html>");
        }
    }
}
