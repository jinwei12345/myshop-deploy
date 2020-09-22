/**
 * 项目名称:  my-shop
 * 文件名:    TbMember
 * 作者:     金威
 * 修改日期:  2020/9/11 18:52
 * 描述:
 */
package com.jinwei.my.shop.domain;

import com.jinwei.my.shop.commons.persistence.BaseEntity;
import com.jinwei.my.shop.commons.utils.RegexpUtils;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 会员实体类
 */
@Data
public class TbMember extends BaseEntity {
    private String username;
    private String password;
    @Pattern(regexp = RegexpUtils.REGEX_MOBILE_EXACT,message = "您输入的手机号格式不正确")
    private String phone;
    private String email;

}
