/*
 * 项目名称:  my-shop
 * 文件名:    ContentCategoryController
 * 作者:     金威
 * 修改日期:  2020/6/19 9:14
 * 描述:
 */
package com.jinwei.my.shop.web.admin.web.controller;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.domain.TbContentCategory;
import com.jinwei.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    //    @Autowired
//    private TbContentCategoryService tbContentCategoryService;
    private TbContentCategoryService tbContentCategoryService;

    @Autowired
    private void setTbContentCategoryService(TbContentCategoryService tbContentCategoryService) {
        this.tbContentCategoryService = tbContentCategoryService;
    }

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;
        //如果id不为空，则从数据库获取数据
        if (id != null) {
            tbContentCategory = tbContentCategoryService.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;

    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();
        //排序
        sortList(sourceList, targetList, 0L);
        //System.out.println (targetList);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";

    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {

        return "content_category_form";
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentCategoryService.save(tbContentCategory);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult2", baseResult);

            return "content_category_form";
        }

    }

    /**
     * 树形结构
     *
     * @return 方法
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);

    }


    /**
     * 服务端的排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后数据源集合
     * @param parentId   父节点的Id
     */
    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {

            if (tbContentCategory.getPartId().getId().equals(parentId)) {
                targetList.add(tbContentCategory);

                //判断有没有子节点，有则继续追加
                if (tbContentCategory.isParent()) {
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getPartId().getId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, tbContentCategory.getId());
                            break;
                        }

                    }

                }
            }

        }


    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;

        if (StringUtils.isNotBlank(ids)) {
            tbContentCategoryService.delete(Long.parseLong(ids));
            baseResult = BaseResult.success("删除分类及其子类成功");
        } else {
            baseResult = BaseResult.fail("删除分类失败 ");
        }

        return baseResult;
    }


}
