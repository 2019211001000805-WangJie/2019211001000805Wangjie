<%@ page import="com.wangjie.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1><%= "User Info" %></h1>
    <% User u=(User)session.getAttribute("user");%>
    <table>
        <tr>
            <td>username:</td><td><%=u.getUsername()%></td>
        </tr>
        <tr>
            <td>password:</td><td><%=u.getPassword()%></td>
        </tr>
        <tr>
            <td>gender:</td><td><%=u.getGender()%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=u.getEmail()%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=u.getBirthdate()%></td>
        </tr>
    </table>
    <%@ include file="footer.jsp"%>
