package com.software_design.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer mId;

    private Integer userId;

    private String userName;

    private Integer devId;

    private String type;

    private String group;

    private Integer count;

    private String description;

    private String createTime;
}
