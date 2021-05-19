package com.changgou.goods.service.impl;

import com.changgou.dao.AlbumMapper;
import com.changgou.goods.pojo.Album;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    /***
     * Album条件+分页查询
     * @param album 查询条件
     * @param page  页码
     * @param size  页大小
     * @return  分页结果
     */
    @Override
    public PageInfo<Album> findPage(Album album, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(album);
        return new PageInfo<Album>(albumMapper.selectByExample(example));
    }

    /***
     * Album分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Album> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Album>(albumMapper.selectAll());
    }

    /***
     * Album条件查询
     * @param album
     * @return
     */
    @Override
    public List<Album> findPage(Album album) {
        //构建查询条件
        Example example = createExample(album);
        //根据构建的条件查询数据
        return albumMapper.selectByExample(example);
    }

    /***
     * 删除
     * @param id
     */
    @Override
    public void delete(long id) {
        albumMapper.deleteByPrimaryKey(id);
    }

    /***
     * 修改Album
     * @param album
     */
    @Override
    public void update(Album album) {
        albumMapper.updateByPrimaryKey(album);
    }

    /***
     * 增加Album
     * @param album
     */
    @Override
    public void add(Album album) {
        albumMapper.insert(album);
    }

    /***
     * 根据ID查询Album
     * @param id
     * @return
     */
    @Override
    public Album findById(long id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    /***
     * 查询Album全部数据
     * @return
     */
    @Override
    public List<Album> findAll() {
        return albumMapper.selectAll();
    }

    /***
     * Album构建查询对象
     * @param album
     * @return
     */
    public Example createExample(Album album){
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if(album != null){
            //编号
            if(!StringUtils.isEmpty(album.getId())){
                criteria.andEqualTo("ID", album.getId());
            }
            //相册名称
            if(!StringUtils.isEmpty(album.getTitle())){
                criteria.andEqualTo("title", "%" + album.getTitle() + "%");
            }
            //相册封面
            if(!StringUtils.isEmpty(album.getImage())){
                criteria.andEqualTo("image", album.getImage());
            }
            //图片列表
            if(!StringUtils.isEmpty(album.getImageItems())){
                criteria.andEqualTo("imageItems", album.getImageItems());
            }
        }
        return example;
    }
}
