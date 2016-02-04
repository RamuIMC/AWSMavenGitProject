<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="resources/js/jquery.min.js"></script>

<script src="resources/js/moment.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-datetimepicker.min.js"></script>

<script src="resources/js/angular.min.js"></script>
  <script src="resources/js/ngDialog.min.js"></script>

 <link href="resources/css/main.css" rel="stylesheet" /> 
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />

<link rel="stylesheet" href="resources/css/ngDialog.min.css" />
<link rel="stylesheet" href="resources/css/ngDialog-theme-plain.css" />

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css">



<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet"> -->
</head>
<body ng-app="myApp"  >
<div style="height:50px"></div>
<form class="form-horizontal" role="form" ng-controller="MyController" ng-submit="postData(book)">

	<div class="form-group" >
		<label for="bookName" class="col-sm-2 control-label">Book Name :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="bookName" name="bookName" placeholder="Enter Book Name" ng-model="book.bookName">
	
			<p>{{book.bookName}}</p>
		</div>
	</div>
	
	<div class="form-group">
		<label for="bookAuthor" class="col-sm-2 control-label">Book Author :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" name="bookAuthor" id="bookAuthor" placeholder="Enter Book Author" ng-model="book.bookAuthor">
	
			<p>{{book.bookAuthor}}</p>
	
		</div>
	</div>
	<div class="container" >
    <div class="row" >
    	<label for="pubdate" class="col-sm-2 control-label" style="margin-left:-74px;">Publish Date :</label>
        <div class='col-sm-4'>
        <!--  <input data-format="MM/dd/yyyy" type='text' class="form-control" id='datetimepicker4' name="pubdate" ng-model="book.pubdate"/> -->
        <input type="date" id="exampleInput"  class="form-control" name="input" ng-model="book.pubdate" placeholder="yyyy-MM-dd" min="2013-01-01" max="2099-12-31" required />
        </div>

        <tt>pubdate ={{ book.pubdate | date: "yyyy-MM-dd HH:mm:ss"}} </tt>
    </div>
</div>
<div class="form-group" style="padding-top:24px;">
<label for ="country" class="col-sm-2 control-label">Country :</label>
<div class="col-sm-4">

<select id="country" name="country" class="form-control" ng-model="book.country">
          <option value="India">India</option>
          <option value="United States">United States</option>
          <option value="NewZealand">NewZealand</option>
        </select> 
</div>
</div>

<div class="form-group">
<label for="language" class="col-sm-2 control-label" style="margin-left:-10px;">Language :</label>
<div class="col-sm-4">
<label class="radio-inline"><input type="radio"  ng-model="book.language" value="English">English</label>
<label class="radio-inline"><input type="radio" ng-model="book.language" value="Hindi">Hindi</label>
<label class="radio-inline"><input type="radio" ng-model="book.language" value="Telugu">Telugu</label><br>
<tt>language= {{book.language}}</tt>
</div>


</div>

<div class="form-group">
<label for="genre" class="col-sm-2 control-label" style="margin-left:-10px;">Genre :</label>
<div class="col-sm-4">
<label class="checkbox-inline" ng-repeat="eachGenre in genres"> 
<input type="checkbox" checklist-model="book.genre" checklist-value="eachGenre">{{eachGenre}}</label> 

</div>
<tt>Genre= {{book.genre}}</tt>
</div>

<div class="form-group">
		<label for="bookSeries" class="col-sm-2 control-label">Book Series :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="bookSeries" name="bookSeries" placeholder="Enter Book Series" ng-model="book.series">
	
			<p>{{book.series}}</p>
	
		</div>
	</div>
	<div class="form-group">
		<label for="bookPages" class="col-sm-2 control-label">Book Pages :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="bookPages" placeholder="Enter Book Pages" ng-model="book.pages">
	
			<p>{{book.pages}}</p>
	
		</div>
	</div>
	
		<div class="form-group">
		<label for="bookPrice" class="col-sm-2 control-label">Book Price :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="price" placeholder="Enter Book Price" ng-model="book.price.price">
	
			<p>{{book.price.price}}</p>
	
		</div>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form>

<script src="resources/js/app.js"></script>

<script src="resources/js/checklist-model.js"></script>
 <!-- Controllers -->
<script src="resources/controller/MyController.js"></script>

<!-- Services -->
<script src="resources/services/forecast.js"></script>

</body>
</html>