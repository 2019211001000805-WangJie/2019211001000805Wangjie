<%@ include file="header.jsp"%>
<h1><%= "Login" %></h1>
<form method="post" action="login">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="Password" /><br/>
    <input type="submit" name="login" value="Login"/>
</form>
<%@ include file="footer.jsp"%>
