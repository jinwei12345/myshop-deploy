/**
 * 项目名称:  my-shop
 * 文件名:    smstest
 * 作者:     金威
 * 修改日期:  2020/9/6 18:10
 * 描述:
 */
package com.jinwei.my.shop.web.ui.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@RestController
public class SendSmsController {

    /**
     * 调用阿里云短信接口随机生成六位数的短信验证码
     * @param phone
     * @param httpServletRequest
     * @return 返回示例{verCode: 987654}
     */
        @RequestMapping(value = "/sendsms/{phone}",method = RequestMethod.GET)
        public List<BasicNameValuePair> sendSms(@PathVariable String phone , HttpServletRequest httpServletRequest) {
            DefaultProfile profile = DefaultProfile.getProfile ("cn-hangzhou", "LTAI4G1DgAfnxSyzmxC1oeXZ", "INyfUuwmm2VRsnypuqwJBzTvmQOGWw");
            IAcsClient client = new DefaultAcsClient (profile);
            //生成六位验证码
            String verifyCode = String.valueOf (new Random ().nextInt (899999) + 100000);
            CommonRequest request = new CommonRequest ();

            request.setSysMethod (MethodType.POST);
            request.setSysDomain ("dysmsapi.aliyuncs.com");
            request.setSysVersion ("2017-05-25");
            request.setSysAction ("SendSms");
            request.putQueryParameter ("RegionId", "cn-hangzhou");
            request.putQueryParameter ("PhoneNumbers",phone);
            request.putQueryParameter ("SignName", "ABC商城");
            request.putQueryParameter ("TemplateCode", "SMS_201651320");
           //将随机生成的验证码的值带到用户的短信内容中
            request.putQueryParameter ("TemplateParam", "{\"code\":\"" + verifyCode + "\"}");



            //以json存放，这里使用的是阿里的fastjson
            List<BasicNameValuePair> pairs =new ArrayList<> ();
            //Map<String,String> test =new HashMap<> ();
            pairs.add (new BasicNameValuePair ("verCode",verifyCode));
            //将验证码存入session
            httpServletRequest.getSession ().setAttribute ("verifyCode",verifyCode);



            try {
                CommonResponse response = client.getCommonResponse (request);
                System.out.println (response.getData ());
            } catch (ServerException e) {
                e.printStackTrace ();
            } catch (ClientException e) {
                e.printStackTrace ();
            }
            return pairs;

        }

}
