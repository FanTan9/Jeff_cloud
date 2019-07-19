package com.jeff.utill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Classname: StringUtils
 * @PackageName: com.jeff.utill
 * @Description:
 * @Date: 2019/7/19 11:50
 * @Created by: tangfan
 * @version: 1.0.0
 */
public class StringUtils extends org.springframework.util.StringUtils {

    /**
     * 复制对象
     * @param object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object object, Class<T> clazz){
        return JSONObject.toJavaObject((JSON) JSONObject.toJSON(object), clazz);
    }
}
