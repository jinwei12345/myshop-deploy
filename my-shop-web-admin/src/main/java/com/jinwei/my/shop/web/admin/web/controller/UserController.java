/**
 * 项目名称:  my-shop
 * 文件名:    UserController
 * 作者:     金威
 * 修改日期:  2020/6/1 15:07
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.dto.PageInfo;
import com.jinwei.my.shop.domain.TbUser;
import com.jinwei.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value ="user")
public class UserController {
    @Autowired
     private TbUserService tbUserService;
//    @ModelAttribute
//    public TbTest getTbTest(String email){
//        String name ="test123";
//        TbTest tbTest= new TbTest();
//        tbTest.setEmail (email);
//        tbTest.setTestName (name);
//        return  tbTest;
//
//
//    }


    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser =null ;
        //如果id不为空，则从数据库获取数据
        if (id!=null){
            tbUser=tbUserService.getById (id);
        }
        else
        {
           tbUser= new TbUser ();
        }
        return tbUser;

    }

    /**
     * 跳转到用户列表页
     * @return
     */
    @RequestMapping(value ="list",method = RequestMethod.GET)
    public String list(Model model){
//        List<TbUser> tbUsers = tbUserService.selectAll ();
//       model.addAttribute ("tbUsers",tbUsers);
        return  "user_list";
    }

    /**
     * 跳转到用户表单页
     * @return
     */
    @RequestMapping(value = "form",method =RequestMethod.GET )
    public String form(){

        return "user_form";
    }

    /**
     * 保存用户信息
     * @param tbUser
     * @param redirectAttributes
     * @param model
     * @return 有些疑问还没有解决 暂定
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public  String save(TbUser tbUser ,Model model, RedirectAttributes redirectAttributes ){
        BaseResult baseResult = tbUserService.save (tbUser);
        //保存成功
        if (baseResult.getStatus () == 200) {
            redirectAttributes.addFlashAttribute ("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else {
            model.addAttribute ("baseResult2",baseResult);
            return "user_form";
        }

    }

    /**
     * 删除用户信息
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;

        if (StringUtils.isNotBlank (ids)){
            String[] idArray=ids.split (",");
            System.out.println (Arrays.toString (idArray));
            tbUserService.deleteMulti (idArray);
            baseResult=BaseResult.success ("删除数据成功") ;
        }

        else{
            baseResult=BaseResult.fail ("删除失败 ");
        }

        return baseResult;
    }

    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page" ,method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser){
        String strDraw=request.getParameter ("draw");
        String strStart=request.getParameter ("start");
        String strLength=request.getParameter ("length");

        int draw = strDraw == null ? 0 : Integer.parseInt (strDraw);
        int start = strStart == null ? 0 : Integer.parseInt (strStart);
        int length = strLength == null ? 10 : Integer.parseInt (strLength);

        //封装DataTables需要的结果
        PageInfo<TbUser> pageInfo = tbUserService.page (start, length, draw,tbUser);
        return pageInfo;

    }

    /**
     * 显示用户详情
     * @return
     */
     @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail( @ModelAttribute TbUser tbUser){
         return "user_detail";
     }
}
