package com.wty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 专业
 * </p>
 *
 * @author wty
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业ID
     */
    @TableId("ID")
    private String id;

    /**
     * 专业名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 专业简称
     */
    @TableField("SHORT_NAME")
    private String shortName;

    /**
     * 开设时间
     */
    @TableField("ESTAB_DATE")
    private LocalDate estabDate;

    /**
     * 专业介绍
     */
    @TableField("INTRO")
    private String intro;

    /**
     * 学费
     */
    @TableField("TUITION_FEE")
    private String tuitionFee;

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
