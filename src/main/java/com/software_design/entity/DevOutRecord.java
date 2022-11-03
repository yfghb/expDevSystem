package com.software_design.entity;

import lombok.Data;

@Data
public class DevOutRecord {
    private Integer devId;

    private String devName;

    private String type;

    private String group;

    private Integer userId;

    private Integer outCount;

    private String outTime;

}
