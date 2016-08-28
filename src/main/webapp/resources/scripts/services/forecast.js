
app.factory('forecast',['$http','$timeout',function($http,$timeout){
	return{ 
		
		getAllBooks: function(){
			return $http.get('webServices/getallbooks').success(function(data){
			
					 return data;
			}).error(function(err){
				
				return err;
			});
		
		      
		
	},
	
	getBookInfo: function(item){
		
		//var base_url='http://localhost:8081/AWSMavenGitProject/';
		return $http({
		
			url:"getbook-info/"+item,
			method:'GET'
			
		}).success(function(data){
			
			$scope.book=data;
		});
		
		
		
		
	},
	login:function(credentials){
		
		//var base_url='http://localhost:8081/AWSMavenGitProject/';
		return $http({
		
			url:"login",
			method:'POST',
			params: { username: credentials.username, password: credentials.password }
			
		});
		
	}
	
		};
		
	}]);