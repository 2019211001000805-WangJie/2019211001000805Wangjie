<%@ include file="header.jsp"%>
<h1><%= "Login" %></h1>
<%
    if (request.getAttribute("message")==null){
        out.print("<h2>"+request.getAttribute("message")+"</h2>");
    }
%>
<form method="post" action="login">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="Password" /><br/>
    <input type="submit" name="login" value="Login"/>
</form>
<%@ include file="footer.jsp"%>

