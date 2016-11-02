package com.ou.reader.bean.base;

import java.io.Serializable;

/**
 * @author yuyh.
 * @date 2016/8/4.
 */
public class ListenBase implements Serializable {

    private String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
