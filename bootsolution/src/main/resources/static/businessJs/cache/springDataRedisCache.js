$(function () {
    // 在 Redis 中 存入一个 person 和 一个 string
    $('#setCacheBtn').on("click", function (e) {
        var request = $.ajax({
            url: "/springDataRedisCache/setPerson",
            method: "GET"
        });

        request.done(function (data) {
            if (!data) {
                var html = "设置缓存成功！";
                $("#setTxt").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

    // 从 Redis 中 读取一个字符串
    $('#getCacheStrBtn').on("click", function (e) {
        var request = $.ajax({
            url: "/springDataRedisCache/getStr",
            method: "GET"
        });

        request.done(function (data) {
            if (data) {
                $("#getStrTxt").html(data);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

    // 从 Redis 中 读取一个 person
    $('#getCachePersonBtn').on("click", function (e) {
        var request = $.ajax({
            url: "/springDataRedisCache/getPerson",
            method: "GET"
        });

        request.done(function (data) {
            if (data) {
                var html = "";
                html += "<span>id</span>:<span>" + data.id + "</span><br>";
                html += "<span>name</span>:<span>" + data.name + "</span><br>";
                html += "<span>age</span>:<span>" + data.age + "</span><br>";
                html += "<span>address</span>:<span>" + data.address + "</span><br>";
                html += "<br>----------------------------------------------------------<br>";
                $("#getPersonTxt").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });
});