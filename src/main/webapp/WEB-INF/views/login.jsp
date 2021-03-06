<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content='easyui,jui,jquery easyui,easyui demo,easyui中文'/>
    <meta name="description" content='TopJUI前端框架，基于最新版EasyUI前端框架构建，纯HTML调用功能组件，不用写JS代码的EasyUI，专注你的后端业务开发！'/>
    <title>仲园物业管理系统 - 用户登录</title>
    <!-- 浏览器标签图片 -->
    <link rel="shortcut icon" href="./topjui/image/favicon.ico"/>
    <link rel="stylesheet" href="./static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./static/plugins/font-awesome/css/font-awesome.min.css">
	<!-- 引入jQuery -->
	<script src="./static/plugins/jquery/jquery.min.js"></script>
	<script src="./static/plugins/jquery/jquery.cookie.js"></script>
	<script src="./static/plugins/bootstrap/js/bootstrap.min.js"></script>    
	<!-- 设置变量prePath为应用的跟路径 -->
	<c:set scope="page" var="prePath" value="${pageContext.request.contextPath }"/>
	<!-- 导入jquery.easyui -->
	<link rel="stylesheet" type="text/css" href="${prePath}/jquery-easyui-1.5.4.2/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${prePath}/jquery-easyui-1.5.4.2/themes/icon.css"> 
	<!-- jquery.min.js必须在jquery.easyui.min.js之前否则解析不了jquery.min.js -->  
	<script type="text/javascript" src="${prePath}/jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${prePath}/jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"></script>    
    <style type="text/css">
    
    	.passcode{position:absolute;right:0;bottom:0;height:32px;margin:1px;border-left:solid 1px #ddd;text-align:center;line-height:32px;border-radius:0 4px 4px 0;}
    
        html, body {
            height: 100%;
        }

        .box {
            background: url("./topjui/image/loginBg.jpg") no-repeat center center;
            background-size: cover;

            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }

        .login-box {
            width: 100%;
            max-width: 500px;
            height: 400px;
            position: absolute;
            top: 50%;

            margin-top: -200px;
            /*设置负值，为要定位子盒子的一半高度*/

        }

        @media screen and (min-width: 500px) {
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }

        .form {
            width: 100%;
            max-width: 500px;
            height: 275px;
            margin: 2px auto 0px auto;
        }

        .login-content {
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
            height: 300px;
            width: 100%;
            max-width: 500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }

        .input-group {
            margin: 30px 0px 0px 0px !important;
        }

        .form-control,
        .input-group {
            height: 40px;
        }

        .form-actions {
            margin-top: 30px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }

        .login-title {
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            padding: 20px 10px;
            background-color: rgba(0, 0, 0, .6);
        }

        .login-title h1 {
            margin-top: 10px !important;
        }

        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }

        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }

        .flag {
            position: absolute;
            top: 10px;
            right: 10px;
            color: #fff;
            font-weight: bold;
            font: 14px/normal "microsoft yahei", "Times New Roman", "宋体", Times, serif;
        }
    </style>
    <title>${config_siteConfig.cfgCompanyName}</title>
</head>
<body>
<div class="box">
    <div class="login-box">
        <div class="login-title text-center">
            <span class="flag"><i class="fa fa-user"></i> 用户登陆</span>
            <h1>
                <small>仲园物业管理系统</small>
            </h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form:form id="modifyPassword" class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="username" name="username" class="form-control" placeholder="用户名">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="password" name="password" class="form-control"
                                       placeholder="密码" >
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="text" id="verifycode" name="verifycode" class="form-control" style="width:260px"
                                       placeholder="验证码">
								<span><img src="<c:url value='/login/getVerifyCode'/>" alt=""
											width="100" height="40" class="passcode"
											style="height:40px;cursor:pointer;"
											onclick="this.src=this.src+'?'"></span> 
                            </div>
                        </div>
                    </div>               
                    <div class="form-group form-actions">
                        <div class="col-xs-12 text-center">
                            <button type="button" id="login" class="btn btn-sm btn-success">
                                <span class="fa fa-check-circle"></span> 登录
                            </button>
                            <button type="button" id="reset" class="btn btn-sm btn-danger">
                                <span class="fa fa-close"></span> 重置
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <span class="text-danger"><i class="fa fa-warning"></i> 用户名或密码错误，请重试！</span>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    if (navigator.appName == "Microsoft Internet Explorer" &&
            (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
            navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
            navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
    ) {
        alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
    }
</script>

<script type="text/javascript">
    $(function () {
    	
    	if(location.href.match("\\?error")!=null) {
    		$('#myModal').modal();
    	}    		
    	
        $('#password').keyup(function (event) {
            if (event.keyCode == "13") {
                $("#login").trigger("click");
                return false;
            }
        });

        $("#login").on("click", function () {
    		var code = $("#verifycode").val();
        	$.post("${prePath}/login/verifyCode", { "code": code },
     			   function(data){
     			     if(data.verify) {
			    		submitForm();
     			     } else {
     			    	$.messager.alert('操作提示','验证码不正确，或者验证码已过期，请刷新验证码后重新输入验证码！','info');
     			     }
     			   }, "json");  
        });

        function submitForm() {
            if (navigator.appName == "Microsoft Internet Explorer" &&
                    (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
                    navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
                    navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
            ) {
                alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
            } else {
            	$("form:first").submit();
                var formData = {
                    username: $('#username').val(),
                    password: $('#password').val()
                };
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath}/login',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(formData),
                    success: function (data) {

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {

                    }
                });
            }
        }

        $("#reset").on("click", function () {
            $("#username").val("");
            $("#password").val("");
        });
    });
</script>
</body>
</html>