import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        out.println
        (
            docType +
            "<html>\n" +
            " <head><title>Test Servlet</title></head>\n" +
            "<body>\n" +
            " <h1>Hello!</h1>\n" +
            " <p>" + request.getLocalAddr() + "</p>\n<p>" + request.getMethod() + "</p>\n<p>" + request.getProtocol() + "</p>\n<p>"
            + request.getHeader("Username") + "</p>\n<p>Username: " + username + "</p>\n<p>Password: " + password + "</p>\n" +
            "</body></html>"
        );
    }
}