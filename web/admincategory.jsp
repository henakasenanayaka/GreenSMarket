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
                List<Map<String, String>> adcategory = (List<Map<String, String>>) request.getAttribute("adcategory");
                String msg = request.getParameter("msg");
                if("done".equals(msg)){
            %>
            <h3 align="center" style="color:red">Category Updated!</h3>
            <%}%>
            <%
            if("fail".equals(msg)){
            %>
            <h3 align="center" style="color:red">Something Went WRONG!</h3>
            <%}%>
            <%
            if("del".equals(msg)){
            %>
            <h3 align="center" style="color:red">Category Deleted Successfully!</h3>
            <%}%>
            <%
            if("notdel".equals(msg)){
            %>
            <h3 align="center" style="color:red">Something Went WRONG!</h3>
            <%}%>
            <%
            if("catadd".equals(msg)){
            %>
            <h3 align="center" style="color:red">New Category Added!!</h3>
            <%}%>
            <%
            if("catnotadd".equals(msg)){
            %>
            <h3 align="center" style="color:red">Something Went Wrong. Category NOT added!!!</h3>
            <%}%>
                <table>
                    <a href="adminaddcat.jsp" ><button class="btn">Add a Category</button></a><br><br><br>
                    <tr>
                        <th>Category Image</th>
                        <th>Category Name</th>
                        <th></th>
                    </tr>
                    <% for (Map<String, String> adcategorys : adcategory) { %>
                    <tr>
                        <td><img src="<%= adcategorys.get("image") %>" width="150"></td>
                        <td><%= adcategorys.get("name") %></td>
                        <td>
                            <form action="adcategoryedit" method="get">
                                <input type="hidden" name="id" value="<%= adcategorys.get("id") %>">
                            <input type="submit" name="submit" value="Edit" class="btn">
                            </form>
                            <form action="adcategorydelServlet" method="post">
                            <input type="hidden" name="c_id" value="<%= adcategorys.get("id") %>">
                            <input type="submit" name="submit" value="Delete" class="btn">
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
