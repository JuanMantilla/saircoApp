/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var servicesModule = angular.module('springMoviesAppServices');

servicesModule.factory('movieService', ['$http', function ($http) {
        
        return {
            apiUrl: apiUrl,
            getAllMovies: function () {
                return $http.get(this.apiUrl+'movie/');
            },
            getByActorId: function (ActorByMovieId) {
                return $http.get(this.apiUrl + 'actor/' + actorId);
            },
            getMovieById: function (movieId) {
                return $http.get(this.apiUrl+'movie/'+movieId);
            },
            createMovie: function (movie) {
                return $http.put(this.apiUrl+'movie/', movie);
            }
        };
    }]);

