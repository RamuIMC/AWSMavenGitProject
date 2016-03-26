	/**
 * 
 */
app.controller('SpringSecurityAngJSContr',['$scope','$http',function($scope,$http){

	$http.get('angjs').success(function(data){
		
		$scope.greeting = data;
	});
	
	
}]);