package com.changgou.goods.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.dao.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tianyu
 * @Date 2020/7/13 18:11
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 全部数据
     */
    @Override
    public List<Brand> findAll(){
        return brandMapper.selectAll();
    }

    /**
     * 根据Id查询数据
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 多条件查询
     * @param barnd
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
        //构建查询条件
        Example example = createExample(brand);
        //根据构建的条件查询数据
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Brand>(brandMapper.selectAll());
    }

    @Override
    public PageInfo<Brand> findListPage(Brand brand, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构成
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<Brand>(brandMapper.selectByExample(example));
    }

    /**
     * 添加数据
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 修改数据
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询对象
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand != null){
            //品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+ brand.getName()+"%");
            }
            //品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+ brand.getImage()+"%");
            }
            //品牌首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andLike("letter","%"+ brand.getLetter()+"%");
            }
            //品牌ID
            if(!StringUtils.isEmpty(brand.getId())){
                criteria.andEqualTo("id","%"+ brand.getId()+"%");
            }
            //排序
            if(!StringUtils.isEmpty(brand.getSeq())){
                criteria.andEqualTo("seq","%"+ brand.getSeq()+"%");
            }
        }
        return example;
    }

}
