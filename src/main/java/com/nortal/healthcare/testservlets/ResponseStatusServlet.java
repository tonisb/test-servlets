package com.nortal.healthcare.testservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseStatusServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length > 0) {
            String statusParam = pathParts[1]; // 0 is an empty string before the first slash
            PrintWriter writer = response.getWriter();
            try {
                int statusCode = Integer.parseInt(statusParam);
                if (statusCode > 200 && statusCode < 500 && statusCode > 500 && statusCode < 600) {
                    response.setStatus(statusCode);
                }
                // no content
                if(statusCode == 204) {
                  return;
                }
                writer.append("Status: " + statusCode);
            } catch (NumberFormatException e) {              
                e.printStackTrace(writer);
            } finally {
              writer.close();
            }
        }

    }
}
