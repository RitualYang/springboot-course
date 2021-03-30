package com.wty.test;

import com.wty.MongoDbApplication;
import com.wty.entity.SchoolClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * mongo文档测试
 *
 * @author wty
 * @date 2021/1/2 21:05
 */
@SpringBootTest(classes = {MongoDbApplication.class})
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void save(){
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setAdviser("好人一生平安");
        schoolClass.setCollegeName("仁教学院");
        schoolClass.setCratedTime(new Date());
        mongoTemplate.save(schoolClass);
    }
    @Test
    public void find(){
        List<SchoolClass> schoolClasses = mongoTemplate.find(Query.query(Criteria.where("adviser").is("好人一生平安")), SchoolClass.class);
        for (SchoolClass schoolClass : schoolClasses) {
            System.out.println(schoolClass);
        }
    }
}
