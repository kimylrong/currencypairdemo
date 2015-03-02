angular.module('mainApp', ['ngRoute','ngResource', 'ab-base64', 'ngSanitize']);

angular.module('mainApp').factory('TradeResource', function($resource){
	return $resource('api/rest/trade');
});

angular.module('mainApp').controller('TradeListController', function($scope, $location, 
	$interval, TradeResource){

  	function query(){
  		$scope.trades = TradeResource.query();
  	}

	function init(){
		query();
		
		$scope.stop = $interval(query, 5000);
	}

	init();

	$scope.$on('$destroy', function() {
        // Make sure that the interval is destroyed too
        if($scope.stop){
        	$interval.cancel($scope.stop)
        }
    });

    $scope.inputtrade = function(){
    	$location.path('/tradeinput');
    }
});

angular.module('mainApp').controller('TradeInputController', function($scope, 
	$location, TradeResource){

	$scope.save = function(){
		TradeResource.save({}, $scope.trade, function(){
			alert("success")
			$location.path("/");
		}, function(){
			alert("input trade failed.");
		});
	}
});

angular.module('mainApp').config(function($routeProvider){
	$routeProvider.when('/', {controller: 'TradeListController', templateUrl: 'static/app/tradelist.html'});
});

angular.module('mainApp').config(function($routeProvider){
	$routeProvider.when('/tradeinput', {controller: 'TradeInputController', templateUrl: 'static/app/tradeinput.html'});
});