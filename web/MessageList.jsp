<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MessageList</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div>
       <a href="/houtai.jsp"><span style="float: right" class="text-info">${user.username}，欢迎回来</span></a>
    </div>
    <h3 style="text-align: center">留言列表界面</h3>
    <table border="1" class="table table-bordered table-hover ">
        <tr class="bg-primary ">
            <th width="60%">主题</th>
            <th width="20%">回复数</th>
            <th width="20%">作者</th>
        </tr>

        <c:forEach items="${messages}" var="message" varStatus="s">
            <tr class="info">
                <td class="text-left">${message.title}</td>
                <td>${message.number}</td>
                <td name="rid">${message.username}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="" method="post">
        <div class="form-group">
            <label class="text-info" for="item">主题：</label>
            <input type="text" class="form-control " id="name" name="title" placeholder="请输入主题" size="100px">
        </div>
        <div class="form-group">
            <label class="text-info" for="content">内容：</label>
            <textarea class="form-control" rows="3" name="content"></textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
        </div>

    </form>
</div>
</body>
</html>