/**
 * 项目名称:  my-shop
 * 文件名:    TbContentService
 * 作者:     金威
 * 修改日期:  2020/9/5 17:17
 * 描述:
 */
package com.jinwei.my.shop.web.api.service;

import com.jinwei.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {

    List<TbContent>selectByCategoryId(Long categoryId);
}
