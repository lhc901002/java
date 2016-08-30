package com.michaelliu.demo.java.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by Michael on 8/9/16.
 */
public class AccountVo implements Serializable {

    private static final long serialVersionUID = -7736650118727147762L;

    private Long id;

    private String name;

    private Integer balance;

    private String createTime;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("balance", balance)
                .append("createTime", createTime)
                .append("updateTime", updateTime)
                .toString();
    }

}
