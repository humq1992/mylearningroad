app.service('uploadService',function ($http) {
    this.uploadFile=function () {
        var formData=new FormData();
        //此处的file是通过formData对象根据id 在标签中找的数据；
        //formData是基于页面元素的对象，可以获得页面中标签的value；所以不需要传入参数
        formData.append("file",file.files[0]);
        return $http({
            method:'post',
            url:"../upload.do",
            data:formData,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity
        });
        
    }
    
});