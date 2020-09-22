/**
 * 项目名称:  my-shop
 * 文件名:    TbUserServiceImpl
 * 作者:     金威
 * 修改日期:  2020/5/22 10:47
 * 描述:
 */
package com.jinwei.my.shop.web.admin.service.impl;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.dto.PageInfo;
import com.jinwei.my.shop.commons.validator.BeanValidator;
import com.jinwei.my.shop.domain.TbUser;
import com.jinwei.my.shop.web.admin.dao.TbUserDao;
import com.jinwei.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {

        return tbUserDao.selectAll ();
    }

    @Override
    @Transactional
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator (tbUser);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail (validator);
        }
        //验证通过
        else {
            tbUser.setUpdated (new Date ());
            //密码需要加密处理
            tbUser.setPassword (DigestUtils.md5DigestAsHex (tbUser.getPassword ().getBytes ()));

            //新增用户
            if (tbUser.getId () == null) {
                tbUser.setCreated (new Date ());

                tbUserDao.insert (tbUser);
            }

            //编辑用户
            else {
                tbUserDao.update (tbUser);
            }
            return BaseResult.success ("保存用户信息成功");
        }

    }


    @Override
    @Transactional
    public void delete(Long id) {
        tbUserDao.delete (id);

    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById (id);
    }

    @Override
    @Transactional
    public void update(TbUser tbUser) {
        tbUserDao.update (tbUser);
    }


    @Override
    public TbUser Login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail (email);
        if (tbUser!=null){
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex (password.getBytes ());
            //判断加密后的密码与数据库中的MD5密文是否匹配，匹配则表示允许登录
            if (md5Password.equals (tbUser.getPassword ())){
                return tbUser;

            }
        }
        return null;
    }

    @Override
    public TbUser getByEmail(String email) {
        return tbUserDao.getByEmail (email);
    }


    @Override
    @Transactional
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti (ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser) {
        int count=tbUserDao.count (tbUser);

        Map<String ,Object> params= new HashMap<> ();
        params.put ("start",start);
        params.put("length",length);
        params.put ("tbUser",tbUser);


        PageInfo<TbUser> pageInfo= new PageInfo<> ();
        pageInfo.setDraw (draw);
        pageInfo.setRecordsTotal (count);
        pageInfo.setRecordsFiltered (count);
        pageInfo.setData (tbUserDao.page ( params));

        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count (tbUser);
    }
}
