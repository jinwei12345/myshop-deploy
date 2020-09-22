package com.jinwei.my.shop.web.ui.api;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.utils.HttpClientUtils;
import com.jinwei.my.shop.commons.utils.MapperUtils;
import com.jinwei.my.shop.web.ui.dto.TbMember;
import com.jinwei.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 * <p>Title: UsersApi</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/6 9:41
 */
public class UsersApi {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }

    /**
     * 注册功能
     * @param tbMember
     * @return
     * @throws Exception
     */
    public static BaseResult register(TbMember tbMember) throws Exception{
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("phone", tbMember.getPhone ()));
        params.add(new BasicNameValuePair("password", tbMember.getPassword ()));
        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));
        BaseResult baseResult = MapperUtils.json2pojo (json,BaseResult.class);
        return baseResult;

    }
    /**
     * 验证手机号是否被注册
     */
    public static BaseResult checkPhone(String phone) throws Exception{
        String url =API.API_USERS_CHECKPHONEREGISTER +"?phone=" + phone;

        String json = HttpClientUtils.doGet (url);

        BaseResult baseResult = MapperUtils.json2pojo (json,BaseResult.class);
        return baseResult;


    }
}
