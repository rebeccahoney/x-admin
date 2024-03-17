package com.lantu;

import com.lantu.sys.entity.Book;
import com.lantu.sys.entity.Read;
import com.lantu.sys.entity.User;
import com.lantu.sys.mapper.BookMapper;
import com.lantu.sys.mapper.ReadMapper;
import com.lantu.sys.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest

class XAdminApplicationTests {

    //注入mapper
    @Resource
    private UserMapper userMapper;


    @Test
    void testMapper() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Resource
    private ReadMapper readMapper;
    @Test
    void testreadMapper(){
        List<Read> reads = readMapper.selectList(null);
        reads.forEach(System.out::println);
    }



}
