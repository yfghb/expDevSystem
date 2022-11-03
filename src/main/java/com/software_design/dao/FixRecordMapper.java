package com.software_design.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software_design.entity.FixRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FixRecordMapper extends BaseMapper<FixRecord> {
}
