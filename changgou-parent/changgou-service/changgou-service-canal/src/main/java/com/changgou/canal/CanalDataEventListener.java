package com.changgou.canal;


import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.changgou.content.feign.ContentFeign;
import com.changgou.content.pojo.Content;
import com.xpand.starter.canal.annotation.*;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@CanalEventListener
public class CanalDataEventListener {

    @Autowired
    private ContentFeign contentFeign;
    //字符串
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    /***
//     * 增加数据监听
//     * @param eventType
//     * @param rowData
//     */
//    @InsertListenPoint
//    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
//        rowData.getAfterColumnsList().forEach((c) -> System.out.println("By--Annotation: " + c.getName() + " ::   " + c.getValue()));
//    }
//
//    /***
//     * 修改数据监听
//     * @param rowData
//     */
//    @UpdateListenPoint
//    public void onEventUpdate(CanalEntry.RowData rowData) {
//        System.out.println("UpdateListenPoint");
//        rowData.getAfterColumnsList().forEach((c) -> System.out.println("By--Annotation: " + c.getName() + " ::   " + c.getValue()));
//    }
//
//    /***
//     * 删除数据监听
//     * @param eventType
//     */
//    @DeleteListenPoint
//    public void onEventDelete(CanalEntry.EventType eventType) {
//        System.out.println("DeleteListenPoint");
//    }

    /***
     * 自定义数据修改监听
     * @param eventType
     * @param rowData
     * destination = "example"
     */
    @ListenPoint(destination = "example", schema = "changgou_content", table = {"tb_content_category", "tb_content"}, eventType = {CanalEntry.EventType.UPDATE, CanalEntry.EventType.DELETE, CanalEntry.EventType.INSERT})
    public void onEventCustomUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //1.获取列名为category_id的值
        String categoryId = getColumnValue(eventType, rowData);
        //2.调用feign 获取该分类下的所有的广告集合
        Result<List<Content>> categoryresut = contentFeign.findByCategory(Long.valueOf(categoryId));
        List<Content> data = categoryresut.getData();
        //3.使用redisTemplate存储到redis中
        stringRedisTemplate.boundValueOps("content_" + categoryId).set(JSON.toJSONString(data));
        System.out.println("content_" + categoryId+JSON.toJSONString(data));
    }

    private String getColumnValue(CanalEntry.EventType eventType, CanalEntry.RowData rowData){
        String categoryId = "";
        //判断如果是删除，则获取beforeList
        if(eventType == CanalEntry.EventType.DELETE){
            for (CanalEntry.Column column : rowData.getBeforeColumnsList()){
                if(column.getName().equalsIgnoreCase("category_id")){
                    categoryId = column.getValue();
                    return categoryId;
                }
            }
        }else {
            //判断 如果是添加 或者是更新 获取afterlist
            for (CanalEntry.Column column : rowData.getAfterColumnsList()){
                if (column.getName().equalsIgnoreCase("category_id")) {
                    categoryId = column.getValue();
                    return categoryId;
                }
            }
        }
        return categoryId;
    }
}
