/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('saircoAppControllers');

controllerModule.controller('homeController', ['$scope', 'salonService','equipoService', '_', 
    function ($scope, salonService, equipoService, _) {
        $scope.salones = [];
        $scope.equipos = [];
        $scope.getAllSalones = function () {
            var promise = salonService.getAllSalones();
            promise.then(function (response) {
                $scope.salones = response.data;
            });
        };      
        $scope.getAllSalones();
                
        $scope.getAllEquipos = function () {
            var promise = equipoService.getAllEquipos();
            promise.then(function (response) {
                $scope.equipos = response.data;
            });
        };      
        $scope.getAllEquipos();
    }
]);





