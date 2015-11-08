/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('springMoviesAppControllers');

controllerModule.controller('movieController', ['$scope','movieService', 
    '$routeParams', '$location', '_',
    function($scope, movieService, $routeParams, $location, _) {
        $scope.getMovie = function(movieId) {
            movieService.getMovieById(movieId).then(function(response) {
                $scope.movie = response.data;
            });
        };
        if ($routeParams.movieId) {
            $scope.getMovie(parseInt($routeParams.movieId));
        } else {
            $location.path('/');
        }
        
    }]);

