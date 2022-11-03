package com.software_design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Device {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String devName;

    private String type;

    private Integer value;
}
