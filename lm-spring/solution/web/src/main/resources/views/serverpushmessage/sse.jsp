<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Server Send Event</title>
</head>
<body>
<h3>Server Send Event</h3>
<div id="msgFrompPush"></div>
<script type="text/javascript" src="<c:url value="/assets/js/jquery-3.3.1.js" />"></script>
<script type="text/javascript">

    // EventSource 对象只有新式浏览器才有，EventSource 是 SSE 的客户端
    if(!!window.EventSource){

        var source=new EventSource("/ServerSendMsg/push");

        s='';
        // 添加 SSE 客户端监听，在此获得服务器端推送的消息
        source.addEventListener('message',function (e) {
            s+=e.data+'<br/>';
            $("#msgFrompPush").html(s);
        });

        source.addEventListener('open',function (e) {
            console.log("连接打开.");
        },false);

        source.addEventListener('error',function (e) {
            if(e.readyState==EventSource.CLOSED){
                console.log("连接关闭");
            }else {
                console.log(e.readyState);
            }
        },false);

    }else {
        console.log("你的浏览器不支持SSE");
    }

</script>
</body>
</html>
