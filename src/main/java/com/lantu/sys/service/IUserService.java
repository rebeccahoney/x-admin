package com.lantu.sys.service;

import com.lantu.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rebecca
 * @since 2023-08-19
 */

public interface IUserService extends IService<User> {
    //接口定义好了

    Map<String,Object> login(User user);
    Map<String, Object> getUserInfo(@Param("token") String token);

    void logout(String token);


}
