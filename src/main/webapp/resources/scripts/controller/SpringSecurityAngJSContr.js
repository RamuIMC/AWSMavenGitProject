	/**
 * 
 */
app.controller('SpringSecurityAngJSContr',['$scope','$http',function($scope,$http){

	$http.get('webServices/angjs').success(function(data){
		
		$scope.greeting = data;
	});
	
	
}]);