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

    /**
     * 返回模板
     * @param code 返回代码
     * @param msg   返回消息
     * @param data  返回数据
     * @return
     */
    public Map<String, Object> callback(Integer code, String msg, Object data){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
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
