/**
 * 项目名称:  my-shop
 * 文件名:    TbContentCategory
 * 作者:     金威
 * 修改日期:  2020/6/19 8:57
 * 描述:
 */
package com.jinwei.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jinwei.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 分类管理
 */
@Data
public class  TbContentCategory extends BaseEntity {
    @Length(min = 1,max = 20,message = "分类名称在1-20之间")
    private String name;
    private int status;
    @NotNull
    private int sortOrder;
    @JsonProperty(value = "isParent")
    private boolean isParent;
    private TbContentCategory partId;


}
