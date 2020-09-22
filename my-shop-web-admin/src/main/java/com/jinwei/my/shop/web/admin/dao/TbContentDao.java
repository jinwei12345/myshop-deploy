/**
 * 项目名称:  my-shop
 * 文件名:    TbContentDao
 * 作者:     金威
 * 修改日期:  2020/7/20 17:13
 * 描述:
 */
package com.jinwei.my.shop.web.admin.dao;

import com.jinwei.my.shop.commons.persistence.BaseDao;
import com.jinwei.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    public void deleteByCategoryId(String[] categoryIds) ;

}
