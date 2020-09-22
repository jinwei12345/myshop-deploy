/**
 * 函数对象
 */
  var Validate = function () {
    /**
     * 初始化 jquery validation
     */
    var handlerInitValidate=function(){
        jQuery.validator.addMethod("mobile",function (value,element) {
            var length =value.length;
            var mobile=/^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            return this.optional(element)||mobile.test(value);
        },"请输入有效的手机号码");

        //console.log("初始化validate!");
        $("#inputForm").validate({
            errorElement:'span',
            errorClass:'help-block',
            errorPlacement:function (error,element) {
                element.parent().parent().attr("class","form-group has-error");
                error.insertAfter(element);

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