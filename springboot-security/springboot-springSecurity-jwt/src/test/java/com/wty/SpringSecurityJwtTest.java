package com.wty;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/9/14 16:15
 */
@SpringBootTest
public class SpringSecurityJwtTest {

    @Test
    public void encoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }
}
