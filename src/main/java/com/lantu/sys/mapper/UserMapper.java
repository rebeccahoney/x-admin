package com.lantu.sys.mapper;

import com.lantu.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rebecca
 * @since 2023-08-19
 */

public interface UserMapper extends BaseMapper<User> {
    List<String> getRoleNameByUserId(Integer userId);
}
