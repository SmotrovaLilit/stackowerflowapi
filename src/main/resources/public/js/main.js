var app = angular.module('springDemo', []);

app.controller('AppCtrl', function ($scope, $http) {
    $http.get('http://localhost:8090/api/sites').then(function (response) {
        $scope.websites = response.data;
    });
});