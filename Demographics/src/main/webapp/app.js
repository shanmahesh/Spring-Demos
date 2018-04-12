var app = angular.module('CustomerManagement', [  
	  'ngRoute',
	  'CustomerControllers']);

	 
	app.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	  when('/list', {
		    templateUrl: 'person/list.html',
		    controller: 'ListController'
		  }).
		  when('/details/:prsnId', {
		    templateUrl: 'person/details.html',
		    controller: 'DetailsController'
		  }).
		  when('/', {
			    templateUrl: 'search.html'
			  }).
		  otherwise({
		    redirectTo: '/'
	  });
	}]);