package com.changgou.file.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;

/**
 * @author tianyu
 * @Date 2020/7/16 10:21
 */
public class FastdfsClientTest {

    /**
     * 文件上传
     */
    @Test
    public void upload() throws Exception {
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent" +
                "\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //创建tracker
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //执行文件上传
        String[] jpgs = storageClient.upload_file("C:\\Users\\孙家伟\\Desktop\\新服务器开通文件\\1.jpg", "jpg", null);

        for (String jpg : jpgs) {
            System.out.println(jpg);
        }

    }


    @Test
    public void delete() throws Exception {

        //加载全局配置文件
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");

        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        int group1 = storageClient.delete_file("group1", "M00/00/00/1.jpg");
        System.out.println(group1);
    }

    @Test
    public void download() throws Exception{
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");

        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过Tracker Client获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, null);
        //执行文件上传
        byte[] bytes = storageClient.download_file("group1", "M00/00/00/rBUADF8WkkeARg4YAAH2FBAhwhs369.jpg");
        File file = new File("C:\\Users\\孙家伟\\Desktop\\新服务器开通文件\\new.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * 获取文件信息数据
     */
    @Test
    public void getFileInfo() throws Exception{
        //加载全局配置文件
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");

        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过Tracker Client获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, null);

        FileInfo group1 = storageClient.get_file_info("group1", "M00/00/00/rBUADF8WkkeARg4YAAH2FBAhwhs369.jpg");
        System.out.println(group1);
    }

    //获取组相关的信息
    @Test
    public void getGroupInfo() throws Exception {
        //加载全局的配置文件
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");

        //创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer group1 = trackerClient.getStoreStorage(trackerServer, "group1");
        System.out.println(group1.getStorePathIndex());

        //组对应的服务器的地址  因为有可能有多个服务器.
        ServerInfo[] group1s = trackerClient.getFetchStorages(trackerServer, "group1", "M00/00/00/rBUADF8WkkeARg4YAAH2FBAhwhs369.jpg");
        for (ServerInfo serverInfo : group1s) {
            System.out.println(serverInfo.getIpAddr());
            System.out.println(serverInfo.getPort());
        }
    }

    @Test
    public void getTrackerInfo() throws Exception {
        //加载全局的配置文件
        ClientGlobal.init("C:\\project\\changgou\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");

        //创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();

        InetSocketAddress inetSocketAddress = trackerServer.getInetSocketAddress();
        System.out.println(inetSocketAddress);

    }

}
