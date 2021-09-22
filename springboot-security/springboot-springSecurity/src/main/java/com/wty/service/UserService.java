package com.wty.service;

import com.wty.entity.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wty
 * @date 2021/9/22 10:06
 * 描述:
 */
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名 查询数据 此处写死
        UserModel userModel = new UserModel();
        userModel.setUserName("123");
        // password : 123, 加密方式: bcrypt (可通过 passwordEncoder加密方式自行获取, 判断密码位置: DaoAuthenticationProvider)
        userModel.setPassword("{bcrypt}$2a$10$Bbf64xSFqRiSWQKFpqcANO6O7Pq.GPiLlYiFyuvRLmfGHYRmiezLy");
        return userModel;
    }
}
