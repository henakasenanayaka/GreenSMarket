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

@WebServlet(name = "adminedituserServlet", urlPatterns = {"/adminedituserServlet"})
public class adminedituserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int u_id = Integer.parseInt(request.getParameter("id"));
        List<Map<String, String>> adminuseredit = UserDBUtil.adminuseredit(u_id);
        String msg = request.getParameter("msg");
        if("done".equals(msg)){
            request.setAttribute("adminuseredit", adminuseredit);
            RequestDispatcher rd = request.getRequestDispatcher("adminuseredit.jsp?=done");
            rd.forward(request, response);
        }
        else if("done".equals(msg)){
            request.setAttribute("adminuseredit", adminuseredit);
            RequestDispatcher rd = request.getRequestDispatcher("adminuseredit.jsp?=fail");
            rd.forward(request, response);
        }else{
            request.setAttribute("adminuseredit", adminuseredit);
            RequestDispatcher rd = request.getRequestDispatcher("adminuseredit.jsp");
            rd.forward(request, response);
        }
    }
}
