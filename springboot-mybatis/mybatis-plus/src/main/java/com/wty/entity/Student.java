package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所在学院
     */
    @TableField("COLLEGE_ID")
    private String collegeId;

    /**
     * 所在班级
     */
    @TableField("CLASS_ID")
    private String classId;

    /**
     * 学号
     */
    @TableId("ID")
    private String id;

    /**
     * 学生姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 身份证号
     */
    @TableField("ID_CARD_NO")
    private String idCardNo;

    /**
     * 英文名
     */
    @TableField("ENG_NAME")
    private String engName;

    /**
     * 手机号
     */
    @TableField("MOBILE_PHONE")
    private String mobilePhone;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 出生日期
     */
    @TableField("BIRTH")
    private LocalDate birth;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 身高
     */
    @TableField("HEIGHT")
    private BigDecimal height;

    /**
     * 体重
     */
    @TableField("WEIGHT")
    private BigDecimal weight;

    /**
     * 民族
     */
    @TableField("NATION")
    private String nation;

    /**
     * 政治面貌
     */
    @TableField("POLITICAL")
    private String political;

    /**
     * 婚姻状况
     */
    @TableField("MARITAL")
    private String marital;

    /**
     * 籍贯（省） 国标行政区域代码-省级
     */
    @TableField("DOMICILE_PLACE_PROVINCE")
    private String domicilePlaceProvince;

    /**
     * 籍贯（市） 国标行政区域代码-市级
     */
    @TableField("DOMICILE_PLACE_CITY")
    private String domicilePlaceCity;

    /**
     * 户籍地址
     */
    @TableField("DOMICILE_PLACE_ADDRESS")
    private String domicilePlaceAddress;

    /**
     * 爱好
     */
    @TableField("HOBBY")
    private String hobby;

    /**
     * 简要介绍
     */
    @TableField("INTRO")
    private String intro;

    /**
     * 居住地址
     */
    @TableField("PRESENT_ADDRESS")
    private String presentAddress;

    /**
     * 电子邮件
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 入学日期
     */
    @TableField("ENTRY_DATE")
    private LocalDate entryDate;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    /**
     * 版本号
     */
    @TableField("VERSION")
    private Integer version;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;


}
