app.controller('payController',function ($scope,payService,$location) {
    $scope.createNative=function () {

        payService.createNative().success(function (data) {
            $scope.money=(data.total_fee/100).toFixed(2);
            $scope.out_trade_no=data.out_trade_no;


            //生成二维码
            var qr=new Qrious({
                element:document.getElementById('qrious'),
                size:250,
                level:'H',
                value:response.code_url
            });

            queryPayStatus(data.out_trade_no)

        })

    }
    queryPayStatus=function (out_trade_no) {
        payService.queryPayStatus(out_trade_no).success(function (data) {
            if(data.success){
                location.href="paysuccess.html#?money="+$scope.money;
            }else {
                if(data.message=='支付超时'){
                    $scope.createNative();//重新生成二维码
                }else {
                    location.href='payfail.html'
                }

            }
        })
        
    }
    $scope.getMoney=function(){
        return $location.search()['money'];
    }

});