<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <title>Store By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Lstyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="adheader.jsp" %>
        <main>
            <%
            List<Map<String, String>> adminsms = (List<Map<String, String>>) request.getAttribute("adminsms");
            %>
            <br>
            <br>
            <br>
            <br>
            <br>
            <h2>Customer Messages</h2>
            <%
                String msg = request.getParameter("msg");
                if("deleted".equals(msg)){
            %>
            <h3 align="center" style="color: red">Message Deleted!</h3>
            <%}%>
            <%
                if("notdeleted".equals(msg)){
            %>
            <h3 align="center" style="color: red">Something Went Wrong!!</h3>
            <%}%>
            <div class="stock-container">
                <table>
                    <tr>
                        <th>Message ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Message</th>
                        <th></th>
                    </tr>
                    <% for (Map<String, String> sms : adminsms) { %>
                    <tr>
                        <td><%= sms.get("msg_id") %></td>
                        <td><%= sms.get("fname") %></td>
                        <td><%= sms.get("lname") %></td>
                        <td><%= sms.get("email") %></td>
                        <td><%= sms.get("msg") %></td>
                        <td>
                            <form action="adminmsgdelServlet" method="post">
                                <input type="hidden" value="<%= sms.get("msg_id") %>" name="msg_id">
                                <input type="Submit" name="del" value="Delete Msg">
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </main>
            <script src="Lscript.js"></script>    
        <%@include file="adfooter.jsp" %>
    </body>
</html>
