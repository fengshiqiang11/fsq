package com.jk.mapper;

import com.jk.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<UserEntity> userList();

    void delUser(String[] ids);

    void zhuangtai(@RequestParam Integer userId, @RequestParam Integer userSex);
}