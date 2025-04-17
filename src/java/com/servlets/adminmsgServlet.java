package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminmsgServlet", urlPatterns = {"/adminmsgServlet"})
public class adminmsgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = request.getParameter("msg");
        List<Map<String, String>> adminsms = UserDBUtil.adminsms();
        
        if("deleted".equals(msg)){
            request.setAttribute("adminsms", adminsms);
            RequestDispatcher rd = request.getRequestDispatcher("adminmsg.jsp?msg=deleted");
            rd.forward(request, response);
        }
        else if("notdeleted".equals(msg)){
            request.setAttribute("adminsms", adminsms);
            RequestDispatcher rd = request.getRequestDispatcher("adminmsg.jsp?msg=notdeleted");
            rd.forward(request, response);
        }else{
            request.setAttribute("adminsms", adminsms);
            RequestDispatcher rd = request.getRequestDispatcher("adminmsg.jsp");
            rd.forward(request, response);
        }
    }
}
