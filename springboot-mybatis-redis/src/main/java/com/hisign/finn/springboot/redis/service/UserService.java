package com.hisign.finn.springboot.redis.service;


import com.hisign.finn.springboot.redis.domain.User;

import java.util.List;

/**
 * @user shaofa
 * @date 2017年04月15日 14:43
 * @interface UserService
 */
public interface UserService {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<User> list();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delete(String id);
}
