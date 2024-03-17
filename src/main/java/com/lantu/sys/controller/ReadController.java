package com.lantu.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Read;
import com.lantu.sys.service.IReadService;
import io.lettuce.core.ConnectionEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Book 前端控制器
 * </p>
 *
 * @author rebecca
 * @since 2023-09-16
 */
@RestController
@RequestMapping("/sys/read")
@CrossOrigin
public class ReadController {

    @Autowired
    private IReadService readService;

    @GetMapping("/allInfo")
    public Result<List<Read>> getAllRead(){
        List<Read> list = readService.list();
        System.out.println(list);
        return Result.success(list,"这是您所有的读书笔记，请笑纳");
    }
    @GetMapping("/getReadList")
    public Result<Map<String,Object>> getReadList(@RequestParam(value = "bookName",required = false) String book_name,@RequestParam(value = "pageNo") Long pageNo,@RequestParam(value = "pageSize") Long pageSize){
        //get Data
        LambdaQueryWrapper<Read> wrapper = new LambdaQueryWrapper<>();
        //verify book name exist or not
        wrapper.eq(StringUtils.hasLength(book_name),Read::getBookName,book_name);
        //把数据传给page
        Page<Read> page = new Page<>(pageNo,pageSize);
        readService.page(page,wrapper);
        Map<String,Object> data = new HashMap<>();
        data.put("all",page.getTotal());
        data.put("row",page.getRecords());
        return Result.success(data);
    }




}
