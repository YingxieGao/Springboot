package com.project.yingxieg.common.exception;

/**
 * @author Yingxie Gao
 * @date 2019-07-01 16:17
 */
public class ParamsLessException extends RuntimeException{
    public ParamsLessException() {
    }

    public ParamsLessException(String key) {
        super("【缺少关键参数 :" + key + "】");
    }
}
