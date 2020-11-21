package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 班级
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所在学院
     */
    @TableField("COLLEGE_ID")
    private String collegeId;

    /**
     * 所属专业
     */
    @TableField("MAJOR_ID")
    private String majorId;

    /**
     * 班级ID
     */
    @TableId("ID")
    private String id;

    /**
     * 班级名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 班级人数
     */
    @TableField("STUDENT_NUMBER")
    private Integer studentNumber;

    /**
     * 辅导员
     */
    @TableField("ADVISER")
    private String adviser;

    /**
     * 成立时间
     */
    @TableField("ESTAB_DATE")
    private LocalDate estabDate;

    /**
     * 学习年数
     */
    @TableField("YEAR_NUMBER")
    private Integer yearNumber;

    /**
     * 版本号
     */
    @Version
    @TableField("VERSION")
    private Integer version;

    /**
     * 创建人
     */
    @TableField("CRATED_BY")
    private String cratedBy;

    /**
     * 创建时间
     */
    @TableField("CRATED_TIME")
    private LocalDateTime cratedTime;

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
