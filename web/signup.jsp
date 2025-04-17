<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Tstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <%
            String msg = request.getParameter("msg");
            
            if("signfail".equals(msg)){
        %>
        <h2>Some thing went wrong try again!</h2>
        <%
            }
        %>
        <main>
        <div class="registration-form">
            <h1>Registration Form</h1>
        <form action="signupServlet" method="post">
            <p>First Name :</p> <input type="text" name="fname" required>
            <p>Last Name :</p> <input type="text" name="lname" required>
            <p>Email :</p> <input type="email" name="email" required>
            <p>Password :</p> <input type="password" name="pass" required>
            <p>Address:</p> <input type="text" name="add" required>
            <p>Phone Number :</p> <input type="number" name="phone" required>
            <p></p>
            <p></p>
            <input type="submit" value="Sign Up" class="btn">
        </form>
            </div>
            </main>
        <%@ include file="footer.jsp"%>
        <script src="Tscript.js"></script>
    </body>
</html>
