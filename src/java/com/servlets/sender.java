package com.servlets;

import static com.servlets.SendMailWithAttachment.send;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "sender", urlPatterns = {"/sender"})
public class sender extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        SendMailWithAttachment objSender = new SendMailWithAttachment();
        String senderEmail = "email";
        String senderPassword = "ggdg tfex djox smuk"; // replace with your Gmail password
        String recipientEmail = "nadeeshanipeshala@gmail.com";
        objSender.send(senderEmail, senderPassword, recipientEmail,"asdasd","adas");
    }
}
