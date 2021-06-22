package com.changgou.goods;

import com.changgou.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tianyu
 * @Date 2020/7/13 15:52
 */

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.dao"})
@Import(AppConfig.class)
public class GoodsApplication {


    public static void main(String[] args){
        SpringApplication.run(GoodsApplication.class);

    }
}
