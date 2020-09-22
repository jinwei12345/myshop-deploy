/**
 * 项目名称:  my-shop
 * 文件名:    TbUserServiceTest
 * 作者:     金威
 * 修改日期:  2020/5/22 11:05
 * 描述:
 */
package com.jinwei.my.shop.admin.service.test;

import com.jinwei.my.shop.domain.TbUser;
import com.jinwei.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public  void  testInsert(){
        TbUser tbUser=new TbUser ();
        tbUser.setId ((long) 90);
        tbUser.setEmail ("hello@email.com");
        tbUser.setUsername ("金威");
        tbUser.setPassword ("jinwei123");
        tbUser.setPhone ("18979527710");
        tbUser.setCreated (new Date ());
        tbUser.setUpdated (new Date ());
        tbUserService.save (tbUser);
    }
    @Test
    public void testDelete(){
        tbUserService.delete (90L);

    }
    @Test
    public  void testGetById(){
        System.out.println (tbUserService.getById (18L));

    }
    @Test
    public  void testUpdate(){
        TbUser tbUser = tbUserService.getById (18L);
        tbUser.setPhone ("18979527710");
        tbUser.setPassword ("jinwei123");
        tbUser.setUsername ("金威");
        tbUser.setEmail ("jinwei@jinwei.com");
        tbUser.setUpdated (new Date ());
        tbUserService.update (tbUser);
    }




}

