<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HttpMessageConverter Custom</title>
</head>
<body>
<h3>自定义 HttpMessageConverter (存在 error )</h3>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
<script src="/assets/js/jquery-3.3.1.js" type="text/javascript"></script>
<script>
    function req(){
        $.ajax({
            url: "/convertpage/customconvert",
            data: "1-wangyunfei",
            contentType:"application/x-wisely",
            success: function(data){
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>
