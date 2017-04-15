package com.hisign.finn.springboot.redis.controller;

import com.hisign.finn.springboot.redis.domain.User;
import com.hisign.finn.springboot.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @user shaofa
 * @date 2017年04月15日 14:44
 * @classname UserController
 */
@Controller
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(){
        return userService.list();
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public User findById(@RequestParam String id){
        return userService.findById(id);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int add(@RequestBody  User user){
        return userService.add(user);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public int update(@RequestBody  User user){
        return userService.update(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public int delete(@RequestParam  String id){
        return userService.delete(id);
    }
}
