package com.lantu.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Book;
import com.lantu.sys.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
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
 * @since 2023-10-15
 */
@RestController
@RequestMapping("/sys/book")
@CrossOrigin
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/getBooksList")
    public Result<Map<String,Object>> getBooksList(@RequestParam(value = "pageNo") Long pageNo, @RequestParam(value = "pageSize") Long pageSize){

        Page<Book> page = new Page<>(pageNo,pageSize);
        bookService.page(page);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("row",page.getRecords());
        return Result.success(data);

    }
    @PostMapping("/addBook")
    public Result<?> addBook(@RequestBody Book book){
        bookService.save(book);
        return Result.success("新增书本成功");

    }
    @PostMapping("/delete/{id}")
    public Result<?> removeBookName(@PathVariable("id") Integer id){
        bookService.removeById(id);
        return Result.success("delete success");
    }

    @GetMapping("/getBookName")
    public Result<List<String>> getBooksName(){
        List<String> list = bookService.getBookxs();

        return Result.success(list,"查询成功");
    }

    @GetMapping("/getTypeList")
    public Result<Map<String,Object>> getTypesNNN(){
        Map<String,Object> list = bookService.getTypes();
        return Result.success(list,"查询成功");

    }
    @PostMapping("/updateBookName")
    public Result<?> UpdateBookName(@RequestBody Book book){
        bookService.updateById(book);
        System.out.println("book name updates as"+book);
        return Result.success("update success");
    }



}
