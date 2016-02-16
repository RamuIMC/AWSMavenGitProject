
app.factory('forecast',['$http','$timeout',function($http,$timeout){
	return{ 
		
		getAllBooks: function(){
			return $http.get('getallbooks').success(function(data){
			
					 return data;
			}).error(function(err){
				
				return err;
			});
		
		      
		
	},
	
	getBookInfo: function(item){
		
		var base_url='http://localhost:8080/AWSMavenGitProject/';
		return $http({
		
			url:base_url+"/getbook-info/"+item,
			method:'GET'
			
		}).success(function(data){
			
			$scope.book=data;
		});
		
		
		
		
	}
	
		};
		
	}]);