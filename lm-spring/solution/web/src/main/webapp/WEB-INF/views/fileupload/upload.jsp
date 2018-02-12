<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>fileUpload</title>
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script src="/static/js/ajaxfileupload.js"></script>
</head>
<body>
<h3>文件上传</h3>
<h3>采用 fileUpload_multipartFile ， file.transferTo 来保存上传的文件</h3>
<form   name="form1"
        action="/FileUpload/fileUpload_multipartFile"
        method="post"
        enctype="multipart/form-data">
    <input type="file" name="file_upload">
    <input type="submit" value="上传">
</form>
<hr>
<h3>采用 fileUpload_multipartRequest file.transferTo 来保存上传文件</h3>
<form name="form2"
      action="/FileUpload/fileUpload_multipartRequest"
      method="post"
      enctype="multipart/form-data">
    <input type="file" name="file_upload">
    <input type="submit" value="上传">
</form>
<hr>
<h3>采用 CommonsMultipartResolver file.transferTo 来保存上传文件</h3>
<form name="form3"
      action="/FileUpload/fileUpload_CommonsMultipartResolver"
      method="post"
      enctype="multipart/form-data">
    <input type="file" name="file_upload">
    <input type="submit" value="上传">
</form>
<hr>
<h3>通过流的方式上传文件</h3>
<form name="form4"
      action="/FileUpload/fileUpload_stream"
      method="post"
      enctype="multipart/form-data">
    <input type="file" name="file_upload">
    <input type="submit" value="上传">
</form>
<hr>
<h3>通过ajax插件 ajaxfileupload.js 来异步上传文件</h3>
<form name="form5"
      action="/"
      method="post"
      enctype="multipart/form-data">
    <input type="file" id="file_AjaxFile" name="file_AjaxFile">
    <input type="button" value="上传" onclick="fileUploadAjax()" >
    <span id="sp_AjaxFile"></span>
    <br>
    上传进度：<span id="sp_fileUploadProgress">0%</span>
</form>
<script type="text/javascript">
    //
    var progressInterval=null;
    var i=0;
    var getProgress=function () {
        $.get(
            "/FileUpload/fileUploadprogress",
            {},
            function (data) {
                $("#sp_fileUploadProgress").html(i++ + data);
                if(data==100||i==100){
                    clearInterval(progressInterval);
                }
            });
    };

    //
    function fileUploadAjax() {
        if($("#file_AjaxFile").val().length>0){
            progressInterval=setInterval(getProgress(),500);
            $.ajaxFileUpload({
                // 用于文件上传的服务器端请求地址
                url:'/FileUpload/fileUpload_ajax',
                type:'post',
                // 一般设置为false
                secureuri:false,
                // 文件上传空间的id属性  <input type="file" id="file1" name="file" />
                fileElementId:'file_AjaxFile',
                // 返回值类型 一般设置为json
                dataType:'application/json',
                // 服务器成功响应处理函数
                success:function (data) {
                    var jsonObject=eval('('+data+')');
                    $("#sp_AjaxFile").html("Upload Success ！ filePath:"+jsonObject.filePath);
                },
                // 服务器响应失败处理函数
                error:function (data,status,e) {
                    alert(e);
                }
            });
        }else {
            alert("请选择文件!");
        }
    }
</script>
<hr>
<h3>多文件上传 采用 MultipartFile[] multipartFile 上传文件方法</h3>
<form name="form5"
      action="/FileUpload/fileUpload_spring_list"
      method="post"
      enctype="multipart/form-data">
    <input type="file" name="file_upload">
    <input type="file" name="file_upload">
    <input type="file" name="file_upload">
    <input type="submit" value="上传多个"/>
</form>
<hr>
<h3>通过 a 标签的方式进行文件下载</h3>
<a href="/files/download/mst.txt">通过 a 标签下载文件 mst.txt</a>
<hr>
<h3>通过 Response 文件流的方式下载文件</h3>
<a href="/FileUpload/fileDownload_servlet">通过 文件流 的方式下载文件 mst.txt</a>
</body>
</html>