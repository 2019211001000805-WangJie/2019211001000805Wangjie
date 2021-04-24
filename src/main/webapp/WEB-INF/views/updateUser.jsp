<%@ page import="com.wangjie.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User u=(User) session.getAttribute("user");
%>
<h1>User Update</h1>
<form method="post" action="updateUser">
    username:<input type="text" name="username" value="<%=u.getUsername()%>"><br>
    password:<input type="password" name="password" value="<%=u.getPassword()%>"><br>
    Email:<input type="text" name="Email" value="<%=u.getEmail()%>"><br>
    Gender:<input type="radio"  name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked":""%>>Female<br>
    Birthdate:<input type="text name" name="Birthdate" value="<%=u.getBirthdate()%>"><br>
    <input type="submit" value="Save Changes"><br>

</form>
<%@include file="footer.jsp"%>