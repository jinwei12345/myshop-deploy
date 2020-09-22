/**
 * 项目名称:  my-shop
 * 文件名:    TbMember
 * 作者:     金威
 * 修改日期:  2020/9/11 19:34
 * 描述:
 */
package com.jinwei.my.shop.web.ui.dto;

import lombok.Data;

/**
 * 注册数据传输对象
 */
@Data
public class TbMember {
    String phone ;
    String password;
    String verifyCode;
}
