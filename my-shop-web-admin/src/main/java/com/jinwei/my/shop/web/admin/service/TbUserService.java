/**
 * 项目名称:  my-shop
 * 文件名:    TbUserService
 * 作者:     金威
 * 修改日期:  2020/5/22 10:46
 * 描述:
 */
package com.jinwei.my.shop.web.admin.service;

import com.jinwei.my.shop.commons.persistence.BaseService;
import com.jinwei.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
   TbUser Login(String email, String password);
   TbUser getByEmail(String email);

}
