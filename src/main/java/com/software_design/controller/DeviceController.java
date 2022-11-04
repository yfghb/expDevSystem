package com.software_design.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software_design.controller.utils.R;
import com.software_design.dto.DevStatusDto;
import com.software_design.entity.DevInRecord;
import com.software_design.entity.DevOutRecord;
import com.software_design.entity.DevStatus;
import com.software_design.entity.Device;
import com.software_design.service.DevInRecordService;
import com.software_design.service.DevOutRecordService;
import com.software_design.service.DevStatusService;
import com.software_design.service.DeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @Resource
    private DevStatusService devStatusService;

    @Resource
    private DevInRecordService devInRecordService;

    @Resource
    private DevOutRecordService devOutRecordService;

    /**
     * 带条件的设备信息分页查询
     * @param page 页数
     * @param pageSize 行数
     * @param type 条件
     * @return dto
     */
    @GetMapping("/page/status")
    public R<Page<DevStatusDto>> devPage(Integer page,Integer pageSize,String type){
        Page<DevStatus> devStatusPage = new Page<>(page,pageSize);
        Page<DevStatusDto> dtoPage = new Page<>();

        LambdaQueryWrapper<DevStatus> lqw = new LambdaQueryWrapper<>();
        switch (type){
            case "broken":
                lqw.eq(DevStatus::getIsBroken,true);
                lqw.orderByAsc(DevStatus::getBrokenTime);
                break;
            case "notBuy":
                lqw.eq(DevStatus::getIsBuy,false);
                lqw.orderByAsc(DevStatus::getCreateTime);
                break;
            case "fixed":
                lqw.eq(DevStatus::getIsBuy,true);
                lqw.eq(DevStatus::getIsBroken,false);
                lqw.eq(DevStatus::getIsIntact,false);
                lqw.orderByAsc(DevStatus::getCreateTime);
                break;//已购买，还没坏，修理过的设备
            default:
                lqw.eq(DevStatus::getIsBuy,true);
                lqw.orderByAsc(DevStatus::getCreateTime);
        }

        devStatusService.page(devStatusPage,lqw);
        List<DevStatus> records = devStatusPage.getRecords();
        List<DevStatusDto> list = records.stream().map((item)->{
            Device device = deviceService.getById(item.getDevId());
            DevStatusDto dto = new DevStatusDto();
            BeanUtils.copyProperties(item,dto);//复制devStatus表的信息
            BeanUtils.copyProperties(device,dto);//复制device表的信息
            return dto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }//拼接device表和deviceStatus表的信息

    /**
     * 设备归还记录信息分页
     * @param page 页数
     * @param pageSize 行数
     * @param type 设备类型
     * @param group 是哪个组织归还的
     * @return R<Page<DevInRecord>>
     */
    @GetMapping("/page/devIn")
    public R<Page<DevInRecord>> devInPage(Integer page, Integer pageSize, String type, String group){
        Page<DevInRecord> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<DevInRecord> lqw = new LambdaQueryWrapper<>();

        lqw.eq(type!=null,DevInRecord::getType,type);
        lqw.eq(group!=null,DevInRecord::getGroup,group);
        lqw.orderByAsc(DevInRecord::getInTime);

        devInRecordService.page(pageInfo,lqw);
        return R.success(pageInfo);
    }

    /**
     * 设备借出信息记录分页
     * @param page 页数
     * @param pageSize 行数
     * @param type 设备类型
     * @param group 是哪个组织借的
     * @return R<Page<DevOutRecord>>
     */
    @GetMapping("/page/devOut")
    public R<Page<DevOutRecord>> devOutPage(Integer page, Integer pageSize, String type, String group){
        Page<DevOutRecord> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<DevOutRecord> lqw = new LambdaQueryWrapper<>();

        lqw.eq(type!=null,DevOutRecord::getType,type);
        lqw.eq(group!=null,DevOutRecord::getGroup,group);
        lqw.orderByAsc(DevOutRecord::getOutTime);

        devOutRecordService.page(pageInfo,lqw);
        return R.success(pageInfo);
    }

    /**
     * 新增设备借还记录
     * @param inRecord 还设备记录
     * @param outRecord 借设备记录
     * @param type 借/还
     * @return R<Boolean>
     */
    @PostMapping("/save/record")
    public R<Boolean> saveIO(@RequestBody DevInRecord inRecord,@RequestBody DevOutRecord outRecord,String type){
        switch (type){
            case "devIn":
                devInRecordService.save(inRecord);
                break;
            case "devOut":
                devOutRecordService.save(outRecord);
                break;
            default:
                return R.error("参数错误！");
        }
        return R.success(true);
    }

    /**
     * 新增设备信息
     * @param device 实体
     * @return R<Boolean>
     */
    @PostMapping("/save")
    public R<Boolean> saveDevice(@RequestBody Device device){
        return R.success(deviceService.save(device));
    }

    /**
     * 新增设备状态信息
     * @param devStatus 实体
     * @return R<Boolean>
     */
    @PostMapping("/save/status")
    public R<Boolean> saveDevStatus(@RequestBody DevStatus devStatus){
        return R.success(devStatusService.save(devStatus));
    }

    //不提供修改和删除方法
}
