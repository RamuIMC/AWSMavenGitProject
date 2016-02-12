
app.factory('forecast',['$http','$timeout',function($http,$timeout){
	return{ 
		
		getAllBooks: function(){
			return $http.get('getallbooks').success(function(data){
			
					 return data;
			}).error(function(err){
				
				return err;
			});
		
		      
		
	}
		};
		
	}]);