package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.core.io.ClassPathResource;

/**
 * @author tianyu
 * @Date 2020/7/21 15:11
 */
public class FastDFSClient {

    /**
     * 初始化Tracker信息
     */
    static{
        try{
            //获取tracker的配置文件fdfs_client.conf的位置
            String filePath = new ClassPathResource("fdfs_client.conf").getPath();
            //加载tracker的配置信息
            ClientGlobal.init(filePath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * 要上传的文件信息封装->FastDFSFile
     * 1.文件上传所存储的组名
     * 2.文件存储的路径
     */
    public static String[] upload(FastDFSFile file) throws Exception{
        //获取文件作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair(file.getAuthor());
        /**
         * 文件上传后的返回值
         * uploadFileResults[0]:文件所存储的组名，例如：group
         * uploadFileResults[1]:
         */
        String[] uploadFileResults = null;

    }


}
