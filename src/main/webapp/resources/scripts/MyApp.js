var app = angular.module('MyApp', ['ngRoute']);

app.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
	
	$routeProvider.when("/",{
		
		controller:'GetAllBooksController',
		templateUrl:'resources/templates/home.html'
			
	}).when("/second",{
		
		templateUrl:'resources/templates/page2.html'
		
	});
	
	$locationProvider.html5Mode(true);
	
	
}]);