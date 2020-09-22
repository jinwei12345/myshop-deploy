/**
 * 项目名称:  my-shop
 * 文件名:    BaseEntity
 * 作者:     金威
 * 修改日期:  2020/6/10 15:39
 * 描述:
 */
package com.jinwei.my.shop.commons.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 */
public abstract class BaseEntity implements Serializable {
    private Long id ;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
