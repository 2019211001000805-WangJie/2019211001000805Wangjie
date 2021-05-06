<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1><%= "User Info" %>
    <table>
        <tr>
            <td>username:</td><td><%=request.getAttribute("username")%></td>
        </tr>
        <tr>
            <td>password:</td><td><%=request.getAttribute("password")%></td>
        </tr>
        <tr>
            <td>gender:</td><td><%=request.getAttribute("gender")%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=request.getAttribute("email")%></td>
        </tr>
        <tr>
            <td>birthDate:</td><td><%=request.getAttribute("birthDate")%></td>
        </tr>
    </table>
    <%@ include file="footer.jsp"%>
