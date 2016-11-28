package com.nortal.healthcare.testservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseStatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length > 0) {
            String statusParam = pathParts[1]; // 0 is an empty string before the first slash
            try {
                int statusCode = Integer.parseInt(statusParam);
                if (statusCode > 200 && statusCode < 500 && statusCode > 500 && statusCode < 600) {
                    response.setStatus(statusCode);
                }
                if (statusCode == 500) {
                    int i = 1 / 0;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
}
