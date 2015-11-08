/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var springMoviesApp = angular.module("springMoviesApp", [
    'ngRoute',
    'ui.bootstrap',
    'springMoviesAppServices',
    'springMoviesAppControllers',
    'currencyMask',
    'lodash'
]);


springMoviesApp.config(['$routeProvider', 
    function($routeProvider) {
        $routeProvider.
                when('/movie/:movieId', {
                    templateUrl: 'assets/js/app/views/movie.html',
                    controller: 'movieController'
                }).when('/actor/:actorId', {
                    templateUrl: 'assets/js/app/views/actor.html',
                    controller: 'actorController'
                }).when('/', {
                    templateUrl: 'assets/js/app/views/home.html',
                    controller: 'homeController'
                }).otherwise({
                    redirectTo: '/'
                });
        
}]);
