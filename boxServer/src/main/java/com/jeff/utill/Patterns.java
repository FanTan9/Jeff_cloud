package com.jeff.utill;

import java.util.regex.Pattern;

/**
 * @Classname: Patterns
 * @PackageName: com.jeff.utill
 * @Description: 校验数据utils类
 * @Date: 2019/7/19 16:38
 * @Created by: tangfan
 * @version: 1.0.0
 */
public class Patterns {


    /**
     * 校验mac地址是否正确
     * @param mac
     * @return
     */
    public static boolean patternMac(String mac){
        String patternMac="^[A-F0-9]{2}(-[A-F0-9]{2}){5}$";
        if(!Pattern.compile(patternMac).matcher(mac).find()){
                return false;
        }
        return true;
    }
}
