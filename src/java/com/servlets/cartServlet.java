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

@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
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
            response.sendRedirect("index.jsp?msg=nouser");
        }else{
            int u_id = (int)session.getAttribute("id");
        String msg = request.getParameter("msg");
        List<Map<String, String>> cartdets = UserDBUtil.getcart(u_id);
        if("fail".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=fail");
        rd.forward(request, response);
        }
        else if("done".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=done");
        rd.forward(request, response);
        }
        else if("orderadded".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=orderdone");
        rd.forward(request, response);
        }
        else if("servererror".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=servererror");
        rd.forward(request, response);
        }
        else if("allreadyadded".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=orderin");
        rd.forward(request, response);
        }
        else if("prodel".equals(msg)){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp?msg=prodel");
        rd.forward(request, response);
        }
        else if( email != null){
        request.setAttribute("cartdets", cartdets);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
        }else{
            response.sendRedirect("index.jsp?msg=nouser");
        }
        }
        
    }
}
