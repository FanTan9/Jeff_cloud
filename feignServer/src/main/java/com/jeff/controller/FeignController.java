package com.jeff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jeff.client.IMyFeignClient;

import java.util.Map;

/**
 * @ClassName: FeignController
 * @Description:
 * @author: tangfan
 * @Date: 2019/7/12 0012 上午 10:26
 * @version: 1.0
 */
@RestController
public class FeignController {

    @Autowired
    private IMyFeignClient myFeignClient;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public String getById(@RequestParam("id")Long id){
        String str = myFeignClient.getById(id);
        logger.info("getById被调用了");
        return str;
    }

    @GetMapping(value = "/list")
    public Map<String, Object> getAll(){
        Map<String, Object> map = myFeignClient.getAll();
        logger.info("list被调用了");
        return map;
    }

    @GetMapping(value = "/deleteById")
    public Map<String, Object> deleteById(@RequestParam Long id){
        Map<String, Object> map = myFeignClient.deleteById(id);
        logger.info("deleteById被调用了");
        return map;
    }

    @PostMapping(value = "/updateUsers")
    public Map<String, Object> updateUser(@RequestBody Map<String, Object> map){
        Map<String, Object> mapBack = myFeignClient.updateUser(map);
        logger.info("updateUsers被调用了");
        return mapBack;
    }
}
