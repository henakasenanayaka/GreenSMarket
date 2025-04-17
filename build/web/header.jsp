<%@page import="com.servlets.UserDBUtil"%>
<header class="header">
        <a href="index.jsp" class="logo"> Celon Super Market</a>


        <nav class="navbar">
            <a href="index.jsp">Home</a>
<!--        <a href="#features">Features</a>-->
            <a href="orderServlet">Current Order Page</a>
            <a href="categoryServlet">Categories</a>
            <a href="orderlist">Your Orders</a>
        </nav>


        <div class="icons">
            <div class="fa fa-bars" id="menu-btn"></div>
            <div class="fa fa-search" id="search-btn"></div>
            <a href="cartServlet"><div class="fa fa-shopping-cart" id="cart-btn"></div></a>
            <div class="fa fa-user" id="login-btn"></div>
        </div>


        <form class="search-form">
            <input type="search" id="search-box" placeholder="Search Here...">
            <label for="search-box" class="fa fa-search"></label>
        </form>
        <form action="loginServlet" method="post" class="login-form">
<% 
  String e = (String) session.getAttribute("email");
  session.setAttribute("email", e);
  
  boolean isTrue = UserDBUtil.checkadmin(e);
  
  if(isTrue == true){
    response.sendRedirect("adminshoworderServlet");
    }
  
  if(e == null){
%>
        
            <h3>Login Now</h3>
            <%
                String msg = request.getParameter("msg");
                if("signdone".equals(msg))
                {
            %>
                <h1>Sign up Success</h1>
                <h4>Please Log in to continue</h4>
            <%
                }
            %>
            <input type="email" placeholder="Your email" name="email" class="box" required>
            <input type="password" placeholder="Your password" name="pass" class="box" required>

            <p>Forget Your Password <a href="#"> Click Here </a></p>
            <p>Don't Have An Acoount <a href="signup.jsp"> Create Now </a></p>

            <input type="submit" value="Login Now" class="btn">
        
<%
    }else{
%>
    <h3>Welcome</h3>
    <p><%=e%></p>
    <p><a href="logout">Logout</a></p>
    <a href="userdetails"><p>click here to see your details</p></a>
<%}%>
</form>

    </header>