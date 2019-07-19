package com.jeff.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CommonController
 * @Description:
 * @author: tangfan
 * @Date: 2019/7/11 0011 下午 1:58
 * @version: 1.0
 */
public class CommonController<T> {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Map<String, Object> success(Boolean bool, String msg, Object data){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", bool);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public QueryWrapper getQueryWrapper(){
        return new QueryWrapper();
    }

    public UpdateWrapper getUpdateWrapper(){
        return new UpdateWrapper();
    }
}
