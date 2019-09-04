app.service('brandService',function($http){
		this.findAll=function(){
    	return 	$http.get('../brand/findAll.do');
    		};
    	this.findPage=function(currentPage,pageSize){
    	return 	$http.get("../brand/findPage.do?pageNum="+currentPage+"&pageSize="+pageSize)
    		};
    	this.save=function(tbBrand){
    	return 	$http.post("../brand/save.do",tbBrand)
    		};
    	this.findone=function(id){
    	return 	$http.get("../brand/findone.do?id="+id)};
    	this.update=function(tbBrand){
    	return 	$http.post("../brand/update.do",tbBrand)};
    	this.dele=function(selectids){
    	return 	$http.get("../brand/dele.do?ids="+selectids)};
    	this.search=function(currentPage,pageSize,searchModel){
    	return 	$http.post("../brand/searchPage.do?pageNum="+currentPage+"&pageSize="+pageSize,searchModel)};
    	this.selectOptionList=function(){
    	return  $http.get('../brand/selectOptionList.do');
    	}

})