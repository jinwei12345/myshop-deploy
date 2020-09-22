/**
 * 项目名称:  my-shop
 * 文件名:    MainController
 * 作者:     金威
 * 修改日期:  2020/5/21 11:28
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";

    }

}
