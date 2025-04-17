package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admindeleteServlet", urlPatterns = {"/admindeleteServlet"})
public class admindeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a_id = Integer.parseInt(request.getParameter("id"));
        
        boolean isDel = UserDBUtil.admindel(a_id);
        if(isDel == true){
            response.sendRedirect("adminshowadminsServlet?msg=del");
        }
        else{
            response.sendRedirect("adminshowadminsServlet?msg=notdel");
        }
    }
}
