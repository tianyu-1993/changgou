package com.changgou.framework.exception.BaseExceptionHandler;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tianyu
 * @Date 2020/7/14 17:22
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
