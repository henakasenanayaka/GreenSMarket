package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminprosaveServlet", urlPatterns = {"/adminprosaveServlet"})
public class adminprosaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        int stock = Integer.parseInt(request.getParameter("stock"));
        int price = Integer.parseInt(request.getParameter("price"));
        String availability = request.getParameter("availability");
        
        boolean isDone = UserDBUtil.adminupdatepro(p_id, img, name, stock, price, availability);
        if(isDone == true){
            response.sendRedirect("adminproServlet?msg=done");
        }else{
            response.sendRedirect("adminproServlet?msg=fail");
        }
    }
}
