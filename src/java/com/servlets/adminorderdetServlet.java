
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminorderdet", urlPatterns = {"/adminorderdet"})
public class adminorderdetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int o_id = Integer.parseInt(request.getParameter("o_id"));
        String msg = request.getParameter("status");
        String sub = "Celon Green Super Market";
        String message = "This is a an email to inform that your order id :"+o_id+" is Currently in :"+msg+". Thank you for Connecting with us";
        String email = UserDBUtil.getemailbyoid(o_id);
        
        boolean isDone = UserDBUtil.adminorderupdate(msg, o_id);
        
        if(isDone = true){
            response.sendRedirect("adminshoworderServlet?msg=updated");
            SendMailWithAttachment objSender = new SendMailWithAttachment();
            String senderEmail = "gembanuge@gmail.com";
            String senderPassword = "ggdg tfex djox smuk"; // replace with your Gmail password
            String recipientEmail = email;
            objSender.send(senderEmail, senderPassword, recipientEmail,sub,message);
        }else{
            response.sendRedirect("adminshoworderServlet?msg=notupdated");
        }
    }

}
