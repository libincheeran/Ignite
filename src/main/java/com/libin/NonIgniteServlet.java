package com.libin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( "/NonIgniteServlet")
public class NonIgniteServlet extends HttpServlet {
    private static final String COUNT = "count";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        HttpSession session = request.getSession();
        Integer count = (Integer)session.getAttribute(COUNT);
        count = (count == null) ? new Integer(0):count;
        count++;
        session.setAttribute(COUNT,count);
        response.getOutputStream().print("Non Ignite: Hit Count "+count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
