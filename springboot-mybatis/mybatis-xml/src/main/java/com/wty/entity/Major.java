package com.wty.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Major {
    /**
     * 专业ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 专业名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 专业简称
     */
    @Column(name = "SHORT_NAME")
    private String shortName;

    /**
     * 开设时间
     */
    @Column(name = "ESTAB_DATE")
    private Date estabDate;

    /**
     * 专业介绍
     */
    @Column(name = "INTRO")
    private String intro;

    /**
     * 学费
     */
    @Column(name = "TUITION_FEE")
    private String tuitionFee;

    /**
     * 版本号
     */
    @Column(name = "VERSION")
    private Integer version;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 获取专业ID
     *
     * @return ID - 专业ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置专业ID
     *
     * @param id 专业ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取专业名称
     *
     * @return NAME - 专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     *
     * @param name 专业名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取专业简称
     *
     * @return SHORT_NAME - 专业简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置专业简称
     *
     * @param shortName 专业简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取开设时间
     *
     * @return ESTAB_DATE - 开设时间
     */
    public Date getEstabDate() {
        return estabDate;
    }

    /**
     * 设置开设时间
     *
     * @param estabDate 开设时间
     */
    public void setEstabDate(Date estabDate) {
        this.estabDate = estabDate;
    }

    /**
     * 获取专业介绍
     *
     * @return INTRO - 专业介绍
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置专业介绍
     *
     * @param intro 专业介绍
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * 获取学费
     *
     * @return TUITION_FEE - 学费
     */
    public String getTuitionFee() {
        return tuitionFee;
    }

    /**
     * 设置学费
     *
     * @param tuitionFee 学费
     */
    public void setTuitionFee(String tuitionFee) {
        this.tuitionFee = tuitionFee == null ? null : tuitionFee.trim();
    }

    /**
     * 获取版本号
     *
     * @return VERSION - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_BY - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新人
     *
     * @return UPDATED_BY - 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}