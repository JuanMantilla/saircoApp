/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerModule = angular.module('saircoAppControllers');

controllerModule.controller('navbarController', ['$scope', '$rootScope', '$location', 'authService',
    function ($scope, $rootScope, $location, authService) {

        $scope.user = {
            userName: "",
            password: ""
        };
        
        $scope.login = function() {
            $location.path('/login');
        };

        $scope.logout = function() {
            authService.logout();
            $rootScope.loggedIn = false;
            $location.path('/');
        };


        authService.login({}).then(function (response) {

            if (response.success) {
                $rootScope.loggedIn = true;
            } else {
                $rootScope.loggedIn = false;

            }
        });
        
        

    }]);



