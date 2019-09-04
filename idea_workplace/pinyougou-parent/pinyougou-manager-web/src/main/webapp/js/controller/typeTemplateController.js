 //控制层 
app.controller('typeTemplateController',function($scope,$controller,typeTemplateService,brandService,specificationService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;	
				$scope.entity.brandIds=  JSON.parse($scope.entity.brandIds);//转换品牌列表
				 
				    $scope.entity.specIds=  JSON.parse($scope.entity.specIds);//转换规格列表
				 
				    $scope.entity.customAttributeItems= JSON.parse($scope.entity.customAttributeItems)//转换属性
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=typeTemplateService.update( $scope.entity ); //修改  
		}else{
			serviceObject=typeTemplateService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		typeTemplateService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	$scope.brandList={data:[]};
	//此处如果不写可能再异步页面时候  由于访问查询较慢 而 下拉页面加载较快 会产生页面报错
	//此处通过brandService来调用生成MAP可以降低各个模块之间的耦合；如果采用再typeTemplage的后台来调用BrandService则模块不独立；
    $scope.findBrandlist=function(){
    	brandService.selectOptionList().success(function(response){
    		$scope.brandList={data:response}
    	})
    	
    }
    $scope.specIds={data:[]};
	//此处如果不写可能再异步页面时候  由于访问查询较慢 而 下拉页面加载较快 会产生页面报错
	//此处通过brandService来调用生成MAP可以降低各个模块之间的耦合；如果采用再typeTemplage的后台来调用BrandService则模块不独立；
    $scope.findspecIds=function(){
    	specificationService.selectOptionList().success(function(response){
    		$scope.specIds={data:response}
    	})
    	
    }
    $scope.addTableRow=function(){
    	$scope.entity.customAttributeItems.push({});
    }
    $scope.delTableRow=function(index){
    	$scope.entity.customAttributeItems.splice(index,1);
    }
});	
