<%@ include file="header.jsp"%>
<h1><%= "Welcome to My Online Shop Home Page." %>
</h1>
<form method="get"  target="_blank" action="search">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="Baidu">Baidu</option>
        <option value="Bing">Bing</option>
        <option value="Google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello">Student Info Servlet-week2</a><br/>
<a href="register.jsp">Register-getParameter-week3</a><br/>
<a href="config">Config parameter-week4</a><br/>
<a href="register.jsp">Register JDBC -week4</a><br/>
<a href="index.jsp">include-week5</a><br/>
<a href="login.jsp">Login-week5</a><br/>
<%@ include file="footer.jsp"%>