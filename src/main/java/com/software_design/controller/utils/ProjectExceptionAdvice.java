package com.software_design.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R<String> doException(Exception exception) {
        exception.printStackTrace();
        return R.error("未知异常！");
    }
}