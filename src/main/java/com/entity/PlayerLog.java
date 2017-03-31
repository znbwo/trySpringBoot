package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
@Entity
public class PlayerLog {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer pid;
    private Short logType;
    private Short resource;
    private Integer num;
    private Long time;

    public PlayerLog() {
    }

    public PlayerLog(Integer pid, Short logType, Short resource, Integer num, Long time) {
        this.pid = pid;
        this.logType = logType;
        this.resource = resource;
        this.num = num;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }


    public Short getLogType() {
        return logType;
    }

    public void setLogType(Short logType) {
        this.logType = logType;
    }

    public Short getResource() {
        return resource;
    }

    public void setResource(Short resource) {
        this.resource = resource;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PlayerLog{" +
                "id=" + id +
                ", pid=" + pid +
                ", logType=" + logType +
                ", resource=" + resource +
                ", num=" + num +
                ", time=" + time +
                '}';
    }
}
