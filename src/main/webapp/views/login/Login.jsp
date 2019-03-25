<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-22
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/common/header.jsp"%>

<html>
<head>
    <title>登录</title>
<style type="text/css">
    .form-style{
        width: 310px;
        height: 300px;
        /*background-color: orange;*/
        margin: auto;
        margin-top: 200px;
    }
    .header-title{
        text-align: center;
    }


</style>
</head>
<body class="login-body body main-bg-color">

<div class="login-box ">
    <form class="layui-form layui-form-pane form-style" method="get" action="">
        <div class="layui-form-item">
            <h2 class="header-title">OA后台登录系统</h2>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号：</label>

            <div class="layui-input-inline">
                <input type="text" name="account" class="layui-input" lay-verify="account" placeholder="账号" autocomplete="on" maxlength="20"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>

            <div class="layui-input-inline">
                <input type="password" name="password" class="layui-input" lay-verify="password" placeholder="密码" maxlength="20"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码：</label>

            <div class="layui-input-inline">
                <input type="number" name="code" class="layui-input" lay-verify="code" placeholder="验证码" maxlength="4"/><img src="img/v.png" onclick="getImage()" title="单击刷新验证码" id="img_rand_code" alt="">
            </div>
        </div>
        <div class="layui-form-item" style="margin-right: 10px;">
            <button type="reset" class="layui-btn layui-btn-danger btn-reset layui-col-xs5">重置</button>
            <button type="button" class="layui-btn btn-submit layui-col-xs5" lay-submit="" lay-filter="sub" style="float: right">立即登录</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {
        var $ = layui.jquery,
            form = layui.form,
            layer = layui.layer;
        // 验证
        form.verify({
            account: function (value) {
                if (value == "") {
                    return "请输入用户名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
                }
            },
            code: function (value) {
                if (value == "") {
                    return "请输入验证码";
                }
            }
        });
        // 提交监听
        form.on('submit(sub)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        })
    })

    //刷新验证码
    function getImage() {
//  $("#img_rand_code").attr("src", "" + Date());
        alert("123");
    }


</script>
</body>

</html>
