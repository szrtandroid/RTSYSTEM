package com.rt3.rtsystem.bean;

import java.io.Serializable;

/**
 * Created by RT3
 * on 2017/8/1.
 */

public class ItemBean implements Serializable {
    private String name;
    private String count;

    public ItemBean(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
