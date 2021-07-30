package com.jtp7.demo.service.impl;

import com.jtp7.demo.entity.Users;
import com.jtp7.demo.mapper.UsersMapper;
import com.jtp7.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public List<Users> selectUserlist() {
        return usersMapper.selectList(null);
    }

    @Override
    public Users selectUserById(Users users) {
        return usersMapper.selectById(users);
    }

    @Override
    public int updateUserById(Users users) {
        return usersMapper.updateById(users);
    }

    @Override
    public int deleteUserById(Users users) {
        return usersMapper.deleteById(users);
    }

    @Override
    public int insertUser(Users users) {
        return usersMapper.insert(users);
    }
}
