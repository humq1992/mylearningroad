app.controller('searchController',function ($scope,searchService) {

    $scope.search=function () {
        searchService.search($scope.searchMap).success(function (data) {
            $scope.resultMap=data;

        })
        
    }
    
})