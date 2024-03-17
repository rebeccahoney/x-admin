package com.lantu.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.common.vo.Result;
import com.lantu.sys.entity.User;
import com.lantu.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rebecca
 * @since 2023-08-19
 */
//@Controller  --意味着返回的是视图
@RestController
@RequestMapping("/sys/user")
@CrossOrigin
public class UserController {
    //来装配service
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public Result<List<User>> getAllUsers(){
        //get data
        List<User> list = userService.list();
        return Result.success(list,"查询成功");

    }
    @RequestMapping ("/login")
    //返回的参数是key，value，所以这里用map
    public Result<Map<String,Object>> login(@RequestBody User user){
        //根据用户名密码到数据库查一下，如果存在就返回，如果不存在就返回错误
        Map<String,Object> data = userService.login(user);
        System.out.println(data);
        if(data != null){
            return Result.success(data);
        }
        return Result.Fail(500, "用户密码错误");
    }
    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
        //根据token获取信息，redis
        Map<String,Object> data = userService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.Fail(500,"登录信息失效，情重新登录");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Result.success();
    }

    @GetMapping("/getUserList")
    public Result<Map<String,Object>> getUserList(@RequestParam(value = "username",required = false) String username,@RequestParam(value = "phone",required = false) String phone,@RequestParam(value = "pageNo") Long pageNo,@RequestParam(value = "pageSize") Long pageSize){
        //get data
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //verify data if exist or not
        wrapper.eq(StringUtils.hasLength(username),User::getUsername,username);
        wrapper.eq(StringUtils.hasLength(phone),User::getPhone,phone);

        Page<User> page = new Page<>(pageNo,pageSize);
        userService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        //result jihe
        data.put("rows",page.getRecords());
        return Result.success(data);

    }
    @PostMapping("/add")
    public Result<?> addUser(@RequestBody User user){
        userService.save(user);
        return Result.success("新增用户成功");
    }
    @PostMapping("/update")
    public Result<?> updateUser(@RequestBody User user){
        user.setPassword(null);
        userService.updateById(user);
        System.out.println();
        return Result.success("update success");
    }

    @GetMapping("/{id}")
    public Result<User> getUserByid(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }
    @DeleteMapping("/{id}")
    public Result<?> removeUserByid(@PathVariable("id") Integer id){
        userService.removeById(id);
        return Result.success("delete success");
    }





}
