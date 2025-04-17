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
            List<Map<String, String>> adcats = (List<Map<String, String>>) request.getAttribute("adcat");
        %>
            <% for (Map<String, String> adcat : adcats) { %>
            <form action="adcateditcheckServlet" method="post">
            <table>
                <tr>
                    <th>Category Name</th>
                    <td>
                        <input type="text" name="name" value="<%= adcat.get("name") %>">
                    </td>
                </tr>
                <tr>
                    <th>Image Url</th>
                    <td><input type="text" name="image" value="<%= adcat.get("image") %>"></td>
                </tr>
            </table>
                <input type="hidden" name="c_id" value="<%= adcat.get("id") %>">
                <input type="submit" name="submit" value="Save" class="btn">
                </form>
                <%}%>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
