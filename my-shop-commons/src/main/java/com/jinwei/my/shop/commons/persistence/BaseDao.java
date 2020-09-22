/**
 * 项目名称:  my-shop
 * 文件名:    BaseDao
 * 作者:     金威
 * 修改日期:  2020/7/24 19:41
 * 描述:
 */
package com.jinwei.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 */
public interface BaseDao<T extends BaseEntity> {

        /**
         * 查询全部数据
         * @return
         */
         List<T> selectAll();

        /**
         * 新增数据
         * @param entity
         */
        void insert(T entity);

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
         * 批量删除
         * @param ids
         */
        void deleteMulti(String[] ids);

        /**
         * 分页查询
         * @param params 需要start和length两个参数，start记录开始的位置，length每页记录数
         * @return
         */
        List<T> page(Map<String,Object> params);

        /**
         * 查询总笔数
         * @return
         */
        int count(T entity);
    }


