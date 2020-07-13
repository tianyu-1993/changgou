package com.changgou.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
