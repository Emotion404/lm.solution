<%--
  Created by IntelliJ IDEA.
  User: liumeng
  Date: 2018/1/18
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=""
      id="loginUser"
      method="post">
    姓名：<input id="name" name="name" type="text"/><br>
    密码：<input id="password" name="password" type="password"/><br>
    验证码：<input id="authCode" name="authCode" type="text"/>
    <label>
        <img type="image"
             src="/Validate/Authcode"
             id="codeImage"
             onclick="chageCode()"
             title="图片看不清？点击重新得到验证码"
             style="cursor: pointer;"/>
    </label>
    <label>
        <a onclick="chageCode()">换一张</a>
    </label>
    <br>
    <input type="button" onclick="subm()" value="登录"/>
</form>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    function chageCode() {
        // 链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
        $("#codeImage").attr('src','/Validate/Authcode?abc='+Math.random());
    }
</script>
</body>
</html>
