package com.jk.service;

import com.jk.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "provider")
public interface UserService {

    @RequestMapping("selectUser")
    @ResponseBody
    public List<UserEntity> userList();

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(@RequestBody UserEntity user);

    @RequestMapping("delUser")
    @ResponseBody
    public void delUser(@RequestParam String[] ids);


    @RequestMapping("selectById")
    @ResponseBody
    public UserEntity selectById(@RequestParam Integer id);

    @RequestMapping("zhuangtai")
    @ResponseBody
    public void zhuangtai(@RequestParam Integer userId, @RequestParam Integer userSex);
}
