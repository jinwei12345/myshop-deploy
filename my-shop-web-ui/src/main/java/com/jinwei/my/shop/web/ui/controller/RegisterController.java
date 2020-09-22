package com.jinwei.my.shop.web.ui.controller;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.web.ui.api.UsersApi;
import com.jinwei.my.shop.web.ui.dto.TbMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 * <p>Title: RegisterController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/5 12:34
 */
@Controller
public class RegisterController {


    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(TbMember tbMember, HttpServletRequest httpServletRequest, Model model) throws Exception {
        String verCode= tbMember.getVerifyCode ();
        if (!verCode.equals (httpServletRequest.getSession ().getAttribute ("verifyCode"))){
            model.addAttribute ("baseResultSuccess",BaseResult.fail ("您输入的验证码有误,请重新输入"));
        }
        else {
            BaseResult baseResult=  UsersApi.register (tbMember);
            model.addAttribute ("baseResultSuccess",baseResult);
            //redirectAttributes.addAttribute ("baseResultFail",baseResult);

        }
        return  " register";


    }
    @ResponseBody
    @RequestMapping(value = "checkphone/{phone}",method = RequestMethod.GET)
    public  BaseResult checkPhone(@PathVariable String phone) throws Exception {
        BaseResult baseResult= UsersApi.checkPhone (phone);

        return   baseResult;

    }


    }


