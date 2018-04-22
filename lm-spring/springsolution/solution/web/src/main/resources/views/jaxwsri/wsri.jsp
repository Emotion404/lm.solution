<%--
  Created by IntelliJ IDEA.
  User: liumeng
  Date: 2018/2/23
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java JAX-WS RI</title>
    <script src="/assets/js/jquery-3.3.1.js"></script>
</head>
<body>
<p>
    <h3>JAX-WS RI getTimeRI</h3>
    <button id="time">time</button>
    <br>
<div id="timetxt"></div>
<br>
<script>
    $(function () {
        $('#time').on("click", function (e) {
            var request = $.ajax({
                url: "/jaxws/getTime",
                method: "GET"
            });

            request.done(function (data) {
                if (data) {
                    $("#timetxt").html(data);
                }
            });

            request.fail(function (jqXHR, textStatus) {
                alert("Request failed: " + textStatus);
            });
        });
    });
</script>
<hr>
<p>
<h3>JAX-WS RI getSquareRootRI</h3>
<button id="square">square</button>
<br>
<input type="text" id="squarevalue">
<br>
<div id="squaretxt"></div>
<br>
<script>
    $(function () {
        $('#square').on("click", function (e) {
            var request = $.ajax({
                url: "/jaxws/getSquare?s="+$("#squarevalue").val(),
                method: "GET"
            });

            request.done(function (data) {
                if (data) {
                    $("#squaretxt").html(data);
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
