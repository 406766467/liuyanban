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
    <script type="text/javascript">
        var path = "${pageContext.request.contextPath}";
        $(function () {
            getCookie();//获取cookie
            remeberNameAndPwd();//rememberMe点击事件
            validate();//校验与登录
        });

        function validate(){
            $('form').bootstrapValidator({
                fields: {
                    loginName: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    }
                }
            }).on('success.form.bv', function(e) {
                $("form").submit(function(){
                    var flag = $('#form').data("bootstrapValidator").isValid();//校验合格
                    if(flag){
                        var load = top.layer.load();
                        var $form = $('#form');
                        $.ajax({
                            url:$form.attr('action'),
                            data:$form.serialize(),
                            type:'post',
                            beforeSend:function(){
                                layer.msg('正在登录');
                            },
                            success:function(data){
                                if(data=="success"){
                                    setTimeout(function(){
                                        layer.close(load);
                                        layer.msg('登录成功');
                                        setAndRemoveCookie();//是否写入cookie
                                    },1000);
                                    setTimeout(function(){
                                        //登录返回
                                        window.location.href=path+'/menu/get.do';
                                    },2000);
                                }else{
                                    setTimeout(function(){
                                        layer.close(load);
                                        layer.msg('身份验证失败,请检查用户名或密码是否正确!',{
                                            time:3500 //3.5秒钟之后关闭
                                        });
                                    },1000);
                                }
                            },
                            error:function(e){
                                console.log(e);
                                layer.msg('出错咯o(╥﹏╥)o,请与后台联系!',{
                                    btn:'我知道了'
                                })
                            }
                        })
                    }
                })
            });
        }
        //记住用户名,默认不记住
        var checkFlag = false;

        function remeberNameAndPwd(){
            //这里是当页面是从注册页面注册成功过来
            var remFlag = $("input[type='checkbox']").is(":checked");
            if(remFlag==true){
                checkFlag = true;
            }
            //当在login.jsp页面点击是否记住
            $("#rememberMe").click(function(){
                var remFlag = $("input[type='checkbox']").is(":checked");
                if(remFlag==true){
                    $("#rememberMe").attr("checked",true);
                    checkFlag=true;
                }else{
                    $("#rememberMe").attr("checked",false);
                    checkFlag=false;
                }
            })
        }

        //写入cookie与删除
        function setAndRemoveCookie(){
            //注意 密码写入cookie的时候这里没有写加密 是不安全的
            if(checkFlag){
                var loginName = $("#loginName").val();
                var password = $("#password").val();
                $.cookie("remember","true",{expires : 7 })//单位：天
                $.cookie("loginName",loginName,{expires: 7 });
                $.cookie("password",password,{expires: 7 })
                console.log($.cookie("loginName"));
            }else{
                //删除cookie
                $.cookie("remember","false",{expires:-1 });
                $.cookie("loginName",null,{expires:-1});
                $.cookie("password",null,{expires:-1});
                console.log($.cookie("password"));
            }
        }
        //获取cookie
        function getCookie(){
            if($.cookie("remember")=="true"){
                $("#rememberMe").attr("checked",true);
                $("#loginName").val($.cookie("loginName"));
                $("#password").val($.cookie("password"));
                console.log($.cookie("password"));
            }
        }

    </script>
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
            <form id="form" action="" >
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
                        <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>