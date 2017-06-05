var app  =  angular.module('immobilienScout24App', ['ngRoute']);

app.config(function ($routeProvider) {

    $routeProvider.when('/analysis', {
            templateUrl: 'partials/analysis.html',
            controller: 'AnalysisCtrl'
        });

    $routeProvider.otherwise({
        redirectTo: '/analysis'
    });

});
