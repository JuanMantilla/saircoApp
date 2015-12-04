/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var controllerModule = angular.module('saircoAppControllers');

controllerModule.controller('userController', ['$scope', '$uibModal', '$location', 'salonService', 'authService',
    'equipoService', '_',
    function ($scope, $uibModal, $location, salonService, authService, equipoService, _) {
       
        $scope.salones = [];
        $scope.equipos = [];

        $scope.getAllSalones = function () {
            salonService.getAllSalones()
                    .then(function (response) {
                        $scope.salones = response.data;
                    });
        };

        $scope.getAllEquipos = function () {
            equipoService.getAllEquipos()
                    .then(function (response) {
                        $scope.equipos = response.data;
                    });
        };
        
        $scope.getAllSalones();
        $scope.getAllEquipos();
    }]);