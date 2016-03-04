
app.controller('GetAllBooksController',['$scope','allbooks',function($scope,allbooks){
	
	 /*forecast.getAllBooks().success(function(data){*/
		
		 $scope.books=allbooks.data;
		 
	// });
	
	$scope.title = "AngularJS Application";
}]);