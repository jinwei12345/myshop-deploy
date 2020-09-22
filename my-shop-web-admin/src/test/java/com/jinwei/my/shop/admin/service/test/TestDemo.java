/**
 * 项目名称:  my-shop
 * 文件名:    TestDemo
 * 作者:     金威
 * 修改日期:  2020/9/9 18:36
 * 描述:
 */
package com.jinwei.my.shop.admin.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TestDemo {
    @Test
    public void test( ){

            System.out.println ("error");




    }
}
