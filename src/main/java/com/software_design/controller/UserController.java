package com.software_design.controller;

import com.software_design.controller.utils.R;
import com.software_design.entity.User;
import com.software_design.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/testHttp")
    public R<String> test(){
        return R.success("hi! SpringBoot.");
    }

    /**
     * 以account来查询user表信息
     * @param account 字符串类型 账号
     * @return R<User>
     */
    @GetMapping("/get/{account}")
    public R<User> selectByAct(@PathVariable String account){
        return R.success(userService.selectByAct(account));
    }

    /**
     * 添加
     * @param user User实体
     * @return R<Boolean>
     */
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody User user){
        return R.success(userService.save(user));
    }

    /**
     * 修改
     * @param user User实体
     * @return R<Boolean>
     */
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody User user){
        return R.success(userService.updateById(user));
    }

    /**
     * 以id删除
     * @param id Integer
     * @return R<Boolean>
     */
    @DeleteMapping("/delete/{id}")
    public R<Boolean> delete(@PathVariable Integer id){
        return R.success(userService.removeById(id));
    }
}
