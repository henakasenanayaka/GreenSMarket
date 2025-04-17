<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Dstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <%
                if(session.getAttribute("email") != null){
                String email = (String)session.getAttribute("email");
                
            %>
            <div class="container" style="padding-top:120px;"></div>
            <h2>Get in Touch</h2>
            <form action="contactusServlet" method="post">
            <div class="contact-form">
                <div class="form-group">
                <label for="email">Your Email:</label>
                <input type="email" id="email" name="email" value="<%=email%>" readonly required>
                <%
                    }else{
                        response.sendRedirect("index.jsp?msg=nouser");
                    }
                %>
                </div>

                <div class="form-group">
                <label for="message">Your Message:</label>
                <textarea id="message" name="message" rows="5" required></textarea>
                </div><%
                    String msg = request.getParameter("msg");
                    if("done".equals(msg)){
                %>
                <h2 align="center" style="color: red">Message Sent Successfully!</h2>
                <%}%>
                <%
                    if("fail".equals(msg)){
                %>
                <h2 align="center" style="color: red">Something went WRONG!!</h2>
                <%}%>
                <input type="submit" name="submit" value="Submit">
        </div></form>
        </main>
        
        <script src="Dscript.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
