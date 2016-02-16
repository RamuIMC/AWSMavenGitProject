var app = angular.module('MyApp', ['ngRoute']);

app.config(['$routeProvider',function($routeProvider){
	
	$routeProvider.when("/",{
		
		controller:'GetAllBooksController',
		templateUrl:'resources/templates/home.html'
			
	}).when("/second",{
		
		templateUrl:'resources/templates/page2.html'
		
	});
	
	
}]);