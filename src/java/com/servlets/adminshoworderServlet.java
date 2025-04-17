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

@WebServlet(name = "adminshoworderServlet", urlPatterns = {"/adminshoworderServlet"})
public class adminshoworderServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, String>> showorders = UserDBUtil.adminshoworder();
        request.setAttribute("showorders", showorders);
        RequestDispatcher rd = request.getRequestDispatcher("adminorder.jsp");
        rd.forward(request, response);
    }
}
