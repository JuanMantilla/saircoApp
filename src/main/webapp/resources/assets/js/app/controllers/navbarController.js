/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('springMoviesAppControllers');

controllerModule.controller('navbarController', ['$scope', '$uibModal', '$location', 'movieService', 'actorService',
    function ($scope, $uibModal, $location, movieService, actorService) {
        $scope.addMovie = function () {
            $uibModal.open({
                templateUrl: 'addMovieModal',
                controller: 'navbarController.addMovieModal',
                size: 'md'
            }).result.then(function (m) {
                movieService.createMovie(m);
                $location.path('/');
            });
        };
        $scope.addActor = function () {
            $uibModal.open({
                templateUrl: 'addActorModal',
                controller: 'navbarController.addActorModal',
                size: 'md'
            }).result.then(function (a) {
                actorService.createActor(a);
                $location.path('/');
            });
        };
    }]);

controllerModule.controller('navbarController.addMovieModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        $scope.movie = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {

            $modalInstance.close($scope.movie);
        };
    }]);

controllerModule.controller('navbarController.addActorModal', ['$scope', '$modalInstance', function ($scope, $modalInstance) {
        $scope.actor = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.ok = function () {

            $modalInstance.close($scope.actor);
        };
    }]);

