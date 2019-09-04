app.controller("contentController",function ($scope, contentService) {
    $scope.contentList=[];
    $scope.findByCategoryId=function (CategoryId) {
        controllerService.findByCategoryId(CategoryId).success(function (data) {
            //此处用角标来一次传递多个list集合
            $scope.contentList[categoryId]=response;

        })
        
    }
    //搜索跳转
    $scope.search=function(){
        location.href="http://localhost:9104/search.html#?keywords="+$scope.keywords;
    }
    
})