package com.jeff.client;


import com.jeff.client.impl.MyFeignClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: IMyFeignClient
 * @Description:
 * @author: tangfan
 * @Date: 2019/7/12 0012 上午 10:09
 * @version: 1.0
 */
@FeignClient(name = "common-Server", fallback = MyFeignClientImpl.class)
public interface IMyFeignClient {


    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    String getById(@RequestParam("id")Long id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    Map<String, Object> getAll();

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    Map<String, Object> deleteById(@RequestParam("id") Long id);

    @RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
    Map<String, Object> updateUser(@RequestBody Map<String, Object> map);
}
