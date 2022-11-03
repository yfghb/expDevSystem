package com.software_design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software_design.dao.MessageMapper;
import com.software_design.entity.Message;
import com.software_design.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
