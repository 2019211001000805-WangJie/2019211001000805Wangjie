<%@ include file="header.jsp"%>
<form method="post" action="register">
    Username:<input type="text" name="username" placeholder="Username"/><br/>
    Password:<input type="password" name="Password" placeholder="Password"/><br/>
    Email:<input type="text" name="Email" placeholder="Email"/><br/>
    Gender:<input type="radio" name="Gender" value="male">Male<input type="radio" name="Gender" value="female">Female<br/>
    Date of Birth:<input type="text" name="birthdate" placeholder="Date of Birth(yyyy-mm-dd)"><br/>
    <input type="submit" name="register" value="Register"/>
</form>
<%@ include file="footer.jsp"%>