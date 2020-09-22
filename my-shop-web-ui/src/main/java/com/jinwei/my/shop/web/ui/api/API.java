package com.jinwei.my.shop.web.ui.api;

public class API {
    // 主机地址
    public static final String HOST = "http://localhost:8081/api/v1";

    // 内容查询接口 - 幻灯片
    public static final String API_CONTENTS_PPT = HOST + "/contents/ppt?categoryId=144";

    // 会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/members/login";
    //会员管理接口 -注册
    public static final  String API_USERS_REGISTER =HOST +"/members/register";
    //会员管理接口 -验证手机号是否注册
    public  static final  String API_USERS_CHECKPHONEREGISTER =HOST +"/members/checkphone";
}
