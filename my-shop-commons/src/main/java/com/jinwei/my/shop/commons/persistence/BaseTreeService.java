/**
 * 项目名称:  my-shop
 * 文件名:    BaseTreeService
 * 作者:     金威
 * 修改日期:  2020/7/25 15:46
 * 描述:
 */
package com.jinwei.my.shop.commons.persistence;

import com.jinwei.my.shop.commons.dto.BaseResult;

import java.util.List;

public interface BaseTreeService<T extends BaseEntity> {
    /**
     * 查询全部数据
     * @return
     */
    List<T> selectAll();

    /**
     * 新增数据
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 根据id删除数据
     * @param id
     */
    void  delete(Long id);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新数据
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点id查询所有子类
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);


}
