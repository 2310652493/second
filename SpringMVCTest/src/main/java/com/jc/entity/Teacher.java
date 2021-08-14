package com.jc.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher implements Serializable {
    private int tid;
    private String tname;
    private  String sex;
    private Date times;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTimes() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(times);
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", times=" + times +
                '}';
    }
}
