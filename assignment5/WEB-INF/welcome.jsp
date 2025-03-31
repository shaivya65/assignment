<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<body>
    <h2>Welcome Page</h2>
    <%
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            out.println("<p>Welcome, " + session.getAttribute("username") + "!</p>");
        } else {
            out.println("<p>User not logged in.</p>");
        }
    %>
    <a href="index.html">Go to Home</a>
</body>
</html>
