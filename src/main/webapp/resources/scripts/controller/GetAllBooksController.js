
app.controller('GetAllBooksController',['$scope','allbooks',function($scope,allbooks){
	
	 /*forecast.getAllBooks().success(function(data){*/
		
		 $scope.books=allbooks.data;
		 
	// });
	
	$scope.title = "AngularJS Application";
	$scope.priceRange = [0, 6000];
	
	$scope.filterPrice=function(book){
		if(book.price > $scope.priceRange[0] && book.price < $scope.priceRange[1]){
			return true;
		}
		
	};
	$scope.orderByPrice=function(book){
		if($scope.orderBy == "price-low-high"){
			
			return book.price;
		}
		if($scope.orderBy == "price-high-low"){
			
			return -book.price;
		}
		else return book.price;
		
	};
}]);