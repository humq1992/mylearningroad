app.controller('cartController',function ($scope,cartService) {
    //查询购物车列表
    $scope.findCartList=function () {
        cartService.findCartList().success(function (data) {
            $scope.cartList=data;
            $scope.totalValue=cartService.sum($scope.cartList);//求合计数
        })
        
    };
    $scope.addGoodsToCartList=function(itemId,num){
        cartService.addGoodsToCartList(itemId,num).success(
            function(response){
                if(response.success){
                    $scope.findCartList();//刷新列表
                }else{
                    alert(response.message);//弹出错误提示
                }
            }
        );
    }
    $scope.findListByUserId=function () {
        cartService.findListByUserId().success(function (data) {
            $scope.addressList=data;
            for (var i=0;i<data.length;i++){
                if($scope.addressList[i].isDefault=='1'){
                    $scope.address=$scope.addressList[i];
                    break;
                }
            }

        })

    }
    //选择地址
    $scope.selectAddress=function(address){
        $scope.address=address;
    }

    //判断某地址对象是不是当前选择的地址
    $scope.isSeletedAddress=function(address){
        if(address==$scope.address){
            return true;
        }else{
            return false;
        }
    }
    $scope.order={paymentType:'1'};
    //选择支付方式
    $scope.selectPayType=function(type){
        $scope.order.paymentType= type;
    }

    //保存订单
    $scope.submitOrder=function(){
        $scope.order.receiverAreaName=$scope.address.address;//地址
        $scope.order.receiverMobile=$scope.address.mobile;//手机
        $scope.order.receiver=$scope.address.contact;//联系人
        cartService.submitOrder( $scope.order ).success(
            function(response){
                if(response.success){
                    //页面跳转
                    if($scope.order.paymentType=='1'){//如果是微信支付，跳转到支付页面
                        location.href="pay.html";
                    }else{//如果货到付款，跳转到提示页面
                        location.href="paysuccess.html";
                    }
                }else{
                    alert(response.message); //也可以跳转到提示页面
                }
            }
        );
    }



});