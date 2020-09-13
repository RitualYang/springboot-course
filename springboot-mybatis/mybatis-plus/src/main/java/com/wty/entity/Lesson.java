package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程号
     */
    @TableId("ID")
    private String id;

    /**
     * 课程名
     */
    @TableField("NAME")
    private String name;

    /**
     * 课程说明
     */
    @TableField("INTRO")
    private String intro;

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
