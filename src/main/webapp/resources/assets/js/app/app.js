/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var saircoApp = angular.module("saircoApp", [
    'ngRoute',
    'ui.bootstrap',
    'ui.grid',
    'saircoAppServices',
    'saircoAppControllers',
    'lodash'
]);


saircoApp.config(['$routeProvider', '$httpProvider',
    function($routeProvider, $httpProvider) {
        $routeProvider.
                when('/salon/:salonId', {
                    templateUrl: 'assets/js/app/views/salon.html',
                    controller: 'salonController'
                }).when('/equipo/:equipoId', {
                    templateUrl: 'assets/js/app/views/equipo.html',
                    controller: 'equipoController'
                }).when('/', {
                    templateUrl: 'assets/js/app/views/home.html',
                    controller: 'homeController'
                }).when('/admin', {
                templateUrl: 'assets/js/app/views/admin.html',
                controller: 'adminController'
                }).when('/user', {
                templateUrl: 'assets/js/app/views/user.html',
                controller: 'userController'
                }).when('/login', {
                    templateUrl: 'assets/js/app/views/login.html',
                    controller: 'loginController'
                }).when('/equipo/:equipoId/editar', {
                    templateUrl: 'assets/js/app/views/saveOrUpdateEquipo.html',
                    controller: 'adminController'
                }).otherwise({
                            redirectTo: '/'
                        });
        

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    }])
        .run(['$rootScope','$location','authService', function ($rootScope, $location, authService) {
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                if (next.templateUrl === "assets/js/app/views/admin.html") { 
                    authService.login().then(function(response) {
                        if (!response.success) 
                            $location.path('/login');
                    });
                    
                }
            });
        }]);