package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adcategorydelServlet", urlPatterns = {"/adcategorydelServlet"})
public class adcategorydelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        
        boolean isDel = UserDBUtil.admincatdel(c_id);
        if(isDel == true)
            response.sendRedirect("admincategoryServlet?msg=del");
        else
            response.sendRedirect("admincategoryServlet?msg=notdel");
    }
}
