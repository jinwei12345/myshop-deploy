/**
 * 项目名称:  my-shop
 * 文件名:    TbContentServiceImpl
 * 作者:     金威
 * 修改日期:  2020/7/20 17:16
 * 描述:
 */
package com.jinwei.my.shop.web.admin.service.impl;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.dto.PageInfo;
import com.jinwei.my.shop.commons.validator.BeanValidator;
import com.jinwei.my.shop.domain.TbContent;
import com.jinwei.my.shop.web.admin.dao.TbContentDao;
import com.jinwei.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    @Transactional
    public void update(TbContent tbContent) {
        tbContentDao.update (tbContent);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        tbContentDao.delete (id);

    }

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll ();
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById (id);
    }

    @Override
    @Transactional
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator (tbContent);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail (validator);
        }
        //验证通过
        else {
            tbContent.setUpdated (new Date ());

            //新增用户
            if (tbContent.getId () == null) {
                tbContent.setCreated (new Date ());
                tbContentDao.insert (tbContent);
            }

            //编辑用户
            else {
                tbContentDao.update (tbContent);
            }
            return BaseResult.success ("保存内容信息成功");
        }

    }

    @Override
    @Transactional
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti (ids);

    }


    @Override
    public PageInfo<TbContent> page(int start, int length,int draw,TbContent tbContent) {
        int count=tbContentDao.count (tbContent);

        Map<String ,Object> params= new HashMap<> ();
        params.put ("start",start);
        params.put("length",length);
        params.put ("tbContent",tbContent);


        PageInfo<TbContent> pageInfo= new PageInfo<> ();
        pageInfo.setDraw (draw);
        pageInfo.setRecordsTotal (count);
        pageInfo.setRecordsFiltered (count);
        pageInfo.setData (tbContentDao.page (params));

        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count (tbContent);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteByCategoryId(String[] categoryIds) {
        tbContentDao.deleteByCategoryId (categoryIds);

    }
}
