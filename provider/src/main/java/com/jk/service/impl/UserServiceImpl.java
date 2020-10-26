package com.jk.service.impl;

import com.jk.entity.UserEntity;
import com.jk.mapper.UserEntityMapper;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper  userEntityMapper;
    @Override
    public List<UserEntity> userList() {
        return userEntityMapper.userList();
    }

    @Override
    public void addUser(UserEntity user) {
        if(user.getUserId()==null){
            user.setUserBithday(new Date());
            userEntityMapper.insert(user);
        }else{
            user.setUserBithday(new Date());
            userEntityMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void delUser(String[] ids) {
        userEntityMapper.delUser(ids);
    }

    @Override
    public UserEntity selectById(Integer id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public void zhuangtai(@RequestParam Integer userId,@RequestParam Integer userSex) {
        userEntityMapper.zhuangtai(userId,userSex);
    }

}
