/**
 * 项目名称:  my-shop
 * 文件名:    ContentController
 * 作者:     金威
 * 修改日期:  2020/7/20 17:17
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.dto.PageInfo;
import com.jinwei.my.shop.domain.TbContent;
import com.jinwei.my.shop.web.admin.service.TbContentService;
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

/**
 * 内容管理
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;
    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent =null ;
        //如果id不为空，则从数据库获取数据
        if (id != null){
            tbContent=tbContentService.getById (id);
        }
        else
        {
            tbContent= new TbContent ();
        }
        return tbContent;

    }

    /**
     * 跳转到内容列表页
     * @return
     */
    @RequestMapping(value ="list",method = RequestMethod.GET)
    public String list(){
        return  "content_list";
    }

    /**
     * 跳转到内容表单页
     * @return
     */
    @RequestMapping(value = "form",method =RequestMethod.GET )
    public String form(){
        return "content_form";
    }

    /**
     * 保存内容信息
     * @param tbContent
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public  String save(TbContent tbContent ,Model model, RedirectAttributes redirectAttributes ){
        BaseResult baseResult = tbContentService.save (tbContent);
        if (baseResult.getStatus () == 200) {
            redirectAttributes.addFlashAttribute ("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else {
            model.addAttribute ("baseResult2",baseResult);

            return "content_form";
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
            tbContentService.deleteMulti (idArray);
            baseResult=BaseResult.success ("删除内容成功") ;
        }

        else{
            baseResult=BaseResult.fail ("删除内容失败 ");
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
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        String strDraw=request.getParameter ("draw");
        String strStart=request.getParameter ("start");
        String strLength=request.getParameter ("length");

        int draw = strDraw == null ? 0 : Integer.parseInt (strDraw);
        int start = strStart == null ? 0 : Integer.parseInt (strStart);
        int length = strLength == null ? 10 : Integer.parseInt (strLength);

        //封装DataTables需要的结果
        PageInfo<TbContent> pageInfo = tbContentService.page (start, length, draw,tbContent);
//        //处理上传的文件名
//        List<TbContent> tbContents = pageInfo.getData ();
//        for (TbContent content : tbContents) {
//
//            content.setPic ("/static/upload/"+content.getPic ());
//
//        }

        return pageInfo;

    }

    /**
     * 显示内容详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }


}
