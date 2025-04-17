package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "deletecartproServlet", urlPatterns = {"/deletecartproServlet"})
public class deletecartproServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        int p_id = Integer.parseInt(request.getParameter("productId"));
        
        boolean isDel = UserDBUtil.deletecartpro(u_id, p_id);
        if(isDel == true){
            response.sendRedirect("cartServlet?msg=prodel");
        }
        
    }

}
