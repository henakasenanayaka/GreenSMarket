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
                List<Map<String, String>> cats = (List<Map<String, String>>) request.getAttribute("cats");
            %>
            <form action="adminaddprosaveServlet" method="post">
            <table>
                <tr>
                    <th>Category</th>
                    <td>
                        <select name="category">
                            <% for (Map<String, String> cat : cats) { %>
                            <option value="<%= cat.get("c_id") %>"><%= cat.get("c_name") %></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Product Name</th>
                    <td><input type="text" name="pname"></td>
                </tr>
                <tr>
                    <th>Image URL</th>
                    <td><input type="text" name="img"></td>
                </tr>
                <tr>
                    <th>Stock</th>
                    <td><input type="number" name="stock"></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input type="number" name="price"></td>
                </tr>
                <tr>
                    <th>Availability</th>
                    <td>
                        <select name="availability">
                            <option value="YES">YES</option>
                            <option value="NO">NO</option>
                        </select>
                    </td>
                </tr>
            </table>
                        <input type="submit" value="Save" class="btn">
            </form>
        </main>
        <script src="Lscript.jsp"></script>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
