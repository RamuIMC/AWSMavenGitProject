var app = angular.module('MyApp', ['ngRoute']);


/*app.controller('SocialController', function($window, $scope) {
	$scope.shareOnFacebook = function() {
		$window.location.replace("social/facebook/signin");
	};
	$scope.shareOnTwitter = function() {
		$window.location.replace("social/twitter/signin");
	};
});*/

app.config(['$routeProvider',function($routeProvider){
	
	$routeProvider.when("/getallbooks",{
		
		controller:'GetAllBooksController',
		templateUrl:'resources/templates/home.html',
		resolve :{
			
			allbooks : function(forecast){
				return forecast.getAllBooks();
				
			}
		}
			
	}).when("/second",{
		
		templateUrl:'resources/templates/page2.html'
		
	})
	.when("/login",{
		
		templateUrl:'resources/templates/login.html'/*,
		controller: 'NavigationController',
		controllerAs: 'controller'*/
		
		
	});
	
	//$locationProvider.html5Mode(true);
	
	//$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);



/*
app.run(['$rootScope', function($root) {
	  $root.$on('$routeChangeStart', function(e, curr, prev) { 
	    if (curr.$$route && curr.$$route.resolve) {
	      // Show a loading message until promises aren't resolved
	      $root.loadingView = true;
	    }
	  });
	  $root.$on('$routeChangeSuccess', function(e, curr, prev) { 
	    // Hide loading message
	    $root.loadingView = false;
	  });
	}]);*/