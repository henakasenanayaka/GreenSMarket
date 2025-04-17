package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminprodelServlet", urlPatterns = {"/adminprodelServlet"})
public class adminprodelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p_id =Integer.parseInt(request.getParameter("p_id"));
        
        boolean isDel = UserDBUtil.adminprodel(p_id);
        if(isDel == true){
            response.sendRedirect("adminproServlet?msg=del");
        }else{
            response.sendRedirect("adminproServlet?msg=notdel");
        }
    }

}
