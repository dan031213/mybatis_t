package com.dan.intercepter;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-08 15:49
 */
public class MyIntercepter implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    public Object plugin(Object target) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
