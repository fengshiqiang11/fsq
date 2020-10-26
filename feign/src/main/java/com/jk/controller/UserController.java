package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import com.jk.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("go")
public class UserController {
    @Autowired
    private UserService  userService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("show")
    public String show(){
        return "index";
    }

    @RequestMapping("selectUser")
    @ResponseBody
    public List<UserEntity>userList(){
        List<UserEntity>userlist= (List<UserEntity>) redisUtil.get(RedisConstant.USER_LIST_KEY);
          if(userlist==null || userlist.isEmpty()){
              userlist=userService.userList();
              redisUtil.set(RedisConstant.USER_LIST_KEY,userlist);
              redisUtil.expire(RedisConstant.USER_LIST_KEY,60);
          }
        return userlist;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(UserEntity user){
        redisUtil.del(RedisConstant.USER_LIST_KEY);
        userService.addUser(user);

    }
    @RequestMapping("delUser")
    @ResponseBody
    public void delUser(String[] ids){
        redisUtil.del(RedisConstant.USER_LIST_KEY);
        userService.delUser(ids);
    }
    @RequestMapping("selectById")
    @ResponseBody
    public UserEntity selectById(Integer id){
      return  userService.selectById(id);
    }
    @RequestMapping("zhuangtai")
    @ResponseBody
    public void zhuangtai(@RequestParam Integer userId,@RequestParam Integer userSex){
        redisUtil.del(RedisConstant.USER_LIST_KEY);
        userService.zhuangtai(userId,userSex);
    }
}
