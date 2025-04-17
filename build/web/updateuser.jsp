<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Ustyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Edit Customer Details</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <div class="container" style="padding-top: 60px;">
        <h1>Edit Customer Details</h1>
        <%
          int id = Integer.parseInt(request.getParameter("id"));
          String fname = request.getParameter("fname");
          String lname = request.getParameter("lname");
          String email = request.getParameter("email");
          String pass = request.getParameter("pass");
          String add = request.getParameter("add");
          String mobile = request.getParameter("mobile");
        %>
        
        <form action="updateuserServlet" method="post">
            <table>
            <tr>
                <th>User ID</th>
                <td><input type="text" name="id" value="<%=id%>" class="box" readonly></td>
            </tr>
            <tr>
                <th><label for="firstName">First Name</label></th>
                <td><input type="text" name="fname" value="<%=fname%>" class="box" required></td>
            </tr>
            <tr>
                <th><label for="lastName">Last Name</label></th>
                <td><input type="text" name="lname" value="<%=lname%>" required></td>
            </tr>
            <tr>
                <th><label for="email">Email</label></th>
                <td><input type="email" name="email" value="<%=email%>" required></td>
            </tr>
            <tr>
                <th><label for="password">Password</label></th>
                <td><input type="password" name="pass" value="<%=pass%>" required></td>
            </tr>
            <tr>
                <th><label for="address">Address</label></th>
                <td><input type="text" name="add" value="<%=add%>" required></td>
            </tr>
            <tr>
                <th><label for="mobileNo">Mobile No.</label></th>
                <td><input type="text" name="mobile" value="<%=mobile%>" required></td>
            </tr>
        </table>
            <div class="button-container">
            <input type="submit" value="Save">
            </div>   </form>
            </div>
     
            </main>
            <%@include file="footer.jsp" %>
            <script src="Uscript.js"></script>
    </body>
</html>
