/**
 * 项目名称:  my-shop
 * 文件名:    TbMemberDao
 * 作者:     金威
 * 修改日期:  2020/9/11 20:14
 * 描述:
 */
package com.jinwei.my.shop.web.api.dao;

import com.jinwei.my.shop.domain.TbMember;
import org.springframework.stereotype.Repository;

@Repository
public interface TbMemberDao {
    /**
     * 登录
     * @param tbMember
     * @return
     */
    TbMember login(TbMember tbMember);

    void insert(TbMember tbMember);

   // List<TbUser> checkUserNameAndPhone(TbUser tbUser);
    int checkPhoneRegister( String phone);

}
