
// 定义一个指令 datePicker
actionApp.directive('datePicker',function () {
    return {
        // 限制为属性或样式指令
        restrict:'AC',
        // 使用 link 方法来定义指令，在 link 方法内可使用当前 scope 当前元素 当前元素的属性
        link:function (scope,elem,attrs) {
            // 初始化 jquery ui 的 datePicker
            elem.datepicker();
        }
    };
});
