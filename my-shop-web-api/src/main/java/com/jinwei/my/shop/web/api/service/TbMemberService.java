package com.jinwei.my.shop.web.api.service;

import com.jinwei.my.shop.domain.TbMember;

/**
 * 会员管理
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/6 9:12
 */
public interface TbMemberService {

    /**
     * 登录
     * @param tbMember
     * @return
     */
    TbMember login(TbMember tbMember);
    TbMember register(TbMember tbMember);
//    boolean checkUserNameAndPhone(TbUser tbUser);
    int checkPhoneRegister( String phone);

}
