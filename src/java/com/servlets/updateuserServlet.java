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

@WebServlet("/updateuserServlet")
public class updateuserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String add = request.getParameter("add");
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        
        boolean isTrue = UserDBUtil.userupdate(id, fname, lname, email, pass, add, mobile);
        if(isTrue == true){
            List<Map<String, String>> userDetails = UserDBUtil.updateduserDetails(id);
            request.setAttribute("userDetails", userDetails);
            RequestDispatcher rd = request.getRequestDispatcher("userdetails.jsp");
            rd.forward(request,response);
        }else{
            List<Map<String, String>> userDetails = UserDBUtil.updateduserDetails(id);
            request.setAttribute("userDetails", userDetails);
            RequestDispatcher rd = request.getRequestDispatcher("userdetails.jsp?msg=fail");
            rd.forward(request,response);
        }
        
        
    }


}
