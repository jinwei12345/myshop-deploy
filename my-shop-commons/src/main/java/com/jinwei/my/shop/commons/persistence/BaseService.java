/**
 * 项目名称:  my-shop
 * 文件名:    BaseService
 * 作者:     金威
 * 修改日期:  2020/7/24 19:54
 * 描述:
 */
package com.jinwei.my.shop.commons.persistence;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 显示所有用户信息
     * @return
     */
    List<T> selectAll();

    /***
     * 保存信息
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(T entity);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity );

    int count(T entity);

}
