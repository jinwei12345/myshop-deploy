/**
 * 项目名称:  my-shop
 * 文件名:    TbUserServiceTest
 * 作者:     金威
 * 修改日期:  2020/9/7 13:36
 * 描述:
 */
package com.jinwei.my.shop.web.api.service;

import com.jinwei.my.shop.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbMemberServiceTest {
    @Autowired
    private TbMemberService tbMemberService;
    @Test
    public  void checkUAndP(){
        TbUser tbUser =new TbUser ();
        tbUser.setEmail ("765622@qq.com");
        tbUser.setPhone ("18979527710");
        tbUser.setUsername ("jinwei");
        //tbMemberService.checkUserNameAndPhone (tbUser);


    }
    @Test
    public  void checkRegister(){
        TbUser tbUser =new TbUser ();
        tbUser.setEmail ("7656291@qq.com");
        tbUser.setPhone ("15954602598");
        tbUser.setUsername ("jinweisb");
        tbUser.setPassword ("jinwei123");
        //System.out.println (tbMemberService.register (tbUser).toString ());
    }



}
