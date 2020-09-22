/**
 * 项目名称:  my-shop
 * 文件名:    TbUser
 * 作者:     金威
 * 修改日期:  2020/5/22 10:36
 * 描述:
 */
package com.jinwei.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jinwei.my.shop.commons.utils.RegexpUtils;
import com.jinwei.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


@Data
public class TbUser extends BaseEntity {
    @Length(min = 6, max = 20, message = "用户名长度在6-20之间")
    private String username;
    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码长度在6-20之间")
    private String password;
    @Pattern (regexp = RegexpUtils.REGEX_MOBILE_EXACT,message = "您输入的手机号格式不正确")
    private String phone;
    @Pattern (regexp = RegexpUtils.REGEX_EMAIL, message = "您输入的邮箱格式不正确")
    private String email;


}
