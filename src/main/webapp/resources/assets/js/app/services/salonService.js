/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var servicesModule = angular.module('saircoAppServices');

servicesModule.factory('salonService', ['$http', function ($http) {
        
        return {
            apiUrl: apiUrl,
            getAllSalones: function () {
                return $http.get(this.apiUrl+'salon/');
            },
            getByEquipoId: function (EquipoBySalonId) {
                return $http.get(this.apiUrl + 'equipo/' + equipoId);
            },
            getSalonById: function (salonId) {
                return $http.get(this.apiUrl+'salon/'+salonId);
            },
            createSalon: function (salon) {
                return $http.put(this.apiUrl+'salon/', salon);
            }
        };
    }]);

