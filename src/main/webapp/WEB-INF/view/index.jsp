<!DOCTYPE html>
<html>
<head>
<base href = "">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <base href ="/AWSMavenGitProject/"> -->
<title>Angular Book Application</title>

<link href="resources/styles/main.css" rel="stylesheet" />
<link href="resources/styles/bootstrap.less" rel="stylesheet" />
<link href="resources/styles/bootstrap.min.css" rel="stylesheet" />
<script src="resources/scripts/angular.js" ></script>
<script src="resources/scripts/angular-route.js" ></script>
<script src="resources/scripts/dropdown.js" ></script>

<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
.login-form {  
	   text-align:center;
	}
#grad {
    background: red; /* For browsers that do not support gradients */
    background: -webkit-linear-gradient(-90deg, green, white); /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(-90deg, green, white); /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(-90deg, green, white); /* For Firefox 3.6 to 15 */
    background: linear-gradient(-90deg, green, white); /* Standard syntax (must be last) */
}
</style>

</head>
<body id="grad" data-ng-app = "MyApp">

<div class="container">
<ul class="nav nav-pills" role="tablist">


			<li class="active"><a href="#/">home</a></li>
			<li><a href="#login" data-ng-show="!authenticated">login</a></li>
			<li data-ng-show="authenticated">
				<a href="">logout</a>
			</li>
		</ul>
</div>

<div class="modal" data-ng-show="loadingView">
  <!-- loadingView is a variable defined in the $rootScope -->

  <!-- The loading animation is inspired by 
    http://codepen.io/joni/details/FiKsd -->
  <ul id="loading">
    <li data-ng-repeat="i in [0,1,2,3,4,5,6,7,8,9]"></li>
  </ul>
  <p>LOADING....</p>
</div>

<div data-ng-view></div>
<!-- <h4>ABA</h4> -->

<script src ="resources/scripts/MyApp.js"></script>
<script src ="resources/scripts/controller/GetAllBooksController.js"></script>
<!-- <script src ="resources/scripts/controller/SpringSecurityAngJSContr.js"></script> -->
<script src ="resources/scripts/controller/NavigationController.js"></script>
 <script src ="resources/scripts/services/forecast.js"></script> 
</body>
</html>