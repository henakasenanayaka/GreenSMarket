package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addadminServlet", urlPatterns = {"/addadminServlet"})
public class addadminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        boolean isDone = UserDBUtil.addadmin(email, pass);
        if(isDone == true){
            System.out.println("done");
            response.sendRedirect("adminshowadminsServlet?msg=done");
        }else{
            System.out.println("fail");
            response.sendRedirect("adminshowadminsServlet?msg=fail");
        }
    }

}
