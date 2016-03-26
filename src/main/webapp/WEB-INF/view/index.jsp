<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <base href ="/AWSMavenGitProject/"> -->
<title>Angular Book Application</title>

<link href="resources/styles/main.css" rel="stylesheet" />
<link href="resources/styles/bootstrap.less" rel="stylesheet" />
<script src="resources/scripts/angular.js" ></script>
<script src="resources/scripts/angular-route.js" ></script>

<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}

</style>

</head>
<body data-ng-app = "MyApp">

<div data-ng-controller="NavigationController as nav" class="container">
<ul class="nav nav-pills" role="tablist">


			<li class="active"><a href="#/">home</a></li>
			<li><a href="#login">login</a></li>
			<li data-ng-show="authenticated"><a href="" data-ng-click="nav.logout()">logout</a></li>
		</ul>
</div>
<h2>ng-view example</h2>

<div class="modal" data-ng-show="loadingView">
  <!-- loadingView is a variable defined in the $rootScope -->

  <!-- The loading animation is inspired by 
    http://codepen.io/joni/details/FiKsd -->
  <ul id="loading">
    <li data-ng-repeat="i in [0,1,2,3,4,5,6,7,8,9]"></li>
  </ul>
  <p>LOADING....</p>
</div>

<a href ="#second">Second Page</a>

<div data-ng-view></div>
<!-- <h4>ABA</h4> -->

<script src ="resources/scripts/MyApp.js"></script>
<script src ="resources/scripts/controller/GetAllBooksController.js"></script>
<script src ="resources/scripts/controller/SpringSecurityAngJSContr.js"></script>
<script src ="resources/scripts/controller/NavigationController.js"></script>
 <script src ="resources/scripts/services/forecast.js"></script> 
</body>
</html>