package com.software_design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class FixRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer devId;

    private Integer fixMoney;

    private String factory;

    private String createTime;
}
