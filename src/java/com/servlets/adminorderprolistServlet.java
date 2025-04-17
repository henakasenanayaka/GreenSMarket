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

@WebServlet(name = "adminorderprolistServlet", urlPatterns = {"/adminorderprolistServlet"})
public class adminorderprolistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int o_id = Integer.parseInt(request.getParameter("msg"));
        
        List<Map<String, String>> orderpros = UserDBUtil.adminorderprolist(o_id);
        List<Map<String, String>> adminorderuserlist = UserDBUtil.adminorderuserlist(o_id);
        request.setAttribute("adminorderuserlist", adminorderuserlist);
        request.setAttribute("orderpros", orderpros);
        RequestDispatcher rd = request.getRequestDispatcher("adminorderprolist.jsp?msg="+o_id);
        rd.forward(request, response);
    }
}
