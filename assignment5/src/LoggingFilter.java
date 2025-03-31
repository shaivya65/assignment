import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") // Applies to all requests
public class LoggingFilter implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String ipAddress = req.getRemoteAddr();
        String url = req.getRequestURL().toString();
        Date requestTime = new Date();

        // Logging to console
        System.out.println("LOG: " + requestTime + " | IP: " + ipAddress + " | URL: " + url);

        chain.doFilter(request, response); // Continue request processing
    }

    public void destroy() {}
}
