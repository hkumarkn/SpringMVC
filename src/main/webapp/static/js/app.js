//Invoke 'strict' JavaScript mode
'use strict';

//Module
angular.module('index', []);

//Controller
angular.module('index').controller('indexCtrl', ['$scope', '$route', '$routeParams', '$location', '$http', function($scope, $route, $routeParams, $location, $http) {
	 $scope.init = function() {
	 	$scope.name="Baseev Kumar";		 
	 },
	 
	 $scope.save = function() {
		var movie = {
		        name: "welcome",
		        actors: "Baseev Kumar"
            	 	};
		 $http.put('/api/movie/saveMovie.json',movie, null).
         success(function(data, status, headers, config) {
        	 alert(data);
             console.log(data);
         }).
         error(function(data, status, headers, config) {
        	 alert(status);
             console.log("error...");
         });
		 return false;
	 },
	 
	 $scope.loadData = function() {
		 $http.post('/api/movie/movieNames.json',{}, null).
         success(function(data, status, headers, config) {
        	 $scope.name=data["1"];
             console.log(data);
         }).
         error(function(data, status, headers, config) {
        	 alert(status);
             console.log("error...");
         });
		 return false;	 
	 }
}]);

//Service
angular.module('index').factory('Index', ['$resource', function($resource) {
	// Use the '$resource' service to return an product '$resource' object
    return $resource('api/products/:productId', {
        productId: '@_id'
    }, {
        update: {
            method: 'PUT'
        }
    });
}]);


//Routes
angular.module('index').config(['$routeProvider', function($routeProvider) {
		$routeProvider.
		when('/products', {
			templateUrl: '/static/views/index.view.html',
			controller: 'indexCtrl'
		}).
		when('/products/create', {
			templateUrl: '/static/view/create-product.client.view.html'
		}).
		when('/products/:productId', {
			templateUrl: '/static/view/view-product.client.view.html'
		}).
		when('/products/:productId/edit', {
			templateUrl: '/static/view/edit-product.client.view.html'
		})
	}

]); 


// Set the main application name
var mainApplicationModuleName = 'myApp';

// Create the main application
var mainApplicationModule = angular.module(mainApplicationModuleName, ['ngResource', 'ngRoute', 'index']);

// Configure the hashbang URLs using the $locationProvider services 
mainApplicationModule.config(['$locationProvider',
	function($locationProvider) {
		$locationProvider.hashPrefix('!');
	}
]);

// Fix Facebook's OAuth bug
if (window.location.hash === '#_=_') window.location.hash = '#!';

// Manually bootstrap the AngularJS application
angular.element(document).ready(function() {
	angular.bootstrap(document, [mainApplicationModuleName]);
});