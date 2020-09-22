<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MyShop | 个人注册</title>
    <link rel="stylesheet" href="/static/css/index.css"/>
    <link rel="stylesheet" href="/static/css/ziy.css"/>
</head>
<body>
<!--dengl-->
<div class="yiny">
    <div class="beij_center">
        <div class="dengl_logo">
            <a href="/index"><img src="/static/images/logo_1.png"></a>
            <h1>欢迎注册</h1>
        </div>
    </div>
</div>
<div class="beij_center">
    <div class="ger_zhuc_beij">
        <div class="ger_zhuc_biaot">
            <ul>
                <li class="ger_border_color"><a href="/register">个人注册</a></li>
                <i>丨</i>
                <li><a href="#">申请入驻</a></li>
                <p>我已经注册，现在就<a class="ftx-05 ml10" href="/login">登录</a></p>
            </ul>
        </div>
        <div class="zhuc_biaod">
            <form id="registerForm" action="/register" method="post" >
<%--            <div class="reg-items">--%>
<%--              	<span class="reg-label">--%>
<%--                	<label>用户名：</label>--%>
<%--              	</span>--%>

<%--                <input class="i-text" type="text" name="username">--%>
                <!--备注————display使用 inline-block-->
<%--                <div class="msg-box">--%>

<%--                    <div class="msg-box" style="display: none;">--%>
<%--                        <div class="msg-weak" style="display: inline-block;"><i></i>--%>
<%--                            <div class="msg-cont">4-20个字符，支持汉字、字母、数字及“-”、“_”组合</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="msg-weak err-tips" style="display: inline-block;">--%>
<%--                        <div>请输入用户名</div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <span class="suc-icon"></span>--%>
<%--            </div>--%>
<%--            <div class="reg-items">--%>
<%--              	<span class="reg-label">--%>
<%--                	<label>设置密码：</label>--%>
<%--              	</span>--%>
<%--                <input class="i-text" type="password" name="password">--%>
<%--                <!--备注————display使用 inline-block-->--%>
<%--                <div class="msg-box">--%>
<%--                    <div class="msg-box" style="display: none;">--%>
<%--                        <div class="msg-weak" style="display: inline-block;"><i></i>--%>
<%--                            <div class="msg-cont">键盘大写锁定已打开，请注意大小写!</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="msg-weak err-tips" style="display:none;">--%>
<%--                        <div>请输入密码</div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="reg-items">--%>
<%--              	<span class="reg-label">--%>
<%--                	<label>确认密码：</label>--%>
<%--              	</span>--%>
<%--                <input class="i-text" type="password" name="password" >--%>
<%--                <!--备注————display使用 inline-block-->--%>
<%--                <div class="msg-box">--%>
<%--                    <div class="msg-weak err-tips" style="display: none;">--%>
<%--                        <div>密码不一样</div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="reg-items">
              	<span class="reg-label">
                	<label for="phone">手机号码：</label>
              	</span>
                <input id="phone" name ="phone" class="i-text" type="text">
                <input type="button" id ="checkPhoneBtn" value="验证手机号"></input>

                <c:if test="${baseResultSuccess != null}">
                    ${baseResultSuccess.message}
                </c:if>
                <p id="checkRegister"> </p>
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label for="password">密码：</label>
              	</span>
                <input id="password" name ="password" class="i-text" type="text">
            </div>
            <div class="reg-items">
                <span class="reg-label">
                	<label for="verifyCode">验证码：</label>
              	</span>
                <input class="i-text" type="text" name="verifyCode" id="verifyCode" value="" placeholder="请输入验证码" maxlength="6">
                <input type="button" name="123" id="verCodeBtn" value="获取验证码" onclick="settime(this);"/>
                <!--备注————display使用 inline-block-->
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label> </label>
              	</span>
                <div class="dag_biaod">
                    <input type="checkbox" value="english">
                    阅读并同意
                    <a href="#" class="ftx-05 ml10">《MyShop用户注册协议》</a>
                    <a href="#" class="ftx-05 ml10">《隐私协议》</a>
                </div>
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                    <label> </label>
                </span>
                <input class="reg-btn" value="立即注册" type="submit">
            </div>
            </form>
        </div>
        <div class="xiaogg">
            <img src="/static/images/cdsgfd.jpg">
        </div>
    </div>

</div>


<div class="jianj_dib jianj_dib_1">
    <div class="beia_hao">
        <p>京ICP备：123456789号 </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<!-- jQuery Validation Plugin v1.14.0-->
<script src="/static/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="/static/plugins/jquery-validation/dist/additional-methods.min.js"></script>
<script src="/static/plugins/jquery-validation/dist/localization/messages_zh.min.js"></script>
<script src="/static/js/validate.js"></script>
<script>
    //获取验证码操作
    var counts = 60;

    function settime(val) {
        if(counts == 0) {
            val.removeAttribute("disabled");
            val.value = "获取验证码";
            counts = 60;
            return false;
        } else {
            val.setAttribute("disabled", true);
            val.value = "重新发送（" + counts + "）";
            counts--;
        }
        setTimeout(function() {
            settime(val);
        }, 1000);
    }

</script>
<script>
    $(function(){
        //获取验证码
        $("#verCodeBtn").click(function() {
            var  phone =$("#phone").val();
            $.ajax({
                url: "http://localhost:8082/sendsms/" + phone ,
                dataType: "json",//服务器返回的数据类型
                type: "get",
                success: function(data) {

                        alert("验证码发送成功，请耐心等待")

                },
                error: function() {
                    alert("发送失败");
                }
            });
        });

    })
</script>
<script>
    $(function (){
        $("#checkPhoneBtn").click(function() {
        var  phone =$("#phone").val().replace(/(^\s*)|(\s*$)/g, '');
        if (phone === '' || phone == null){
            alert("请输入手机号")
        }
        $.ajax({
            url: "http://localhost:8082/checkphone/" + phone ,
            dataType: "json",//服务器返回的数据类型
            type: "get",
            success: function(data) {
                $("#checkRegister").text(data.message) ;


                //alert(data.message);

            },
            error: function() {
                alert("服务器错误！");
            }
        });
        });


    })
</script>


</body>
</html>
