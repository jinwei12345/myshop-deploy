/**
 * 项目名称:  my-shop
 * 文件名:    TbContentCategoryServiceImpl
 * 作者:     金威
 * 修改日期:  2020/6/19 9:13
 * 描述:
 */
package com.jinwei.my.shop.web.admin.service.impl;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.validator.BeanValidator;
import com.jinwei.my.shop.domain.TbContentCategory;
import com.jinwei.my.shop.web.admin.dao.TbContentCategoryDao;
import com.jinwei.my.shop.web.admin.service.TbContentCategoryService;
import com.jinwei.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Autowired
    private TbContentService tbContentService;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll ();
    }


    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid (pid);
    }

    @Override
    @Transactional
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validator = BeanValidator.validator (tbContentCategory);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail (validator);
        }
        //验证通过
        else {
            //如果传回来的数据的parent_id等于null的话，就把它的parent_id设为0
            TbContentCategory partId = tbContentCategory.getPartId ();
            if (partId.getId () == null ||partId == null){
                tbContentCategory.getPartId ().setId (0L);
                //根目录一定是父级目录
                tbContentCategory.setParent (true);
            }

            tbContentCategory.setUpdated (new Date ());

            //新增分类
            if (tbContentCategory.getId () == null) {
                tbContentCategory.setCreated (new Date ());

                //判断有没有父级节点
                if (partId.getId () != 0L){
                    TbContentCategory currentCategoryParent = getById (partId.getId ());
                    if (currentCategoryParent !=null){
                        //为父级节点设置isParent为true
                        currentCategoryParent.setParent (true);
                        update (currentCategoryParent);
                    }

                }
                tbContentCategoryDao.insert (tbContentCategory);
            }

            //编辑分类
            else {
                tbContentCategoryDao.update (tbContentCategory);
            }
            return BaseResult.success ("保存分类信息成功");
        }


    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        List<String> targetArray = new ArrayList<> ();
        findAllChild(targetArray, id);

        String[] categoryIds = targetArray.toArray(new String[targetArray.size()]);

        // 删除类目及其子类目
        tbContentCategoryDao.delete (categoryIds);

        // 删除类目下所有内容
        tbContentService.deleteByCategoryId(categoryIds);
    }

    /**
     * 查找出所有子节点
     *
     * @param targetList
     * @param parentId
     */
    private void findAllChild(List<String> targetList, Long parentId) {
        targetList.add(String.valueOf(parentId));

        List<TbContentCategory> tbContentCategories = selectByPid(parentId);
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            findAllChild(targetList, tbContentCategory.getId());
        }
    }

    @Override
    public TbContentCategory getById(Long id){
        return tbContentCategoryDao.getById (id);

    }

    @Override
    @Transactional
    public void update(TbContentCategory tbContentCategory) {
        tbContentCategoryDao.update (tbContentCategory);

    }



}
