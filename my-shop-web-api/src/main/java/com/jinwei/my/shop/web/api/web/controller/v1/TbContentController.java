/**
 * 项目名称:  my-shop
 * 文件名:    TbContentController
 * 作者:     金威
 * 修改日期:  2020/9/5 17:26
 * 描述:
 */
package com.jinwei.my.shop.web.api.web.controller.v1;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.domain.TbContent;
import com.jinwei.my.shop.web.api.service.TbContentService;
import com.jinwei.my.shop.web.api.web.dto.TbContentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;
    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent= null;
        if (id == null){
            tbContent =new TbContent ();

        }
        else{//先空着

        }
        return tbContent;
    }
    @RequestMapping(value = "ppt",method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(Long categoryId){
        List<TbContentDto> tbContentDTOS=null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId (categoryId);
        if (tbContents != null && tbContents.size ()>0 ){
            tbContentDTOS =new ArrayList<> ();
            for (TbContent tbContent : tbContents) {
                TbContentDto dto =new TbContentDto ();
                BeanUtils.copyProperties (tbContent,dto);
                tbContentDTOS.add (dto);

            }


        }

        return BaseResult.success ("成功",tbContentDTOS);
    }
}
