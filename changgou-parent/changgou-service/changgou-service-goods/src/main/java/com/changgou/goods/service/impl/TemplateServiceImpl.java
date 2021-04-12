package com.changgou.goods.service.impl;

import com.changgou.dao.TemplateMapper;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    /**
     * Template条件+分页查询
     * @param template 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Template> findPage(Template template, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        create
        return null;
    }

    @Override
    public PageInfo<Template> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<Template> findList(Template template) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Template template) {

    }

    @Override
    public void add(Template template) {

    }

    @Override
    public Template findById(Integer id) {
        return null;
    }

    @Override
    public List<Template> findAll() {
        return null;
    }

    /**
     * Template构建查询对象
     * @param template
     * @return
     */
    public Example createExample(Template template){

    }
}
