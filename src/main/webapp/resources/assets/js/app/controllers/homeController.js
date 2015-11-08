/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('springMoviesAppControllers');

controllerModule.controller('homeController', ['$scope', 'movieService','actorService', '_', 
    function ($scope, movieService, actorService, _) {
        $scope.movies = [];
        $scope.actors = [];
        $scope.getAllMovies = function () {
            var promise = movieService.getAllMovies();
            promise.then(function (response) {
                $scope.movies = response.data;
            });
        };      
        $scope.getAllMovies();
                
        $scope.getAllActors = function () {
            var promise = actorService.getAllActors();
            promise.then(function (response) {
                $scope.actors = response.data;
            });
        };      
        $scope.getAllActors();
    }
]);





