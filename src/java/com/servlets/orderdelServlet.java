package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "orderdelServlet", urlPatterns = {"/orderdelServlet"})
public class orderdelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        int o_id = UserDBUtil.getorderdetid(u_id);
        boolean isDel = UserDBUtil.orderdel(o_id);
        if(isDel == true){
            response.sendRedirect("index.jsp?msg=orderdeleted");
        }else{
            response.sendRedirect("index.jsp?msg=orderdeleted1");
        }
    }

}
