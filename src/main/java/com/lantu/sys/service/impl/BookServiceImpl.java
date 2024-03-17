package com.lantu.sys.service.impl;

import com.lantu.sys.entity.Book;
import com.lantu.sys.mapper.BookMapper;
import com.lantu.sys.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rebecca
 * @since 2023-10-15
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<String> getBookxs(){
        List<String> list = bookMapper.getBooks();
        return  list;
    }
    @Override
    public Map<String, Object> getTypes(){
        Map<String, Object> data = new HashMap<>();
        data.put("totalxixi",bookMapper.getTypex());
        return data;

    }



}
