<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h3 style="text-align: center">留言列表界面</h3>
    <table border="1" class="table table-bordered table-hover " >
        <tr class="bg-primary ">
            <th>主题</th>
            <th>回复</th>
            <th>作者</th>
            <th>阅读</th>
            <th>最新文章</th>

        </tr>
        <tr class="info">
            <td>1</td>
            <td>张三</td>
            <td>男</td>
            <td>20</td>
            <td>广东</td>

        </tr>
        <tr class="info">
            <td>2</td>
            <td>张三</td>
            <td>男</td>
            <td>20</td>
            <td>广东</td>
        </tr>
        <tr class="info">
            <td>3</td>
            <td>张三</td>
            <td>男</td>
            <td>20</td>
            <td>广东</td>
        </tr>
        <tr class="info">
            <td>4</td>
            <td>张三</td>
            <td>男</td>
            <td>20</td>
            <td>广东</td>
        </tr>
        <tr class="info">
            <td>5</td>
            <td>张三</td>
            <td>男</td>
            <td>20</td>
            <td>广东</td>
        </tr>
    </table>
</div>
</body>
</html>