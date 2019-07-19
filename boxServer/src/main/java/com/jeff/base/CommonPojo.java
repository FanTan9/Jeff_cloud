package com.jeff.base;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName: CommonPojo
 * @Description:
 * @author: tangfan
 * @Date: 2019/7/11 0011 上午 10:59
 * @version: 1.0
 */
public class CommonPojo {

    @TableId
    private Long id;
    /**
     * @Description: 是否删除,逻辑删除字段
     */
    //@TableLogic
    private Integer deleted = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
