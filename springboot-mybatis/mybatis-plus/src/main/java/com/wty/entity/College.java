package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 学院
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院ID
     */
    @TableId("ID")
    private String id;

    /**
     * 学院名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 学院简称
     */
    @TableField("SHORT_NAME")
    private String shortName;

    /**
     * 学院介绍
     */
    @TableField("INTRO")
    private String intro;

    /**
     * 专业个数
     */
    @TableField("PROFESSION_NUMBER")
    private Integer professionNumber;

    /**
     * 学生人数
     */
    @TableField("STUDENT_NUMBER")
    private Integer studentNumber;

    /**
     * 院长
     */
    @TableField("PRESIDENT")
    private String president;

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
