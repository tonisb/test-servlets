package com.nortal.healthcare.testservlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadSleepServlet extends HttpServlet {
  
  private static int DEFAULT_WAIT = 30000;
  
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        try {
          int wait = DEFAULT_WAIT;
          String waitParameter = request.getParameter("wait");
          if(waitParameter != null) {
            try {
              wait = Integer.valueOf(waitParameter).intValue();
            } catch (NumberFormatException e) {
              // ignore
            }
          }
          Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
