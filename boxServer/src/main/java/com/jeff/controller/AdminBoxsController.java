package com.jeff.controller;

import com.jeff.base.CommonController;
import com.jeff.base.constant.CallbackMsg;
import com.jeff.pojo.adminBoxs.AdminBoxs;
import com.jeff.pojo.adminBoxs.AdminBoxsMacVO;
import com.jeff.service.adminBoxs.IAdminBoxsService;
import com.jeff.utill.RedisUtils;
import com.jeff.utill.StringUtils;
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
public class AdminBoxsController extends CommonController {


	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private IAdminBoxsService adminBoxsService;

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

	/**
	 *
	 * @return
	 */
	@GetMapping(value = "/verificationMac")
	public Object verificationMac(AdminBoxsMacVO adminBoxsMacVO){
		if (adminBoxsMacVO.getBoxId() == null){
			return callback(CallbackMsg.PARAM_ERROR_CODE, "boxId为空","null");
		}
		if (StringUtils.isEmpty(adminBoxsMacVO.getMac())){
			return callback(CallbackMsg.PARAM_ERROR_CODE, "mac地址为空", "null");
		}
		/*if (Patterns.patternMac(adminBoxsMacVO.getMac().trim()) == false){
			return callback(CallbackMsg.PARAM_ERROR_CODE, "mac地址格式或大小写错误", "null");
		}*/
		AdminBoxs adminBoxs = null;
		AdminBoxs adminBoxsBack = null;
		try {
			adminBoxs = StringUtils.copyObject(adminBoxsMacVO, AdminBoxs.class);
			adminBoxsBack = adminBoxsService.getOne(getQueryWrapper().setEntity(adminBoxs));
			if(adminBoxsBack != null){
				return callback(CallbackMsg.SUCCESS_CODE, CallbackMsg.SUCCESS_MSG, StringUtils.copyObject(adminBoxsBack, AdminBoxsMacVO.class));
			}
			return callback(CallbackMsg.GENERAL_ERROR_CODE, "mac地址或boxId不存在", null);
		} catch (Exception e) {
			logger.error("服务器出错", e.fillInStackTrace());
			return callback(CallbackMsg.UNKNOWN_ERROR_CODE, CallbackMsg.UNKNOWN_ERROR_MSG, null);
		}
	}
}
