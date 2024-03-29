app.controller('baseController',function($scope){
	$scope.reloadList=function(){
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
		//查询框的内容在controller内获取后直接使用
	}
	$scope.paginationConf={ 
			   currentPage:1, 
			   totalItems:10, 
			   itemsPerPage:10, 
			   perPageOptions:[10, 20, 30, 40, 50], 
			   onChange: function(){ 
			            $scope.reloadList();//重新加载 
			   } 
	};
	$scope.selectIds=[];//指定ID的集合
	$scope.deleselection=function($event,id){
		if($event.target.checked){
			$scope.selectIds.push(id);
		}else{
			var index=$scope.selectIds.indexOf(id);
			$scope.selectIds.splice(index,1);
		}
	}
	$scope.jsonToString=function(jsonString,key){
		var json=JSON.parse(jsonString);
		var value="";
		for(var i=0;i<json.length;i++){
			if(i>0){
				value+=","
			}
			value+=json[i][key];
			
		}
		return value;
	}
    $scope.searchObjectByKey=function(list,key,keyValue){
        for(var i=0;i<list.length;i++){
            if(list[i][key]==keyValue){
                return list[i];
            }
        }
        return null;
    }


})