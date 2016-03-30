<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Login Page</title>
<script   src="https://code.jquery.com/jquery-2.2.2.min.js"   integrity="sha256-36cp2Co+/62rEAAYHLmRCPIych47CvdM+uTBJwSzWjI="   crossorigin="anonymous"></script>
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

<form id= "form-login"  style="float: middle">
<%-- action="<c:url value='/login' />" method="POST" --%>
<input type="text" name="username">
<br>

<input type="password" name="password">
<br>

 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> 

<button type="button"> Login</button>

</form>
<script>
$(document).ready(function(){
	$('button').click(function(){

$.post('login',$('form').serialize(),function(data){
console.log(data)
	
});		
		});
});
</script>
</body>
</html>