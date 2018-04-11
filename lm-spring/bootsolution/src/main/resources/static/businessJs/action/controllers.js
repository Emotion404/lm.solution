
// 定义 View1Controller 控制器，并注入 $rootScope $scope $http
actionApp.controller('View1Controller', ['$rootScope','$scope','$http', function ($rootScope,$scope,$http) {

    // 使用 $scope.$on 监听 $viewContentLoaded 事件，可以在页面内容加载完成后做一些操作
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成');
    });

    // 在页面上通过 ng-click 调用
    $scope.search=function () {
        // 通过 $scope.personName 获取页面定义的 ng-model="personName" 的值
        personName=$scope.personName;
        // 使用 $http.get 向服务端地址 /search 发送 get 请求
        $http.get('/search',{
            // 请求的参数
            params:{
                personName:personName
            }
        })/*请求成功后的回调*/.success(function (data) {
            $scope.person=data;
        });
    };

}]);

actionApp.controller('View2Controller',['$rootScope','$scope',function ($rootScope,$scope) {
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成');
    });
}]);
