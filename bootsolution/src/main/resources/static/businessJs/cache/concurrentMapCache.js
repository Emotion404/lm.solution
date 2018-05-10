$(function () {
    // @Cacheable DB查询一条数据并放入缓存
    $('#cacheableOne').on("click", function (e) {
        var data={
            id:$("#ableIdTxt").val(),
            name:'',
            age:0,
            address:''
        };

        var request = $.ajax({
            url: "/cache/concurrentmap/able",
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
                $("#cacheableOneData").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

    // @CachePut DB保存一条数据并放入缓存
    $('#putBtn').on("click", function (e) {
        var data={
            name:$("#putName").val(),
            age:$("#putAge").val(),
            address:$("#putAddress").val()
        };

        var request = $.ajax({
            url: "/cache/concurrentmap/put",
            method: "PUT",
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
                $("#cachePutOneData").html(html);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

    // @CacheEvict DB删除一条数据并从缓存中也删除
    $('#evictBtn').on("click", function (e) {
        var request = $.ajax({
            url: "/cache/concurrentmap/evict?id="+$("#evictIdTxt").val(),
            contentType:"application/json"
        });

        request.done(function (data) {
            if (data) {
                $("#evictData").html(data);
            }
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

    // 查询所有数据
    $('#getAll').on("click", function (e) {
        var request = $.ajax({
            url: "/cache/concurrentmap/alldata",
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
            alert("Request failed: " + jqXHR.responseJSON.message);
        });
    });

});