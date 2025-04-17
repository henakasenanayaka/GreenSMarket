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
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
        <%
        List<Map<String, String>> adminshowadmins = (List<Map<String, String>>) request.getAttribute("adminshowadmins");
        %>
        <!--2-->
        <a href="addadmin.jsp"><button class="btn">Add New Admin</button></a><br><br>
        <%
                String msg = request.getParameter("msg");
                if("done".equals(msg)){
            %>
        <h3 align="center" style="color: red">Updated Successfully!</h3>
        <%}%>
        <%
            if("fail".equals(msg)){
        %>
        <h3 align="center" style="color: red">Update Failed!</h3>
        <%}%>
        <%
            if("del".equals(msg)){
        %>
        <h3 align="center" style="color: red">Deleted Successfully!</h3>
        <%}%>
        <%
            if("notdel".equals(msg)){
        %>
        <h3 align="center" style="color: red">Deletion Failed!</h3>
        <%}%>
        <table>
            <tr>
                <th>Admin Id</th>
                <th>Admin Email</th>
                <th>Password</th>
                <th></th>
            </tr>
            <% for (Map<String, String> showadmin : adminshowadmins) { %>
            <tr>
                <td><%= showadmin.get("a_id") %></td>
                <td><%= showadmin.get("email") %></td>
                <td><%= showadmin.get("pass") %></td>
                <td>
                    <form action="admineditadminServlet" method="post">
                    <input type="hidden" name="id" value="<%=showadmin.get("a_id")%>">
                    <input type="submit" name="submit" value="EDIT" class="btn">
                    </form>
                    <form action="admindeleteServlet" method="post">
                    <input type="hidden" name="id" value="<%=showadmin.get("a_id")%>">
                    <input type="submit" name="submit" value="DELETE" class="btn">
                    </form>
                </td>
            </tr>
            
            
            <%}%>
        </table>
        <script src="Lscript.jsp"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
