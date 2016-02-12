<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angular Book Application</title>

<link href="resources/styles/main.css" rel="stylesheet" />
<link href="resources/styles/bootstrap.min.css" rel="stylesheet" />
<script src="resources/scripts/angular.min.js" ></script>

</head>
<body data-ng-app = "MyApp" data-ng-controller = "GetAllBooksController">

<h2>{{ title }}</h2>


<div class= "main">
<div class= "container">
<div class= "col-xs-2"></div>
<div class= "col-xs-9">
<div data-ng-repeat="book in books" class="col-md-4">

<p > {{book.price | currency}}</p>
<p > {{book.bookName}}</p>
<p > {{book.bookAuthor}}</p>
<span >Genre: </span>
<span  data-ng-repeat="genre in book.genre"> {{genre}}</span>
<p  data-ng-show="book.series"> Series: {{book.series}}</p>

<p > {{book.pubDate | date}}</p>




</div>




</div>



</div>



</div>

<script src ="resources/scripts/MyApp.js"></script>
<script src ="resources/scripts/controller/GetAllBooksController.js"></script>
 <script src ="resources/scripts/factory/forecast.js"></script> 
</body>
</html>