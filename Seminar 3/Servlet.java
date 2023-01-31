import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";

        out.println
        (
            docType +
            "<html>\n" +
            " <head><title>Test Servlet</title></head>\n" +
            "<body>\n" +
            " <h1>Hello!</h1>\n" +
            " <p>" + request.getLocalAddr() + "\n" + request.getMethod() + "\n" + request.getProtocol() + "\n" +
            "</body></html>"
        );
    }
}