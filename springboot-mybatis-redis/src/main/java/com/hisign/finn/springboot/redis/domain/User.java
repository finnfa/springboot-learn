package com.hisign.finn.springboot.redis.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @user shaofa
 * @date 2017年03月14日 16:26
 * @classname User
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6458957739151895275L;

    //ID
    private Integer id;
    //姓名
    private String username;
    //性别
    private String sex;
    //年龄
    private String age;
    //兴趣
    private String hobby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
