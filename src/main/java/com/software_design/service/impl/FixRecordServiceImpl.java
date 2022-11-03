package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.FixRecordMapper;
import com.software_design.entity.FixRecord;
import com.software_design.service.FixRecordService;
import org.springframework.stereotype.Service;

@Service
public class FixRecordServiceImpl extends ServiceImpl<FixRecordMapper, FixRecord> implements FixRecordService {
}
