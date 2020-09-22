package com.jinwei.my.shop.web.api.service.impl;

import com.jinwei.my.shop.commons.utils.UNamePwdNewUtils;
import com.jinwei.my.shop.domain.TbMember;
import com.jinwei.my.shop.web.api.dao.TbMemberDao;
import com.jinwei.my.shop.web.api.service.TbMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class TbMemberServiceImpl implements TbMemberService {

    @Autowired
    private TbMemberDao tbMemberDao;

    @Override
    public TbMember login(TbMember tbMember) {
        TbMember member = tbMemberDao.login(tbMember);

        if (member != null) {
            // 将明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbMember.getPassword().getBytes());
            if (password.equals(member.getPassword())) {
                return member;
            }
        }

        return null;
    }


    @Override
    @Transactional
    public TbMember register(TbMember tbMember) {
//        if (checkPhoneRegister (tbMember.getPhone ()) !=0)
//        {
//            return null;
//        }
//        else{
            tbMember.setCreated (new Date ());
            tbMember.setUpdated (new Date ());
            //生成随机用户名和密码
            tbMember.setUsername (UNamePwdNewUtils.getStringRandom (10));
            tbMember.setPassword (DigestUtils.md5DigestAsHex(tbMember.getPassword ().getBytes ()));
            tbMemberDao.insert (tbMember);
            return tbMember;

//        }


    }


    @Override
    public int checkPhoneRegister(String phone) {
        return tbMemberDao.checkPhoneRegister ( phone);
    }

}
