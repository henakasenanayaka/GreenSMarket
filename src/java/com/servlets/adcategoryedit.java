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

@WebServlet(name = "adcategoryedit", urlPatterns = {"/adcategoryedit"})
public class adcategoryedit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int c_id = Integer.parseInt(request.getParameter("id"));
        List<Map<String, String>> adcat = UserDBUtil.admincategoryedit(c_id);
        request.setAttribute("adcat",adcat);
        RequestDispatcher rd = request.getRequestDispatcher("adcatedit.jsp");
        rd.forward(request, response);
    }
}
