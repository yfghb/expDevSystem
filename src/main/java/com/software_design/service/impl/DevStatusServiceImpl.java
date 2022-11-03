package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.DevStatusMapper;
import com.software_design.entity.DevStatus;
import com.software_design.service.DevStatusService;
import org.springframework.stereotype.Service;

@Service
public class DevStatusServiceImpl extends ServiceImpl<DevStatusMapper, DevStatus> implements DevStatusService {
}
