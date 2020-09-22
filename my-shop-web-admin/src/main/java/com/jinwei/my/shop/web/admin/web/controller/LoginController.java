/**
 * 项目名称:  my-shop
 * 文件名:    LoginController
 * 作者:     金威
 * 修改日期:  2020/5/21 11:28
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import com.jinwei.my.shop.commons.constant.ConstantUtils;
import com.jinwei.my.shop.domain.TbUser;
import com.jinwei.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";

    }

    /**
     * 登陆逻辑
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest,Model model){
        TbUser tbUser=tbUserService.Login (email,password);
        //登陆失败
        if (tbUser==null){
            model.addAttribute("message","用户名或密码错误，请重新输入！");
            return   login ();


        }
        //登录成功
        else {
            //将登录信息放入会话
            httpServletRequest.getSession ().setAttribute (ConstantUtils.SESSION_USER,tbUser);
            return "redirect: /main";


        }

   }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public  String logout(HttpServletRequest httpServletRequest){


        httpServletRequest.getSession ().invalidate ();
        return  "redirect: /login";
        //return  login ();
    }
}
