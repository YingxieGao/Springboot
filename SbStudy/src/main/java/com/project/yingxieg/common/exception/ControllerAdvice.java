package com.project.yingxieg.common.exception;

import com.project.yingxieg.common.entity.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yingxie Gao
 * @date 2019-07-01 16:16
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    private static Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ResultObject handlerException(Exception e) {
        ResultObject result = new ResultObject();
        if (e instanceof ParamsLessException) {//缺少关键参数
            LOGGER.error(e.getMessage());
            return result.asParamsLess();
        } else if (e instanceof HttpRequestMethodNotSupportedException) {//不支持请求
            LOGGER.error(e.getMessage(), e);
            return result.asUnSupportedRequest();
        } else if (e instanceof EmptyResultDataAccessException){
            return result.asNotFoundError();
        } else if (e instanceof CommonException){
            CommonException commonException= (CommonException) e;
            result.setState(998);
            result.setMessage(commonException.getErrorMessage());
            return result;
        } else {
            LOGGER.error(e.getMessage(), e);
            return result.asSysError();
        }
    }
}
