/**
 * 项目名称:  my-shop
 * 文件名:    AbstractBaseTreeServiceImpl
 * 作者:     金威
 * 修改日期:  2020/7/25 16:24
 * 描述:
 */
package com.jinwei.my.shop.web.admin.abstracts;

import com.jinwei.my.shop.commons.persistence.BaseEntity;
import com.jinwei.my.shop.commons.persistence.BaseTreeDao;
import com.jinwei.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity ,D extends BaseTreeDao<T>> implements BaseTreeService<T> {
    @Autowired
    private D dao;




}
