package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adcateditcheckServlet", urlPatterns = {"/adcateditcheckServlet"})
public class adcateditcheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        
        boolean isDone = UserDBUtil.admincategoryeditcheck(c_id, name, image);
        if(isDone == true){
            response.sendRedirect("admincategoryServlet?msg=done");
        }else{
            response.sendRedirect("admincategoryServlet?msg=fail");
        }
    }
}
