package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.DeviceMapper;
import com.software_design.entity.Device;
import com.software_design.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
}
