package com.wty.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class SchoolClass {
    /**
     * 班级ID
     */
    @Id
    private String id;

    /**
     * 所在学院
     */
    private String collegeName;

    /**
     * 所属专业
     */
    private String majorName;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 班级人数
     */
    private Integer studentNumber;

    /**
     * 辅导员
     */
    private String adviser;

    /**
     * 成立时间
     */
    private Date estabDate;

    /**
     * 学习年数
     */
    private Integer yearNumber;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人
     */
    private String cratedBy;

    /**
     * 创建时间
     */
    private Date cratedTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

}