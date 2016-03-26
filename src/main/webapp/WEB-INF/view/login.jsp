<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Login Page</title>
</head>
<body>

<div>

<h5>Please Login to the application</h5>

</div>


<c:if test="${param.error != null}">
    <div id="error" style="color: red;" align="center">
        <spring:message code="message.badCredentials"></spring:message>
    </div>
</c:if>

<form id= "form-login" action="<c:url value='/login' />" method="POST" style="float: middle">

<input type="text" name="username">
<br>

<input type="password" name="password">
<br>

<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

<button type="submit"> Login</button>

</form>
</body>
</html>