/**
 * 项目名称:  my-shop
 * 文件名:    TbContentDto
 * 作者:     金威
 * 修改日期:  2020/9/5 19:11
 * 描述:
 */
package com.jinwei.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**\
 * 内容数据传输对象
 */
@Data
public class TbContentDto  implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;

}
