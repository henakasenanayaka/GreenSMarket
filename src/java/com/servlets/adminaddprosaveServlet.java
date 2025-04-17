
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminaddprosaveServlet", urlPatterns = {"/adminaddprosaveServlet"})
public class adminaddprosaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int c_id = Integer.parseInt(request.getParameter("category"));
        String pname = request.getParameter("pname");
        String img = request.getParameter("img");
        int stock = Integer.parseInt(request.getParameter("stock"));
        int price = Integer.parseInt(request.getParameter("price"));
        String availability = request.getParameter("availability");
        
        boolean isDone = UserDBUtil.adminsavepro(c_id, pname, img, stock, price, availability);
        if(isDone == true){
            response.sendRedirect("adminproServlet?msg=save");
        }else{
            response.sendRedirect("adminproServlet?msg=notsave");
        }
        
    }
}
