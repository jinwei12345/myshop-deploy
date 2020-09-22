/**
 * 项目名称:  my-shop
 * 文件名:    TbContentDao
 * 作者:     金威
 * 修改日期:  2020/9/5 17:13
 * 描述:
 */
package com.jinwei.my.shop.web.api.dao;

import com.jinwei.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbContentDao {

    List<TbContent> selectByCategoryId(Long categoryId);
}
