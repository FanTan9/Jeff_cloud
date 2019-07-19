package com.jeff.client.impl;

import com.jeff.client.IMyFeignClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tangfan
 * @Date:2019/7/14
 * @Description:com.jiefu.client.impl
 * @version:1.0
 */
@Component
public class MyFeignClientImpl implements IMyFeignClient {
    @Override
    public String getById(Long id) {
        return "错误";
    }

    @Override
    public Map<String, Object> getAll() {
        return rollBackMap();
    }

    @Override
    public Map<String, Object> deleteById(Long id) {
        return rollBackMap();
    }

    @Override
    public Map<String, Object> updateUser(Map<String, Object> map) {
        return rollBackMap();
    }

    public Map<String, Object> rollBackMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 201);
        map.put("msg", "访问错误");
        map.put("data", null);
        return map;
    }
}
