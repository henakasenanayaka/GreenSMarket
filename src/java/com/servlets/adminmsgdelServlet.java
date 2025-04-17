package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminmsgdelServlet", urlPatterns = {"/adminmsgdelServlet"})
public class adminmsgdelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int msg_id = Integer.parseInt(request.getParameter("msg_id"));
        
        boolean isDel = UserDBUtil.adminsmsdel(msg_id);
        
        if(isDel == true){
            response.sendRedirect("adminmsgServlet?msg=deleted");
        }else{
            response.sendRedirect("adminmsgServlet?msg=notdeleted");
        }
    }
}
