package com.project.yingxieg.common.util;

import java.util.UUID;

/**
 * @author Yingxie Gao
 * @date 2019-06-27 09:50
 */
public class common {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
