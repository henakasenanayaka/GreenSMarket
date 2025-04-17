
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "orderdoneServlet", urlPatterns = {"/orderdoneServlet"})
public class orderdoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        boolean isSet = UserDBUtil.orderset(u_id);
        if(isSet == true){
            response.sendRedirect("index.jsp?msg=orderplaced");
        }
    }

}
