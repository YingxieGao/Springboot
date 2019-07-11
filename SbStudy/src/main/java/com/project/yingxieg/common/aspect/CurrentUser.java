package com.project.yingxieg.common.aspect;

import java.lang.annotation.*;

/**
 * @author Yingxie Gao
 * @date 2019-07-08 13:49
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    String value() default "";

    boolean required() default false;
}
