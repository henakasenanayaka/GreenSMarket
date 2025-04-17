
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

@WebServlet("/ordersdetServlet")
public class ordersdetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        int o_id = Integer.parseInt(request.getParameter("msg"));
        
        List<Map<String, String>> ordersdets = UserDBUtil.orderlistproducts(u_id, o_id);
        request.setAttribute("ordersdets", ordersdets);
        RequestDispatcher rd = request.getRequestDispatcher("ordersdet.jsp");
        rd.forward(request, response);
    }
}
