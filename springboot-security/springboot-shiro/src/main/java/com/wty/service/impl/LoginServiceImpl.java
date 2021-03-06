package com.wty.service.impl;

import com.wty.model.Permissions;
import com.wty.model.Role;
import com.wty.model.User;
import com.wty.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ADMIN
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserByName(String username) {
        //模拟数据库查询,正常情况此处是从数据库或者缓存查询。
        return getMapByName(username);
    }

    /**
     * 模拟数据库查询
     *
     * @param userName
     * @return
     */
    private User getMapByName(String userName) {
        Permissions permissions1 = new Permissions("1", "query");
        Permissions permissions2 = new Permissions("2", "add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role("1", "admin", permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User("1", "wty", "123456", roleSet);
        Map<String, User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permissions permissions3 = new Permissions("3", "query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role("2", "user", permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User("2", "wty", "123456", roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}