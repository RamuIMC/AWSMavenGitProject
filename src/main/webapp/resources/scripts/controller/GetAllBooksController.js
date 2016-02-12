/**
 * 
 */

app.controller('GetAllBooksController',['$scope','forecast',function($scope,forecast){
	
	 forecast.getAllBooks().success(function(data){
		
		 $scope.books=data;
		 
	 });
	
	$scope.title = "AngularJS Application";
}]);