/**
 * 项目名称:  my-shop
 * 文件名:    TbContentService
 * 作者:     金威
 * 修改日期:  2020/7/20 17:15
 * 描述:
 */
package com.jinwei.my.shop.web.admin.service;

import com.jinwei.my.shop.commons.persistence.BaseService;
import com.jinwei.my.shop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}




