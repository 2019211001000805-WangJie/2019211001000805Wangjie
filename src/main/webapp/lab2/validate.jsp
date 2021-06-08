<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>

<jsp:useBean id="user" class="com.lab2.Login" scope="request">
    <jsp:setProperty name="user" property="username"/>
    <jsp:setProperty name="user" property="password"/>
</jsp:useBean>

<%
    //todo 3: use if check username is admin and ppassword is admin
    if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
<%--todo 5: else part{ --%>

<%
}else{
    out.println("username password error");
// todo 6: print username or password error message
%>

<%--todo 7: use jsp:include login.jsp page --%>
<%--todo 8: close else --%>
<jsp:include page="login.jsp"></jsp:include>
<%
    }
%>
</body>
</html> 