
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "contactusServlet", urlPatterns = {"/contactusServlet"})
public class contactusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        int id = (int)session.getAttribute("id");
        String msg = request.getParameter("message");
        
        boolean isTrue = UserDBUtil.contactus(id, msg);
        if(isTrue == true){
            response.sendRedirect("contactus.jsp?msg=done");
        }else{
            response.sendRedirect("contactus.jsp?msg=fail");
        }
        
        
        
    }

}
