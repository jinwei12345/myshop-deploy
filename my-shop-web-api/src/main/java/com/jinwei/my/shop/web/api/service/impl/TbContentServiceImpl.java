/**
 * 项目名称:  my-shop
 * 文件名:    TbContentServiceImpl
 * 作者:     金威
 * 修改日期:  2020/9/5 17:20
 * 描述:
 */
package com.jinwei.my.shop.web.api.service.impl;

import com.jinwei.my.shop.domain.TbContent;
import com.jinwei.my.shop.domain.TbContentCategory;
import com.jinwei.my.shop.web.api.dao.TbContentDao;
import com.jinwei.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;
    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory =new TbContentCategory ();
        tbContentCategory.setId (categoryId);
        TbContent tbContent =new TbContent ();
        tbContent.setTbContentCategory (tbContentCategory);
        return tbContentDao.selectByCategoryId (categoryId);
    }
}
