package com.project.yingxieg.common.exception;

/**
 * @author Yingxie Gao
 * @date 2019-06-26 10:43
 */
public class CommonException extends RuntimeException{
    private String message;
    public CommonException(String s) {
        message=s;
    }
    public String getErrorMessage(){
        return message;
    }
}
