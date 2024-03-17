package com.lantu.sys.service;

import com.lantu.sys.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lantu.sys.entity.Read;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rebecca
 * @since 2023-10-15
 */
public interface IBookService extends IService<Book> {

    List<String> getBookxs();

    Map<String,Object> getTypes();
}
