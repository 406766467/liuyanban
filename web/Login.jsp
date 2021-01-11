<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapValidator.min.js"></script>
    <link href="css/bootstrapValidator.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
    <script type="text/javascript" src="js/jquery.cookie.js"></script>

    <style>
        #img{
            width:100%;
            position: fixed; right: 0; bottom: 0;
            min-width: 100%; min-height: 100%;
            height: auto;
            z-index: -100;
            background-size: cover;
        }
        .form{
            background: rgba(255,255,255,0.2);width:420px;margin:120px auto;margin-right: 350px
        }

        /*阴影*/
        .fa{
            display: inline-block;top: 25px;left: 6px;position: relative;color: #ccc;
        }

        input[type="text"],input[type="password"]{
            padding-left:26px;
        }

        .checkbox{
            padding-left:21px;
        }

    </style>

</head>
<body>
<img id="img" src="img/2.jpg" alt="">
<div class="container">
    <div>
        <h2>简易留言板</h2>
    </div>
    <div class="form row">
        <div class="form-horizontal col-md-offset-3" id="login_form">
            <h3 class="form-title">用户登录</h3>
            <form id="form" action="/loginServlet" >
                <div class="col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="请输入登录名" id="loginName" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="请输入密码" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox pull-left">
                            <input type="checkbox" name="remember" id="remember" value="0"/>记住我
                        </label>
                        <label class="checkbox pull-right">
                            <a href="Register.jsp" >注册新账号</a>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <span style="color: red">${login_msg}</span>
                        <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>