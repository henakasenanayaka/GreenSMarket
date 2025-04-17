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
            <form action="adminaddcatServlet" method="post">
            <table>
                <tr>
                    <th>Enter Category Name :</th>
                    <td><input type="text" name="cname"></td>
                </tr>
                <tr>
                    <th>Enter Category Image Url :</th>
                    <td><input type="text" name="img"></td>
                </tr>
            </table>
                <input type="submit" value="Add Category" class="btn">
            </form>
            <script src="Lscript.jsp"></script>
        </main>
        <%@include file="adfooter.jsp" %>
    </body>
</html>
