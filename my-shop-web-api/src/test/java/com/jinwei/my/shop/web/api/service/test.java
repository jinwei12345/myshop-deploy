/**
 * 项目名称:  my-shop
 * 文件名:    test
 * 作者:     金威
 * 修改日期:  2020/9/11 19:02
 * 描述:
 */
package com.jinwei.my.shop.web.api.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        System.out.println (UNamePwdNewUtils.getStringRandom (6));
//        System.out.println (UNamePwdNewUtils.generateToken ());
//        int a = 5;
//        a *= a=2;
        String dg = "123";
        String df = "123";
//        System.out.println (dg==df);
//        System.out.println(a);
        Long l1 = 10L;
        Long l2 = 10L;
        int num = 6;
        long test = 100000000000L;
        float vb = (float) 2.2;
        short rt = 12345;
        double fg = 4.33;
        BigInteger big1 = new BigInteger ("111111111111111113333444");
        BigInteger bigf = new BigInteger ("11111111111113033444");
        System.out.println (big1.subtract (bigf));
        //System.out.println (big1.divide (bigf));

        Short a = 5;
        Short b = 6;
        //Short c = (a+b);


        System.out.println (l1 + l2.longValue ());
        System.out.println (l1.equals (l2));
        System.out.println (l1.equals (l2));
        System.out.println (vb);
        System.out.println (test);
        System.out.println ();
        System.out.println (rt);
        System.out.println (fg);


        List<String> stringList = new ArrayList<> ();
        String testI = "hello";
        //testI.getBytes ();
        System.out.println (Arrays.toString (testI.getBytes ()));
        Byte kdf= 123;
        //System.out.println (new Byte((byte) 123));
        System.out.println(kdf);
        byte[] ui ={66,67};
        String  ghj= "testH";
        //ghj.getBytes();
        System.out.println(Arrays.toString(ghj.getBytes()));
        //System.out.println(Arrays.toString(ui));
        char dgfgg= '6';
        System.out.println(dgfgg +1);
       // char c3='A'+'6'+'3';

        //System.out.println(c3);
        String sdf = new String(ui,1,1);
        System.out.println(sdf);
        String sdfsg= "16";
        byte[] sdffgpo =sdfsg.getBytes();
        System.out.println(Arrays.toString(sdffgpo));


    }
}
