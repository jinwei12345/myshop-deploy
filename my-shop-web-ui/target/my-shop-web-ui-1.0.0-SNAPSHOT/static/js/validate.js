/**
 * 函数对象
 */
  var Validate = function () {
    /**
     * 初始化 jquery validation
     */
    var handlerInitValidate=function(){
        jQuery.validator.addMethod("isMobile",function (value,element) {
            var length =value.length;
            var mobile=/^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            return this.optional(element)||mobile.test(value);
        },"请输入有效的手机号码");

        //console.log("初始化validate!");
        $("#registerForm").validate({
            rules : {
                phone: {
                    required: true,
                    minlength: 11,
                    // 自定义方法：校验手机号在数据库中是否存在
                    // checkPhoneExist : true,
                    isMobile: true
                },
                verCode : {
                    digits : true,
                    required : true
                }
            },
            messages : {
                phone: {
                    required: "请输入手机号",
                    minlength: "确认手机不能小于11个字符",
                    isMobile: "请正确填写您的手机号码"
                },
                verCode : {
                    required : "请输入验证码",
                    digits : "验证码应该输入数字"
                }
            }
        });

    };

    return{
        init:function () {
           handlerInitValidate();

        }
    }


}();

$(document).ready(function () {
    Validate.init();

});