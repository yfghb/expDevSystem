package com.software_design.entity;

import lombok.Data;

@Data
public class DevInRecord {
    private Integer devId;

    private String devName;

    private String type;

    private String group;

    private Integer userId;

    private Integer inCount;

    private String inTime;

}
