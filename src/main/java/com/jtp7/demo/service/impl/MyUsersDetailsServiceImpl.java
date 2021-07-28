package com.jtp7.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jtp7.demo.entity.Users;
import com.jtp7.demo.mapper.UsersMapper;
import com.jtp7.demo.service.MyUsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUsersDetailsServiceImpl implements MyUsersDetailsService {

        @Autowired
        private UsersMapper usersMapper;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            //调用usersMapper方法，根据用户名查询数据库
            QueryWrapper<Users> wrapper = new QueryWrapper();
            // where username=?
            wrapper.eq("username",username);
            Users users = usersMapper.selectOne(wrapper);
            //判断
            if(users == null) {//数据库没有用户名，认证失败
                throw  new UsernameNotFoundException("用户名不存在！");
            }
            List<GrantedAuthority> auths =
                    AuthorityUtils.commaSeparatedStringToAuthorityList("guests");
            if (users.getPosition() == 0) {
                auths = AuthorityUtils.commaSeparatedStringToAuthorityList("manager,ROLE_manager");
            }
            if (users.getPosition() == 1) {
                auths = AuthorityUtils.commaSeparatedStringToAuthorityList("finance,ROLE_finance");
            }
            if (users.getPosition() == 2) {
                auths = AuthorityUtils.commaSeparatedStringToAuthorityList("driver,ROLE_driver");
            }
            //从查询数据库返回users对象，得到用户名和密码，返回
            return new User(users.getUsername(),
                    new BCryptPasswordEncoder().encode(users.getPassword()),auths);
        }
}
