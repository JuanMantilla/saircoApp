/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var servicesModule = angular.module('springMoviesAppServices');
servicesModule.factory('actorService', ['$http', function ($http) {
        return {
            apiUrl: apiUrl,
            getAllActors: function () {
                return $http.get(this.apiUrl + 'actor/');
            },
            getActorById: function (actorId) {
                return $http.get(this.apiUrl + 'actor/' + actorId);
            },
            getByMovieId: function (MovieByActorId) {
                return $http.get(this.apiUrl + 'movie/' + movieId);
            },
            createActor: function (actor) {
                return $http.put(this.apiUrl + 'actor/', actor);
            }
        };
    }]);


