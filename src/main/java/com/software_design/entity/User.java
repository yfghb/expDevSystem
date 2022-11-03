package com.software_design.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String group;

    private String account;

    private String password;

    private String username;

    private Boolean isAdmin;
}
