package com.jtp7.demo.service;



import com.jtp7.demo.entity.Users;

import java.util.List;

public interface UserInfoService {

    List<Users> selectUserlist();

    Users selectUserById(Users users);

    int updateUserById(Users users);

    int deleteUserById(Users users);

    int insertUser(Users users);
}
