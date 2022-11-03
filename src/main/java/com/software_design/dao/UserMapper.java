package com.software_design.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software_design.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from `user` where account = #{account} ")
    User selectByAct(String account);
}
