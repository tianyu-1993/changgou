package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     */
    Brand findById(Integer id);

    /**
     * 多条件查询品牌方法
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页查询
     */
    PageInfo<Brand> findPage(int page, int size);

    /**
     * 多条件查询+分页查询
     */
    PageInfo<Brand> findListPage(Brand brand, int page, int size);

    /**
     * 新增品牌
     */
    void add(Brand brand);

    /**
     * 修改品牌
     */
    void update(Brand brand);

    /**
     * 删除品牌
     */
    void delete(Integer id);
}
