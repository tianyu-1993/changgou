package com.changgou.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianyu
 * @Date 2020/7/14 14:46
 */
@Configuration
@ComponentScan(basePackages = {"com.changgou.controller","com.changgou.service"})
public class AppConfig {

}
