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

@WebServlet(name = "adminproedit", urlPatterns = {"/adminproedit"})
public class adminproeditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        List<Map<String, String>> adminproedits = UserDBUtil.adminproedit(p_id);
        request.setAttribute("adminproedits", adminproedits);
        RequestDispatcher rd = request.getRequestDispatcher("adminproedits.jsp");
        rd.forward(request, response);
    }
}
