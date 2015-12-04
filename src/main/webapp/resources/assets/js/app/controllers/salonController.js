/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('saircoAppControllers');

controllerModule.controller('salonController', ['$scope','salonService', 
    '$routeParams', '$location', '_',
    function($scope, salonService, $routeParams, $location, _) {
        $scope.getSalon = function(salonId) {
            salonService.getSalonById(salonId).then(function(response) {
                $scope.salon = response.data;
            });
        };
        if ($routeParams.salonId) {
            $scope.getSalon(parseInt($routeParams.salonId));
        } else {
            $location.path('/');
        }
        
    }]);

