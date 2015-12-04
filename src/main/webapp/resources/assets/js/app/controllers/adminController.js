/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var controllerModule = angular.module('saircoAppControllers');

controllerModule.controller('adminController', ['$scope', '$uibModal', '$location', 'salonService', 'authService',
    'equipoService', '_',
    function ($scope, $uibModal, $location, salonService, authService, equipoService, _) {
       
        $scope.salones = [];
        $scope.equipos = [];
        $scope.equipo;

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
        
        
        $scope.addSalon = function () {
            $uibModal.open({
                templateUrl: 'addSalonModal',
                controller: 'adminController.addSalonModal',
                size: 'md'
            }).result.then(function (m) {
                salonService.createSalon(m)
                        .then(function (response) {
                            $scope.getAllSalones();
                        });
            });
        };
        $scope.addEquipo = function () {
            $uibModal.open({
                templateUrl: 'addEquipoModal',
                controller: 'adminController.addEquipoModal',
                size: 'md'
            }).result.then(function (a) {
                equipoService.createEquipo(a)
                        .then(function (response) {
                            $scope.getAllEquipos();
                        });
            });
        };
        
        $scope.editEquipo = function () {
            $uibModal.open({
                templateUrl: 'editEquipoModal',
                controller: 'adminController.editEquipoModal',
                size: 'md'
                
            }).result.then(function (a) {
                equipoService.saveOrUpdateEquipo(a)
                        .then(function (response) {
                            $scope.getAllEquipos();
                        });
            });
        };
        $scope.editSalon = function () {
            $uibModal.open({
                templateUrl: 'editSalonModal',
                controller: 'adminController.editSalonModal',
                size: 'md'
                
            }).result.then(function (a) {
                equipoService.saveOrUpdateSalon(a)
                        .then(function (response) {
                            $scope.getAllSalones();
                        });
            });
        };
        $scope.saveOrUpdateEquipo = function (id, name, ubicacion) {
            var equipo=new $scope.equipo;
            equipo.id=id;
            equipo.name=name;
            equipo.ubicaicon=ubicacion;
            equipoService.saveOrUpdateEquipo(equipo).then(function (response) {                
            });
        };

        $scope.getAllSalones();
        $scope.getAllEquipos();
    }]);

        controllerModule.controller('adminController.addSalonModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        $scope.salon = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {

            $modalInstance.close($scope.salon);
        };
    }]);

        controllerModule.controller('adminController.addEquipoModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        $scope.equipo = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {

            $modalInstance.close($scope.equipo);
        };
    }]);
        controllerModule.controller('adminController.editEquipoModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {
            alert("Equipo actualizado!");
            $modalInstance.close();
        };
    }]);
        controllerModule.controller('adminController.editSalonModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {
            alert("Salon actualizado!");
            $modalInstance.close();
        };
    }]);
