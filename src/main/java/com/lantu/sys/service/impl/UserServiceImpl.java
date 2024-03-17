package com.lantu.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lantu.sys.entity.User;
import com.lantu.sys.mapper.UserMapper;
import com.lantu.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rebecca
 * @since 2023-08-19
 */
//可以在控制器里边直接调service可以实现增删该查，不用管怎么调mapper

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(User user){
        //查询用户名和密码
        LambdaQueryWrapper<User> wrapper= new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        //判断
        if(loginUser != null){
            //生成token,暂时用uuid，终极方案是jwt
            String key = "user:" + UUID.randomUUID();
            //存入redis
            loginUser.setPassword(null);//don't save password for this
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);

            //返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }



    @Override
    public Map<String, Object> getUserInfo(String token) {
        //get token of user info, redis
        Object obj = redisTemplate.opsForValue().get(token);
        //
        if (obj != null) {
            //反序列化
            User loginUser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            //
            Map<String, Object> data = new HashMap<>();
            data.put("name", loginUser.getUsername());
            data.put("avatar", loginUser.getAvatar());

            //role
            List<String> roleList = this.baseMapper.getRoleNameByUserId(loginUser.getId());

            data.put("roles", roleList);
            return data;

        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }


}
