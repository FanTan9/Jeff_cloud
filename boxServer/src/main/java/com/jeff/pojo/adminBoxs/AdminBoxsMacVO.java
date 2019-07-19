package com.jeff.pojo.adminBoxs;

/**
 * @Classname: AdminBoxsMacVO
 * @PackageName: com.jeff.pojo.adminBoxs
 * @Description:
 * @Date: 2019/7/19 13:35
 * @Created by: tangfan
 * @version: 1.0.0
 */
public class AdminBoxsMacVO {

    /**
     * boxId
     */
    private Integer boxId;

    /**
     * mac地址
     */
    private String mac;

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
