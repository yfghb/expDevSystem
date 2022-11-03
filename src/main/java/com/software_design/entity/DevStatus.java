package com.software_design.entity;

import lombok.Data;

@Data
public class DevStatus {
    private Integer devId;

    private Integer count;

    private Boolean isBroken;

    private Boolean isIntact;

    private Boolean isBuy;

    private String createTime;

    private String brokenTime;

}
