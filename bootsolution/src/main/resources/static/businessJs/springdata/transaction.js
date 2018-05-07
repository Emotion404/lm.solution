$(function () {
    // 回滚
    $('#rollback').on("click", function (e) {
        var data={
            name:'回滚test',
            age:1,
            address:'发生异常，会回滚数据库'
        };

        var request = $.ajax({
            url: "/SpringDataJpaTransaction/withRollback",
            method: "POST",
            data:JSON.stringify(data),
            contentType:"application/json"
        });

        request.done(function (data) {
            if (data) {
                var html = "";
                html += "<span>id</span>:<span>" + data.id + "</span><br>";
                html += "<span>name</span>:<span>" + data.name + "</span><br>";
                html += "<span>age</span>:<span>" + data.age + "</span><br>";
                html += "<span>address</span>:<span>" + data.address + "</span><br>";
                html += "<br>----------------------------------------------------------<br>";
                $("#rollbackTxt").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    });

    // 不回滚
    $('#noRollback').on("click", function (e) {
        var data={
            name:'不回滚test',
            age:2,
            address:'发生异常，不会回滚数据库'
        };

        var request = $.ajax({
            url: "/SpringDataJpaTransaction/withoutRollback",
            method: "POST",
            data:JSON.stringify(data),
            contentType:"application/json"
        });

        request.done(function (data) {
            if (data) {
                var html = "";
                html += "<span>id</span>:<span>" + data.id + "</span><br>";
                html += "<span>name</span>:<span>" + data.name + "</span><br>";
                html += "<span>age</span>:<span>" + data.age + "</span><br>";
                html += "<span>address</span>:<span>" + data.address + "</span><br>";
                html += "<br>----------------------------------------------------------<br>";
                $("#noRollbackTxt").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    });

    // 所有数据
    $('#btnAll').on("click", function (e) {
        var request = $.ajax({
            url: "/SpringDataJpaTransaction/all",
            method: "GET"
        });

        request.done(function (data) {
            if (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<span>id</span>:<span>" + data[i].id + "</span><br>";
                    html += "<span>name</span>:<span>" + data[i].name + "</span><br>";
                    html += "<span>age</span>:<span>" + data[i].age + "</span><br>";
                    html += "<span>address</span>:<span>" + data[i].address + "</span><br>";
                    html += "<br>----------------------------------------------------------<br>";
                }
                $("#allData").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    });
});

