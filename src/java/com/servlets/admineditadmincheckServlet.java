package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admineditadmincheckServlet", urlPatterns = {"/admineditadmincheckServlet"})
public class admineditadmincheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        boolean isDone = UserDBUtil.adminuserupdate(id, email, pass);
        if(isDone == true){
            System.out.println("done");
            response.sendRedirect("adminshowadminsServlet?msg=done&id="+id);
        }else{
            System.out.println("fail");
            response.sendRedirect("adminshowadminsServlet?msg=fail&id="+id);
        }
    }
}
