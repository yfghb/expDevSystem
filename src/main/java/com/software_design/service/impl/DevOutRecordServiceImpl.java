package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.DevOutRecordMapper;
import com.software_design.entity.DevOutRecord;
import com.software_design.service.DevOutRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DevOutRecordServiceImpl extends ServiceImpl<DevOutRecordMapper, DevOutRecord> implements DevOutRecordService {
}
