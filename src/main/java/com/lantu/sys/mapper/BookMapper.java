package com.lantu.sys.mapper;

import com.lantu.sys.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rebecca
 * @since 2023-10-15
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {

    List<String> getBooks();

    List<String> getTypex();


}
