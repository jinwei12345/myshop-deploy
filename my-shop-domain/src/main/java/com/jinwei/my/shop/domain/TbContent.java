/**
 * 项目名称:  my-shop
 * 文件名:    TbContent
 * 作者:     金威
 * 修改日期:  2020/7/20 17:04
 * 描述:
 */
package com.jinwei.my.shop.domain;

import com.jinwei.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 内容管理实体类
 */
@Data
public class TbContent extends BaseEntity {
//    @NotNull(message = "父级分类不能为空")
//    private Long categoryId;

    @Length(min = 1, max = 20 ,message = "标题长度在1-20之间")
    private String title;

    @Length(min = 1, max = 20 ,message = "子标题长度在1-20之间")
    private String subTitle;

    @Length(min = 1, max = 50 ,message = "标题描述长度在1-20之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;
    @Length(min = 1 ,message = "内容不空")
    private String content;
    @NotNull(message = "父级分类不能为空")
    private TbContentCategory tbContentCategory;

}
