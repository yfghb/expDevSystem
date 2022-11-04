package com.software_design.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software_design.controller.utils.R;
import com.software_design.entity.FixRecord;
import com.software_design.service.FixRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/fixRecord")
public class FixRecordController {
    @Resource
    private FixRecordService fixRecordService;

    /**
     * 查看修理信息分页
     * @param page 页数
     * @param pageSize 行数
     * @return R<Page<FixRecord>>
     */
    @GetMapping("/page")
    public R<Page<FixRecord>> page(Integer page,Integer pageSize){
        Page<FixRecord> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<FixRecord> lqw = new LambdaQueryWrapper<>();

        lqw.orderByAsc(FixRecord::getCreateTime);
        fixRecordService.page(pageInfo,lqw);

        return R.success(pageInfo);
    }

    /**
     * 新增修理信息
     * @param record 实体
     * @return R<Boolean>
     */
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody FixRecord record){
        return R.success(fixRecordService.save(record));
    }

    
}
