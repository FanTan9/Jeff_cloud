package com.jeff.base.constant;

/**
 * @Classname: CallbackMsg
 * @PackageName: com.jeff.base.constant
 * @Description:
 * @Date: 2019/7/19 14:12
 * @Created by: tangfan
 * @version: 1.0.0
 */
public interface CallbackMsg {

    /**
     * 处理成功返回code
     */
    static Integer SUCCESS_CODE = 0;
    /**
     * 处理成功
     */
    static String SUCCESS_MSG = "成功";

    /**
     * 未知错误返回code
     */
    static Integer UNKNOWN_ERROR_CODE = -1;
    /**
     * 未知错误
     */
    static String UNKNOWN_ERROR_MSG = "未知错误";
    /**
     * 参数错误返回code
     */
    static Integer PARAM_ERROR_CODE = 10001;
    /**
     * 参数错误
     */
    static String PARAM_ERROR_MSG = "参数错误";
    /**
     * 一般性错误返回code
     */
    static Integer GENERAL_ERROR_CODE = 10002;
    /**
     * 一般性错误返回code
     */
    static String GENERAL_ERROR_MSG = "一般性错误";
    /**
     * 认证失败返回code
     */
    static Integer AUTHENTICATION_FAILURE_CODE = 20005;
    /**
     * 认证失败
     */
    static String AUTHENTICATION_FAILURE_MSG = "认证失败";
    /**
     * 弹窗提示返回code
     */
    static Integer BULLET_WINDOW_CODE = 30000;
    /**
     * 弹窗提示
     */
    static String BULLET_WINDOW_MSG = "弹窗提示";

}
