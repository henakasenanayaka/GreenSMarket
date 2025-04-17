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

@WebServlet(name = "addtocartServlet", urlPatterns = {"/addtocartServlet"})
public class addtocartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p_id = Integer.parseInt(request.getParameter("p"));
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        
        boolean isAdded = UserDBUtil.allredyaddedtocart(u_id, p_id);
        if(isAdded == true){
            String categoryName = (String)session.getAttribute("categoryName");
            response.sendRedirect("productServlet?c="+categoryName+"&msg=allreadyadded");
            session.removeAttribute("categoryName");
        }else{
        boolean isTrue = UserDBUtil.cartadd(u_id, p_id);
        if(isTrue == true){
                String categoryName = (String)session.getAttribute("categoryName");
                response.sendRedirect("productServlet?c="+categoryName+"&msg=added");
        }else{
            String categoryName = (String)session.getAttribute("categoryName");
                response.sendRedirect("productServlet?c="+categoryName+"&msg=fail");
        }
        }
    }

}
