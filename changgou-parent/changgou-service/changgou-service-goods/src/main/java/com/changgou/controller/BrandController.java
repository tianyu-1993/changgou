package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.dao.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tianyu
 * @Date 2020/7/13 18:12
 */
@RestController
@RequestMapping(value = "/brand")
/**
 * 跨域：A域名访问b域名的数据
 *      域名或者请求端口或者协议不一致时，就跨域了
 *
 */
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping
    public Result<Brand> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<Brand>(true, StatusCode.OK, "查询成功", brandList);
    }

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "查询成功", brand);
    }

    /**
     * 多条件查询数据
     */
    @PostMapping(value="/search")
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 分页查询
     */
    @GetMapping(value="/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"分页成功",pageInfo);
    }

    /**
     * 多条件查询 + 分页查询
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findListPage(@RequestBody Brand brand, @PathVariable int page, @PathVariable int size){
        //执行搜索
        PageInfo<Brand> listPage = brandService.findListPage(brand, page, size);
        return new Result<>(true,StatusCode.OK,"条件分页查询成功",listPage);
    }

    /**
     * 新增品牌数据
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /**
     * 修改数据
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id){
        //设置ID
        brand.setId(id);
        //修改数据
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    @PutMapping
    public Result update(@RequestBody Brand brand){
        //修改数据
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 根据ID删除品牌
     */
    @DeleteMapping(value="/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }


}
