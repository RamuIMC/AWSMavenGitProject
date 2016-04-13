<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AngularJS Login Page</title>
 <script src="resources/scripts/jquery-1.8.0.min.js"></script> 

<!-- <script src="resources/js/moment.min.js"></script>

Latest compiled and minified JavaScript
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-datetimepicker.min.js"></script> -->

<script src="resources/scripts/angular.min.js"></script>
<!--   <script src="resources/js/ngDialog.min.js"></script> -->

 <link href="resources/css/main.css" rel="stylesheet" /> 
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
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

<form id= "form-login"  style="float: middle"
action="<c:url value='/login' />" method="POST">
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
console.log(data);
$.get('webServices/getallbooks',function(data){

console.log("getallbooks" +data);
	
})
	
});		
		});
});
</script> 

<!-- <h2>Spring Social</h2>
<div data-ng-app="MyApp">
	<div data-ng-controller="SocialController">
		<button data-ng-click='shareOnFacebook()'>Post on Facebook</button>
		<button data-ng-click='shareOnTwitter()'>Tweet on Twitter</button>
	</div>
</div> -->

<script src="resources/scripts/MyApp.js"></script>
</body>
</html>