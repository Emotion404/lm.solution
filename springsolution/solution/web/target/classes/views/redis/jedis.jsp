<%--
  Created by IntelliJ IDEA.
  User: liumeng
  Date: 2018/2/23
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jedis op Redis</title>
    <script src="/assets/js/jquery-3.3.1.js"></script>
</head>
<body>
<h3>Redis option by Jedis</h3>
<hr>
<button id="setOne">set key</button>
<br>
<span>ID:</span><input type="text" id="setId" ><br>
<span>Name:</span><input type="text" id="setName" ><br>
<span>Age:</span><input type="text" id="setAge" ><br>
<span>Salary:</span><input type="text" id="setSalary" ><br>
<div id="setUser"></div>
<br>
<script>
    $(function () {
        $('#setOne').on("click", function (e) {
            var data={
                id:$("#setId").val(),
                name:$("#setName").val(),
                age:$("#setAge").val(),
                salary:$("#setSalary").val()
            };

            var request = $.ajax({
                url: "/redis/set",
                method: "POST",
                data:JSON.stringify(data),
                contentType:"application/json"
                //dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    html += "<span>id</sapn>:<span>" + data.id + "</span><br>";
                    html += "<span>name</sapn>:<span>" + data.name + "</span><br>";
                    html += "<span>age</sapn>:<span>" + data.age + "</span><br>";
                    html += "<span>salary</sapn>:<span>" + data.salary + "</span><br>";
                    html += "<br>----------------------------------------------------------<br>";
                    $("#setUser").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="getOne">get key</button>
<br>
<span>ID:</span><input type="text" id="getId" ><br>
<div id="getUser"></div>
<br>
<script>
    $(function () {
        $('#getOne').on("click", function (e) {

            var request = $.ajax({
                url: "/redis/get?id="+$("#getId").val(),
                method: "GET",
                // data:JSON.stringify(data),
                contentType:"application/json"
                //dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    html += "<span>id</sapn>:<span>" + data.id + "</span><br>";
                    html += "<span>name</sapn>:<span>" + data.name + "</span><br>";
                    html += "<span>age</sapn>:<span>" + data.age + "</span><br>";
                    html += "<span>salary</sapn>:<span>" + data.salary + "</span><br>";
                    html += "<br>----------------------------------------------------------<br>";
                    $("#getUser").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
</body>
</html>
