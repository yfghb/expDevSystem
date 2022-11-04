package com.software_design.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software_design.controller.utils.R;
import com.software_design.entity.Message;
import com.software_design.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    /**
     * 查看请求设备记录分页
     * @param page 页数
     * @param pageSize 行数
     * @param name 请求者
     * @return R<Page<Message>>
     */
    @GetMapping("/page")
    public R<Page<Message>> page(Integer page,Integer pageSize,String name){
        Page<Message> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Message> lqw = new LambdaQueryWrapper<>();

        lqw.eq(name!=null,Message::getUserName,name);
        lqw.orderByAsc(Message::getCreateTime);
        messageService.page(pageInfo,lqw);
        return R.success(pageInfo);
    }

    /**
     * 新增请求设备记录
     * @param message 实体
     * @return R<Boolean>
     */
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody Message message){
        return R.success(messageService.save(message));
    }
}
