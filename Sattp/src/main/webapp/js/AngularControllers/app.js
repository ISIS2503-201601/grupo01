(function(){var aplicacionMundial= angular.module('aplicacionMundial',[]);
   

    aplicacionMundial.directive('toolbar', function(){
        return{
            restrict:'E',
            templateUrl: 'partials/toolbar.html',
            controller:function(){
                this.tab=0;
                this.selectTab=function(setTab){
                    this.tab=setTab;
                };
                this.isSelected=function(tabParam){
                    return this.tab===tabParam;
                };
            },
            controllerAs:'toolbar'
        };
    });
    
    
     aplicacionMundial.directive('reportesSensores', function(){
        return{
            restrict:'E',
            templateUrl:'partials/reportes-sensores.html'
            
        };
    });
    
         aplicacionMundial.directive('eventosSismicos', function(){
        return{
            restrict:'E',
            templateUrl:'partials/eventos-sismicos.html'
            
        };
    });
    
             aplicacionMundial.directive('boletines', function(){
        return{
            restrict:'E',
            templateUrl:'partials/boletines.html'
           
        };
    });
    
     aplicacionMundial.directive('datatableSetup', ['$timeout',
        function ($timeout) {
            return {
                restrict: 'A',
                link: function (scope, element, attrs) {
 
                    $timeout(function () {
                        element.dataTable();
                    });
                }
            }
        }
    ]);
    
          aplicacionMundial.controller("getBoletines", ['$scope', '$http',
        function getBoletines($scope, $http) {
            // asynchronous call
                var callApi = $http.get('http://localhost:8080/service/boletines').success(function (data) {
                    $scope.boletines = data;  
                    $scope.bol = data[data.length - 1];
                });
                callApi.then(function () {
                    $scope.totalB = $scope.boletines;
                    $scope.totalBol = $scope.bol;
                });   
        }
    ]);
    
     
      aplicacionMundial.controller("getReportesSensores", ['$scope', '$http',
        function getReportesSensores($scope, $http) {
            // asynchronous call
                var callApi = $http.get('http://localhost:8080/service/reportes').success(function (data) {
                    $scope.reportes = data;                   
                });
                callApi.then(function () {
                    $scope.totalR = $scope.reportes;
                });   
        }
    ]);
    
          aplicacionMundial.controller("getEventosSismicos", ['$scope', '$http',
        function getEventosSismicos  ($scope, $http) {
            // asynchronous call
                var callApi = $http.get('http://localhost:8080/service/eventosSismicos').success(function (data) {
                    $scope.eventos = data;                   
                });
                callApi.then(function () {
                    $scope.totalE = $scope.eventos;
                });   
        }
    ]);
    
    aplicacionMundial.directive('currentCompetitor', function(){
        return{
            templateUrl:'partials/current-competitor.html',
            controller: 'competitorCtrl'
            
        };
        
        
        
    });
    
     
})();


    
    