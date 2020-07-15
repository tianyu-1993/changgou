package com.changgou.dao;

import com.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * DAO使用通用的Mapper.Dao接口需要继承tk.mybatis.mapper.common.Mapper
 * 增加数据    调用Mapper.insert()
 * 增加数据    调用Mapper.insertSelective()
 *
 * 修改数据    调用Mapper.update(T);
 * 修改数据    调用Mapper.updateByPrtmayKey(T);
 *
 * 查询数据    根据ID查询：调用Mapper.selectByPeimayKey(ID);
 * 查询数据    条件查询：调用Mapper.select(T);
 *
 */
public interface BrandMapper extends Mapper<Brand> {
}
