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

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String e = (String)session.getAttribute("email");
        
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        boolean isSuccess = UserDBUtil.login(email, pass);
        boolean isAdmin = UserDBUtil.adminlogin(email, pass);
        
        if(isSuccess == true){
            
            session.setAttribute("email", email);
            int id = UserDBUtil.getId(email, pass);
            session.setAttribute("id", id);
            List<Map<String, String>> categories = UserDBUtil.categorySet();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
            rd.forward(request, response);
        }
        else if(isAdmin == true){
            session.setAttribute("email", email);
            response.sendRedirect("adminshoworderServlet");
        }
        else{
            response.sendRedirect("index.jsp?msg=fail");
        }
    }

}
