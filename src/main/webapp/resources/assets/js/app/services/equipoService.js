/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var servicesModule = angular.module('saircoAppServices');
servicesModule.factory('equipoService', ['$http', function ($http) {
        return {
            apiUrl: apiUrl,
            getAllEquipos: function () {
                return $http.get(this.apiUrl + 'equipo/');
            },
            getEquipoById: function (equipoId) {
                return $http.get(this.apiUrl + 'equipo/' + equipoId);
            },
            getBySalonId: function (SalonByEquipoId) {
                return $http.get(this.apiUrl + 'salon/' + salonId);
            },
            createEquipo: function (equipo) {
                return $http.put(this.apiUrl + 'equipo/', equipo);
            },
            addSalonToEquipo: function (salon,  equipoId) {
                return $http.post(this.apiUrl + 'equipo/'+equipoId+'/salon', salon);
            },
            saveOrUpdateEquipo: function (equipo) {
                return $http.post(this.apiUrl + 'equipo/'+equipo.id+equipo);
            }
        };
    }]);


