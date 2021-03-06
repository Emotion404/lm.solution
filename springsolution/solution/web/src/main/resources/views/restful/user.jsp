<%--
  Created by IntelliJ IDEA.
  User: liumeng
  Date: 2018/2/12
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Restful API</title>
    <script src="/assets/js/jquery-3.3.1.js"></script>
</head>
<body>
<p>
    <button id="btnAllusers">GET-查看所有</button>
    <br>
<div id="getAllusers"></div>
<br>
<script type="text/javascript">
    $(function () {
        $('#btnAllusers').on("click", function (e) {
            var request = $.ajax({
                url: "/user/userall",
                method: "GET"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    for (var i = 0; i < data.length; i++) {
                        html += "<span>id</sapn>:<span>" + data[i].id + "</span><br>";
                        html += "<span>name</sapn>:<span>" + data[i].name + "</span><br>";
                        html += "<span>age</sapn>:<span>" + data[i].age + "</span><br>";
                        html += "<span>salary</sapn>:<span>" + data[i].salary + "</span><br>";
                        html += "<br>----------------------------------------------------------<br>";
                    }
                    $("#getAllusers").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="btnUserByID">GET-查看ByID</button>
<br>
<span>ID:</span><input type="text" id="userbyIDtx">
<br>
<div id="UserByID"></div>
<br>
<script>
    $(function () {
        $('#btnUserByID').on("click", function (e) {
            var request = $.ajax({
                url: "/user/"+$("#userbyIDtx").val(),
                method: "GET",
                dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                        html += "<span>id</sapn>:<span>" + data.id + "</span><br>";
                        html += "<span>name</sapn>:<span>" + data.name + "</span><br>";
                        html += "<span>age</sapn>:<span>" + data.age + "</span><br>";
                        html += "<span>salary</sapn>:<span>" + data.salary + "</span><br>";
                        html += "<br>----------------------------------------------------------<br>";
                    $("#UserByID").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="createOne">POST-创建一个</button>
<br>
<span>ID:</span><input type="text" disabled="disabled" ><br>
<span>Name:</span><input type="text" id="createName" ><br>
<span>Age:</span><input type="text" id="createAge" ><br>
<span>Salary:</span><input type="text" id="createSalary" >
<br>
<div id="createUser"></div>
<br>
<script>
    $(function () {
        $('#createOne').on("click", function (e) {
            var data={
                name:$("#createName").val(),
                age:$("#createAge").val(),
                salary:$("#createSalary").val()
            };

            var request = $.ajax({
                url: "/user/create",
                method: "POST",
                data:JSON.stringify(data),
                contentType:"application/json"
                //dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    html += "<span>id</span>:<span>" + data.id + "</span><br>";
                    html += "<span>name</span>:<span>" + data.name + "</span><br>";
                    html += "<span>age</span>:<span>" + data.age + "</span><br>";
                    html += "<span>salary</span>:<span>" + data.salary + "</span><br>";
                    html += "<br>----------------------------------------------------------<br>";
                    $("#createUser").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="putOne">PUT-更新一个</button>
<br>
<span>ID:</span><input type="text" id="putId" ><br>
<span>Name:</span><input type="text" id="putName" ><br>
<span>Age:</span><input type="text" id="putAge" ><br>
<span>Salary:</span><input type="text" id="putSalary" >
<br>
<div id="putUser"></div>
<br>
<script>
    $(function () {
        $('#putOne').on("click", function (e) {
            var data={
                id:$("#putId").val(),
                name:$("#putName").val(),
                age:$("#putAge").val(),
                salary:$("#putSalary").val()
            };

            var request = $.ajax({
                url: "/user/update",
                method: "PUT",
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
                    $("#createUser").html(data);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="deleteOne">DELETE-删除一个</button>
<br>
<span>ID:</span><input type="text" id="deleteId" ><br>
<!--<span>Name:</span><input type="text" id="putName" ><br>
<span>Age:</span><input type="text" id="putAge" ><br>
<span>Salary:</span><input type="text" id="putSalary" >-->
<br>
<div id="deleteUser"></div>
<br>
<script>
    $(function () {
        $('#deleteOne').on("click", function (e) {
            // var data={
            //     id:$("#putId").val(),
            //     name:$("#putName").val(),
            //     age:$("#putAge").val(),
            //     salary:$("#putSalary").val()
            // };

            var request = $.ajax({
                url: "/user/"+$("#deleteId").val(),
                method: "DELETE",
                // data:JSON.stringify(data),
                contentType:"application/json"
                //dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    // html += "<span>id</sapn>:<span>" + data.id + "</span><br>";
                    // html += "<span>name</sapn>:<span>" + data.name + "</span><br>";
                    // html += "<span>age</sapn>:<span>" + data.age + "</span><br>";
                    // html += "<span>salary</sapn>:<span>" + data.salary + "</span><br>";
                    // html += "<br>----------------------------------------------------------<br>";
                    $("#createUser").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<button id="deleteAll">DELETE-删除所有</button>
<br>
<div id="deleteUserAll"></div>
<br>
<script>
    $(function () {
        $('#deleteAll').on("click", function (e) {
            var request = $.ajax({
                url: "/user",
                method: "DELETE",
                // data:JSON.stringify(data),
                contentType:"application/json"
                //dataType:"json"
            });

            request.done(function (data) {
                if (data) {
                    var html = "";
                    // html += "<span>id</sapn>:<span>" + data.id + "</span><br>";
                    // html += "<span>name</sapn>:<span>" + data.name + "</span><br>";
                    // html += "<span>age</sapn>:<span>" + data.age + "</span><br>";
                    // html += "<span>salary</sapn>:<span>" + data.salary + "</span><br>";
                    // html += "<br>----------------------------------------------------------<br>";
                    $("#deleteUserAll").html(html);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
</p>
</body>
</html>
