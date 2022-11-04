package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.DevInRecordMapper;
import com.software_design.entity.DevInRecord;
import com.software_design.service.DevInRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DevInRecordServiceImpl extends ServiceImpl<DevInRecordMapper, DevInRecord> implements DevInRecordService {
}
