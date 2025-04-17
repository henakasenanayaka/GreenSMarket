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
import javax.servlet.http.HttpSession;

@WebServlet(name = "categoryServlet", urlPatterns = {"/categoryServlet"})
public class categoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        
        if( email != null){
            List<Map<String, String>> categories = UserDBUtil.categorySet();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
            rd.forward(request, response);
        }else{
            response.sendRedirect("index.jsp?msg=nouser");
        }
    }

}
