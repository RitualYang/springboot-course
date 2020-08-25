package com.wty.controller;

import com.wty.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
/**
 * @author WTY
 * @Date 2020/8/24 22:59
 * @Description: TODO
 */
@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {

    /**
     *
     * @param map map中的数据会在request域中
     * @return
     */
    @RequestMapping("/index")
    public String freemarker(Map<String, Object> map){
        //向数据模型放数据
        map.put("name","wty");

        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setMondy(1000.86f);
        stu1.setBirthday(new Date());

        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setAge(19);
        stu2.setMondy(200.1f);
        stu2.setBirthday(new Date());

        List<Student> friends = new ArrayList<>();
        friends.add(stu1);

        stu2.setFriends(friends);
        stu2.setBestFriend(stu1);

        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        //向数据模型放数据
        map.put("stus",stus);

        //准备map数据
        HashMap<String,Student> stuMap = new HashMap<>();

        stuMap.put("stu1",stu1);
        stuMap.put("stu2",stu2);
        //向数据模型放数据
        map.put("stu1",stu1);
        //向数据模型放数据
        map.put("stuMap",stuMap);
        //返回模板文件名称
        return "index";
    }
}
