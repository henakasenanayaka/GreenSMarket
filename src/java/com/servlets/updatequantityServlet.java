
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "updatequantityServlet", urlPatterns = {"/updatequantityServlet"})
public class updatequantityServlet extends HttpServlet {

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
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        boolean isTrue = UserDBUtil.updatequantity(u_id, p_id, quantity);
        if(isTrue == true){
            response.sendRedirect("cartServlet?msg=done");
        }else{
            response.sendRedirect("cartServlet?msg=fail");
        }
    }

}
