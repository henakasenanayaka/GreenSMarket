package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminaddcatServlet", urlPatterns = {"/adminaddcatServlet"})
public class adminaddcatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String img = request.getParameter("img");
        
        boolean isDone = UserDBUtil.adminaddcat(cname, img);
        
        if(isDone == true){
            response.sendRedirect("admincategoryServlet?msg=catadd");
        }else{
            response.sendRedirect("admincategoryServlet?msg=catnotadd");
        }
        
    }
}
