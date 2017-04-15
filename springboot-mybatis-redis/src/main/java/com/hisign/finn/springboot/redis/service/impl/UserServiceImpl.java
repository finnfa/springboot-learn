package com.hisign.finn.springboot.redis.service.impl;

import com.hisign.finn.springboot.redis.dao.UserDao;
import com.hisign.finn.springboot.redis.domain.User;
import com.hisign.finn.springboot.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @user shaofa
 * @date 2017年04月15日 14:43
 * @classname UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        //从缓存中获取用户信息
        String key = "user_" + id;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        //缓存中是否存在
        boolean exist = redisTemplate.hasKey(key);
        if(exist){
            User user = operations.get(key);
            log.info("从Redis中获取了id="+  user.getId() + "用户的缓存信息。");
            return user;
        }
        //从数据库中取用户信息
        User user = userDao.findById(id);
        if(user != null){
            //存入到缓存中
            operations.set(key,user);
            log.info("插入id="+  user.getId() + "用户的信息到Redis。");
        }
        return user;
    }

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    @Override
    public List<User> list() {
        return userDao.list();
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        int count = userDao.update(user);
        String key = "user_" + user.getId();
        //缓存中是否存在
        boolean exist = redisTemplate.hasKey(key);
        if(exist){
            //存在则从缓存中删除
            redisTemplate.delete(key);
            log.info("从Redis缓存中移除了id="+ user.getId() + "用户的缓存信息。");
        }
        return count;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        int count = userDao.delete(id);
        String key = "user_" + id;
        //缓存中是否存在
        boolean exist = redisTemplate.hasKey(key);
        if(exist){
            //存在则从缓存中删除
            redisTemplate.delete(key);
            log.info("从Redis缓存中移除了id="+ id + "用户的缓存信息。");
        }
        return count;
    }
}
