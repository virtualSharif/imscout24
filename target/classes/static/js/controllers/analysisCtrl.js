app.controller('AnalysisCtrl', function($scope, $location, $http) {

	$scope.analyse = function(inputUrl) {
		$http.get("/api/v1/urls/analysis?url=" + inputUrl).then(
				function(response) {
					$scope.data = response.data;
				});
	};

	$scope.validate = function(externalLink) {
		$http.get("/api/v1/urls/statuses?url=" + externalLink.url).then(
				function(response) {
					externalLink.statusDTO = response.data.statusDTO;
				});
	};

	$scope.clear = function() {
		$scope.inputUrl = '';
		$scope.data = undefined;
	};

});
