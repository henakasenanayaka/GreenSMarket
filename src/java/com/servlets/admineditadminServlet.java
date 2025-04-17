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

@WebServlet(name = "admineditadminServlet", urlPatterns = {"/admineditadminServlet"})
public class admineditadminServlet extends HttpServlet {
//3
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a_id = Integer.parseInt(request.getParameter("id"));
        List<Map<String, String>> adminadminedit = UserDBUtil.adminadminedit(a_id);
        String msg = request.getParameter("msg");
        
        if("done".equals(msg)){
        request.setAttribute("adminadminedit", adminadminedit);
        RequestDispatcher rd = request.getRequestDispatcher("adminadminedit.jsp");
        rd.forward(request, response);
        }
        else if("fail".equals(msg)){
        request.setAttribute("adminadminedit", adminadminedit);
        RequestDispatcher rd = request.getRequestDispatcher("adminadminedit.jsp");
        rd.forward(request, response);
        }
        else{
        request.setAttribute("adminadminedit", adminadminedit);
        RequestDispatcher rd = request.getRequestDispatcher("adminadminedit.jsp");
        rd.forward(request, response);
        }
        
    }

}
