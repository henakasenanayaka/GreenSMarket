package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String add = request.getParameter("add");
        String phone = request.getParameter("phone");
        
        boolean isRegistered = UserDBUtil.signup(fname, lname, email, pass, add, phone);
        
        if(isRegistered == true){
            response.sendRedirect("index.jsp?msg=signdone");
        }
        else{
            response.sendRedirect("signup.jsp?msg=signfail");
        }
    }
}
