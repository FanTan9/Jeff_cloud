package com.jeff.service.adminBoxs;

import com.jeff.base.CommServiceImpl;
import com.jeff.mapper.IAdminBoxsMapper;
import com.jeff.pojo.AdminBoxs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname: AdminBoxsServiceImpl
 * @PackageName: com.jeff.service.adminBoxs
 * @Description:
 * @Date: 2019/7/15 16:16
 * @Created by: tangfan
 * @version: 1.0.0
 */
@Service
public class AdminBoxsServiceImpl extends CommServiceImpl<AdminBoxs> implements IAdminBoxsService{

	@Autowired
	private IAdminBoxsMapper adminBoxsMapper;
}
