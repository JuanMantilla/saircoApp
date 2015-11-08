/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('springMoviesAppControllers');
//Al scope lo ve la vista y el controlador
controllerModule.controller('actorController', ['$scope','actorService', 
    '$routeParams', '$location', '_','movieService',
    function($scope, actorService, $routeParams, $location, _ ,movieService) {
        $scope.getActor = function(actorId) {
            actorService.getActorById(actorId).then(function(response) {
                $scope.actor = response.data;
            });
        }; 
        $scope.getMovie = function(movieId) {
            movieService.getMovieById(movieId).then(function(response) {
                $scope.movie = response.data;
            });
        };
        if ($routeParams.actorId) {
            $scope.getActor(parseInt($routeParams.actorId));
        } else if ($routeParams.movieId) {
            $scope.getMovie(parseInt($routeParams.movieId));
        }
        else {
            $location.path('/');
        }
        
    }
]);