package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "orderdetServlet", urlPatterns = {"/orderdetServlet"})
public class orderdetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int u_id = (int)session.getAttribute("id");
        double total = Double.parseDouble(request.getParameter("total"))+300.;
        
        boolean isTrue = UserDBUtil.isaddedorderdet(u_id);
        if(isTrue != true){
            boolean isDone = UserDBUtil.addorderdet(total, u_id);
            if(isDone == true){
                int order_id = UserDBUtil.getorderdetid(u_id);
                boolean isAdded = UserDBUtil.addtoorderproduct(u_id, order_id);
                if(isAdded == true){
                    boolean isDel = UserDBUtil.deletecartdet(u_id);
                    if(isDel == true){
                        response.sendRedirect("cartServlet?msg=orderadded;");
                    }else{
                        response.sendRedirect("cartServlet?msg=servererror");
                    }
                }else{
                    response.sendRedirect("cartServlet?msg=servererror");
                }
            }else{
                response.sendRedirect("cartServlet?msg=servererror");
            }
        }
        else{
            response.sendRedirect("cartServlet?msg=allreadyadded");
        }
        
    }

}
