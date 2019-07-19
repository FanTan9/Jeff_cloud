package com.jeff.controller;

import com.jeff.utill.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: AdminBoxsController
 * @PackageName: com.jeff.controller
 * @Description: admin_boxs controller
 * @Date: 2019/7/16 11:38
 * @Created by: tangfan
 * @version: 1.0.0
 */
@RestController()
@RequestMapping(value = "/boxservice")
public class AdminBoxsController {


	@Autowired
	private RedisUtils redisUtils;

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @Desciption: 从redis通过boxId获取数据
	 * @param boxId
	 */
	@GetMapping(value = "/getByBoxId")
	public Object getByBoxId(@RequestParam("boxId") String boxId){
		Object object = null;
		try{
			object = redisUtils.get(boxId);
		}catch (Exception e){
			logger.error("服务器错误", e.fillInStackTrace());
		}
		return object;
	}


}
