angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.fillTable = function () {
        $http.get(contextPath + '/products')
        .then(function(response) {
            $scope.productsList = response.data;
        });
    };

    $scope.deleteProduct = function(productId) {
        $http.get(contextPath + '/products/delete/' + productId)
                .then(function(response) {
                    alert('Deleted');
                    $scope.fillTable();
                });
    }

    $scope.changeCost = function(productId, delta) {
            $http({
                url: contextPath + '/products/change_cost',
                method: 'GET',
                params: {
                    productId: productId,
                    delta: delta
                }
            }).then(function(response){
                $scope.fillTable();
            });
        }

    $scope.fillTable();
});