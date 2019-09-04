 //控制层 
app.controller('goodsController' ,function($scope,$controller,goodsService,$location,uploadService,itemCatService,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(){
	    var id=$location.search()['id'];
	    if(id==null){return;}

		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				//富文本的内容需要自行处理
                editor.html($scope.entity.goodsDesc.introduction);
                //图片内容也需要自行处理
                $scope.entity.goodsDesc.itemImages=JSON.parse($scope.entity.goodsDesc.itemImages);
                //扩展属性也需要自行处理
                $scope.entity.goodsDesc.customAttributeItems=JSON.parse($scope.entity.goodsDesc.customAttributeItems);
                //读取规格列表
                $scope.entity.goodsDesc.specificationItems=JSON.parse($scope.entity.goodsDesc.specificationItems);

                //SKU 列表规格列转换
                for( var i=0;i<$scope.entity.itemList.length;i++ ){
                    $scope.entity.itemList[i].spec =
                        JSON.parse( $scope.entity.itemList[i].spec);
                }}
		);				
	}
	$scope.checkAttributeValue=function (specName,optionName) {
	    var items=$scope.entity.goodsDesc.specificationItems;
	    //调用搜索方法 如果在items集合中有对象的attributeName的value（内容为 '规格''内容'） 为传入的specName 则返回true
        var object= $scope.searchObjectByKey(items,'attributeName',specName);
        if(object==null){
            return false;
        }else{
            //不为空后需要判断是否在对应的attributeValue有选项的值
            if(object.attributeValue.indexOf(optionName)>=0){
                return true;

            }else {
                return false;
            }
        }

    }
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象
        //读取富文本的内容
        $scope.entity.goodsDesc.introduction=editor.html();
        if($scope.entity.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 

                    alert('保存成功');
                    $scope.entity={};
                    editor.html("");
                    location.href="goods.html";

                }else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
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
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	//定义一个数组来取代分级ID 让原本的分类的ID的value作为数组的下标
    $scope.itemCatList=[];
	$scope.findAllItemsCat=function () {
        itemCatService.findAll().success(function (data) {

            for(var i=0;i<data.length;i++){
                //把查出来的表的id 放入定义的数组的角标中  然后把 name赋值
                $scope.itemCatList[data[i].id]=data[i].name;
            }

        })


    }
	$scope.add=function () {
		$scope.entity.goodsDesc.introduction=editor.html();
		goodsService.add($scope.entity).success(function (data) {
			if(data.success){
				alert("保存成功")
				$scope.entity={};//清空录入框文本
				editor.html('');//清空富文本编辑器
			}else {
				alert(reponse.message);
			}

        })

		
    }
    $scope.uploadFile=function(){
        uploadService.uploadFile().success(function(response) {
            if(response.success){//如果上传成功，取出 url

                $scope.image_entity.url=response.message;//设置文件地址
            }else{
                alert(response.message);
            }
        }).error(function() {
            alert("上传发生错误");
        });
    };
	$scope.entity={goods:{},goodsDesc:{itemImages:[]}};//页面实体结构{goods对象，good描述对象} goods描述对象中有itemimage数组其中保存的数据
													  //格式为json数据存放遗传fastDFS的url编码 编码内容 颜色对象 和 url对象
	//              [{"color":"红色","url":"http://192.168.25.133/group1/M00/00/01/wKgZhVmHINKADo__AAjlKdWCzvg874.jpg"}
	$scope.add_image_entity=function () {
        $scope.entity.goodsDesc.itemImages.push($scope.image_entity)
		
    }
    $scope.remove_image_entity=function (index) {

		//此处为伪删除一般
		//数据库中的数据并未删除，只是修改了页面json对象中的字段；
        $scope.entity.goodsDesc.itemImages.splice(index,1)
		
    }
    $scope.selectItemCat1List=function () {
		itemCatService.findByParentId(0).success(function (data) {
			$scope.itemCat1List=data;

        })

    }
    //$watch两个参数 分别是 监控的数值 和 执行的方法(方法中的依次为 新数据 和 旧数据)
	//同样 在goods表中category1/2/3ID 和 itemcat表中id 为同意义字段option选项中选出的遍历list后获得的name提交上去的为itemcat表中的id字段
	//所以在绑定ng-model时候可以直接绑定entitiy.goods.category1Id
    $scope.$watch('entity.goods.category1Id',function (newValue,oldValue) {
        if(newValue!=null){itemCatService.findByParentId(newValue).success(function (data) {
            $scope.itemCat2List=data;

        })}
        })
    $scope.$watch('entity.goods.category2Id',function (newValue,oldValue) {
        if(newValue!=null){itemCatService.findByParentId(newValue).success(function (data) {
            $scope.itemCat3List=data;

        })}
        })
	//此时获得的category3Id即第三级分类中的itemcat.id
	$scope.$watch('entity.goods.category3Id',function (newValue,oldValue){
	    if(newValue!=null){
            itemCatService.findOne(newValue).success(function (data) {
                $scope.entity.goods.typeTemplateId=data.typeId;

            })
        }

	})
	//监控typeTemplateId变化 选择品牌
    $scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue){
        if(newValue!=null){
            typeTemplateService.findOne(newValue).success(function (data) {
                $scope.typeTemplate=data;//获得typeTemplate表数据
                $scope.typeTemplate.brandIds=JSON.parse( $scope.typeTemplate.brandIds);//获取品牌列表
                //从模板表中的扩展属性添加到entity对象中，
                if($location.search()['id']==null){
                    $scope.entity.goodsDesc.customAttributeItems=JSON.parse( $scope.typeTemplate.customAttributeItems);
                }

                typeTemplateService.findSpecList(newValue).success(
                    function(response){
                        $scope.specList=response;
                    }
                );

            })
        }


    });

    $scope.entity={ goodsDesc:{itemImages:[],specificationItems:[]}  };

    $scope.updateSpecAttribute=function($event,name,value){
    	//调用base中的方法来查询 $scope.entity.goodsDesc.specificationItems集合中是否有已经有的属性名
		//[{"attributeName":"网络制式","attributeValue":["移动3G","移动4G"]}
		//例如查询key为attributeName中是否有网络制式 没有则要加入 attributename key 和 value，有则只用加入value
        var object= $scope.searchObjectByKey(
            $scope.entity.goodsDesc.specificationItems ,'attributeName', name);
        if(object!=null){
        	//查出有属性名
            if($event.target.checked ){
                object.attributeValue.push(value);
            }else{//取消勾选
                object.attributeValue.splice( object.attributeValue.indexOf(value ) ,1);//移除选项
                //如果选项都取消了，将此条记录移除
                if(object.attributeValue.length==0){
                    $scope.entity.goodsDesc.specificationItems.splice(
                        $scope.entity.goodsDesc.specificationItems.indexOf(object),1);
                }
            }
        }else{
            $scope.entity.goodsDesc.specificationItems.push(
                {"attributeName":name,"attributeValue":[value]});
        }
    }
    $scope.createItemList=function() {
        $scope.entity.itemList = [{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}]
        ;//初始
        var items = $scope.entity.goodsDesc.specificationItems;//该对象长度为2  为网络制式和屏幕尺寸

        for (var i = 0; i < items.length; i++) {//第一次循环使用网络制式
            $scope.entity.itemList = addColumn($scope.entity.itemList, items[i].attributeName, items[i].attributeValue);
        }
    }
//添加列值
 	addColumn = function (list, columnName, conlumnValues) {
            var newList = [];//新的集合 每次调用增加列表功能会把所有输入框重置返回的为新的框
            for (var i = 0; i < list.length; i++) {
            	//定义循环次数为 第一次进入 list长度为1 只执行一次 经过子循环后 返回后长度为2
				//第二次进入是长度为2 子循环push后则为4
                var oldRow = list[i];
                for (var j = 0; j < conlumnValues.length; j++) {
                	//循环往[{spec: {}, price: 0, num: 99999, status: '0', isDefault: '0'}]中加入specvalue内容
					//例如加入 2g 3g 所以返回的长度取决与j的大小  如果只有2g 为1  有2g3g为2 2g3g4g则为3
                    var newRow = JSON.parse(JSON.stringify(oldRow));//深克隆
                    newRow.spec[columnName] = conlumnValues[j];
                    newList.push(newRow);
                }
            }
            return newList;
    }




});
