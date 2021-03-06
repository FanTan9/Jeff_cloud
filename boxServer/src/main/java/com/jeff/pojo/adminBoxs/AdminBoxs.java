package com.jeff.pojo.adminBoxs;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @Classname: adminBoxs
 * @PackageName: com.jeff.pojo
 * @Description: 盒子实体类，字段不全
 * @Date: 2019/7/15 11:13
 * @Created by: tangfan
 * @version: 1.0.0
 */
@TableName("admin_boxs")
public class AdminBoxs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Integer boxId;

    @TableField(value = "state")
    private Integer status;

    @TableField(value = "mac")
    private String mac;

    @Override
    public String toString() {
        return "adminBoxs{" +
                "boxId=" + boxId +
                ", status=" + status +
                '}';
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
