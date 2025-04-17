package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminusereditServlet", urlPatterns = {"/adminusereditServlet"})
public class adminusereditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String add = request.getParameter("add");
        int phone = Integer.parseInt(request.getParameter("phone"));
        
        boolean isDone = UserDBUtil.userupdate(u_id, fname, lname, email, pass, add, phone);
        if(isDone == true){
            response.sendRedirect("adminedituserServlet?msg=done&id="+u_id);
        }else{
            response.sendRedirect("adminedituserServlet?msg=fail&id="+u_id);
        }
    }
}
