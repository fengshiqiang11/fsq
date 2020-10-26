package com.jk.service;

import com.jk.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    List<UserEntity> userList();

    void addUser(UserEntity user);

    void delUser(String[] ids);

    UserEntity selectById(Integer id);

    void zhuangtai(@RequestParam Integer userId, @RequestParam Integer userSex);
}
