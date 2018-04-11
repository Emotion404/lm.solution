// 定义 actionApp 模块
var actionApp = angular.module('actionApp', ['ngRoute']);

// 注入 $routeProvider 来配置路由
actionApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/oper', {  // /oper 路由名称
            controller: 'View1Controller',  // 路由对应的控制器名称
            templateUrl: '/views/view1.html'   // 视图的真正地址
        })
        .when('/directive',{
            controller:'View2Controller',
            templateUrl:'/views/view2.html'
        });
}]);
