
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

@WebServlet(name = "orderlist", urlPatterns = {"/orderlist"})
public class orderlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
                if(email == null){
                    response.sendRedirect("index.jsp?=nouser");
                }else{
                    
        int u_id = (int)session.getAttribute("id");
        List<Map<String, String>> orders = UserDBUtil.getorderdet(u_id);
        request.setAttribute("orders", orders);
        RequestDispatcher rd = request.getRequestDispatcher("orderlist.jsp");
        rd.forward(request, response);
                }
        
    }
}
