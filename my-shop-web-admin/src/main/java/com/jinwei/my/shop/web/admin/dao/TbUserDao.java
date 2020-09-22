/**
 * 项目名称:  my-shop
 * 文件名:    TbUserDao
 * 作者:     金威
 * 修改日期:  2020/5/22 10:42
 * 描述:
 */
package com.jinwei.my.shop.web.admin.dao;

import com.jinwei.my.shop.commons.persistence.BaseDao;
import com.jinwei.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

}

