/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('saircoAppControllers');
controllerModule.controller('equipoController', ['$scope', 'equipoService',
    '$routeParams', '$location', '_', 'salonService',
    function ($scope, equipoService, $routeParams, $location, _, salonService, $uibModal) {
        $scope.getEquipo = function (equipoId) {
            equipoService.getEquipoById(equipoId).then(function (response) {
                $scope.equipo = response.data;
            });
        };
        $scope.AllSalones = function () {
            salonService.getAllSalones().then(function (response) {
                $scope.salones = response.data;
            });
        };
        $scope.AllEquipos = function () {
            equipoService.getAllEquipos().then(function (response) {
                $scope.equipos = response.data;
            });
        };
        $scope.addSalonesToEquipo = function () {

            equipoService.addSalonToEquipo({id: $scope.selectedSalon}, $scope.equipo.id)
                    .then(function(response) {
                        $scope.getEquipo(parseInt($routeParams.equipoId));
            });
        };
        if ($routeParams.equipoId) {
            $scope.getEquipo(parseInt($routeParams.equipoId));
        }
        else {

            $location.path('/');
        }
        $scope.AllSalones();
        $scope.AllEquipos();
    }
]);