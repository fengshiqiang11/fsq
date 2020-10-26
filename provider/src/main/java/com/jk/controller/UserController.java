package com.jk.controller;

import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

    @RequestMapping("selectUser")
    @ResponseBody
    public List<UserEntity>userList(){
        return  userService.userList();
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(@RequestBody UserEntity user){
      userService.addUser(user);

    }

    @RequestMapping("delUser")
    @ResponseBody
    public void delUser(@RequestParam String[] ids){
      userService.delUser(ids);
    }

    @RequestMapping("selectById")
    @ResponseBody
    public UserEntity selectById(@RequestParam Integer id){
      return userService.selectById(id);
    }
  @RequestMapping("zhuangtai")
  @ResponseBody
    public void zhuangtai(@RequestParam Integer userId, @RequestParam Integer userSex){
    userService.zhuangtai(userId,userSex);
  }
}
