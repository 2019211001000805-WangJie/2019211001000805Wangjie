<%@ page import="com.wangjie.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1><%= "User Info" %></h1>
    <% User user=(User)request.getAttribute("user");
    <table>
        <tr>
            <td>username:</td><td><%=user.getUsername()%></td>
        </tr>
        <tr>
            <td>password:</td><td><%=user.getPassword()%></td>
        </tr>
        <tr>
            <td>gender:</td><td><%=user.getGender()%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=user..getEmail()%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=user.getBirthDate()%></td>
        </tr>
    </table>
    <%@ include file="footer.jsp"%>
