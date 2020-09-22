/**
 * 项目名称:  my-shop
 * 文件名:    UNamePwdNewUtils
 * 作者:     金威
 * 修改日期:  2020/9/11 19:04
 * 描述:
 */
package com.jinwei.my.shop.commons.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class  UNamePwdNewUtils {
    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    public static String  generateToken() {

            //如果字符种类不够，可以自己再添加一些
             String range = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

                Random random = new Random();
                StringBuffer result = new StringBuffer();
                //要生成几位，就把这里的数字改成几
                for ( int i = 0; i < 8; i++ ){
                    result.append( range.charAt( random.nextInt( range.length() ) ) );
                }


                return DigestUtils.md5DigestAsHex(result.toString ().getBytes ());

            }
}
