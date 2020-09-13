package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 授课
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Instruct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程号
     */
    @TableId("ID")
    private String id;

    /**
     * 任课老师
     */
    @TableField("TEACHER_ID")
    private String teacherId;

    /**
     * 任课班级
     */
    @TableField("CLASS_ID")
    private String classId;

    /**
     * 教授课程
     */
    @TableField("LESSON_ID")
    private String lessonId;

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
