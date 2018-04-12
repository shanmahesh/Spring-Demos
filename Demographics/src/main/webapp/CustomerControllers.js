var CustomerControllers = angular.module("CustomerControllers", []);
 
CustomerControllers.controller("ListController", ['$scope','$http', 
	function($scope, $http)
		{
	
	 	$scope.persons = [];
	    $scope.form = {
	        prsnId : -1,
	        firstName : "",
	        lastName : "",
	        ssn : ""
	    };
	    
	 	$http({
	 		method : 'GET',
	 		url : 'person'
	 		}).then(function successCallback(response) {
	 				$scope.persons = response.data;
	 		}, function errorCallback(response) {
	 				console.log(response.statusText);
	 				alert(response.statusText);
	 		});
		}]
);
 
CustomerControllers.controller("DetailsController", ['$scope','$http','$routeParams',
	 function($scope, $http, $routeParams)
		{    
			$http.get('js/data.json').success (function(data){
				$scope.guitarVariable = data;
				$scope.whichGuitar = $routeParams.guitarID;
			}); 
		}]
);