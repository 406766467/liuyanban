<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3 class="text-info">注册页面</h3></center>
    <form action="" method="post" style="">
        <div class="form-group">
            <label  class="text-info"for="name">姓名：</label>
            <input  type="text" class="form-control " id="name" name="name" placeholder="请输入姓名" size="100px">
        </div>

        <div class="form-group">
            <label  class="text-info" for="sex">性别：</label>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
        </div>

        <div class="form-group">
            <label class="text-info" for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label class="text-info"for="address">籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>
        <label class="text-info" for="hobby">爱好：</label>
        <label class="checkbox-inline">
            <input type="checkbox" id="inlineCheckbox1" value="hobby1"> 跑步
        </label>
        <label class="checkbox-inline">
            <input type="checkbox" id="inlineCheckbox2" value="hobby2"> 阅读
        </label>
        <label class="checkbox-inline">
            <input type="checkbox" id="inlineCheckbox3" value="hobby3"> 购物
        </label>
        <div class="form-group">
            <label class="text-info" for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group has-success has-feedback">
            <label class="control-label text-info" for="inputGroupSuccess3">Email：</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                <input type="text" class="form-control" name="email" id="inputGroupSuccess3" aria-describedby="Email：">
            </div>
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>