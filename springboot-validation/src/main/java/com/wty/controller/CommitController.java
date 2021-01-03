package com.wty.controller;

import com.wty.model.R;
import com.wty.model.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wty
 * @date 2020/6/23 22:37
 */
@Validated
@RestController
public class CommitController {

    /**
     * 参数校验失败抛出MethodArgumentNotValidException
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody @Valid User user){
        return R.ok("验证通过");
    }

    /**
     * 参数校验失败抛出BindException
     * @param user
     * @return
     */
    @PostMapping("/register2")
    public R register2(@Validated User user) {
        return R.ok("验证通过");
    }

    /**
     * 参数校验失败抛出ConstraintViolationException
     * @param userList
     * @return
     */
    @PostMapping("/register3")
    public R register3(@RequestBody @Valid List<User> userList) {
        return R.ok("全部验证成功");
    }

    /**
     * ''   "" 是个黑洞
     * @param url
     * @return
     */
    @GetMapping("/testString")
    public R testString(@NotBlank(message = "url 为空") String url){
        System.out.println(url.length());
        return R.ok("验证通过" + url);
    }
}
