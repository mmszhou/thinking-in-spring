package com.mms.thinking.in.spring.ioc.overview.domain;

import com.mms.thinking.in.spring.ioc.overview.annotaion.Super;

@Super
public class SuperUser extends User {

    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "addr='" + addr + '\'' +
                "} " + super.toString();
    }
}
