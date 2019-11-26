package com.ritualyang.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Data
public class User {
    private String userName;
    private String password;
}
