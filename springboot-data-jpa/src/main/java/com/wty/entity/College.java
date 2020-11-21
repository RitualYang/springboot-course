package com.wty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "college")
public class College {
    /**
     * 学院ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 学院名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 学院简称
     */
    @Column(name = "SHORT_NAME")
    private String shortName;

    /**
     * 学院介绍
     */
    @Column(name = "INTRO")
    private String intro;

    /**
     * 专业个数
     */
    @Column(name = "PROFESSION_NUMBER")
    private Integer professionNumber;

    /**
     * 学生人数
     */
    @Column(name = "STUDENT_NUMBER")
    private Integer studentNumber;

    /**
     * 院长
     */
    @Column(name = "PRESIDENT")
    private String president;

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
     * 获取学院ID
     *
     * @return ID - 学院ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学院ID
     *
     * @param id 学院ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取学院名称
     *
     * @return NAME - 学院名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学院名称
     *
     * @param name 学院名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取学院简称
     *
     * @return SHORT_NAME - 学院简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置学院简称
     *
     * @param shortName 学院简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取学院介绍
     *
     * @return INTRO - 学院介绍
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置学院介绍
     *
     * @param intro 学院介绍
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * 获取专业个数
     *
     * @return PROFESSION_NUMBER - 专业个数
     */
    public Integer getProfessionNumber() {
        return professionNumber;
    }

    /**
     * 设置专业个数
     *
     * @param professionNumber 专业个数
     */
    public void setProfessionNumber(Integer professionNumber) {
        this.professionNumber = professionNumber;
    }

    /**
     * 获取学生人数
     *
     * @return STUDENT_NUMBER - 学生人数
     */
    public Integer getStudentNumber() {
        return studentNumber;
    }

    /**
     * 设置学生人数
     *
     * @param studentNumber 学生人数
     */
    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * 获取院长
     *
     * @return PRESIDENT - 院长
     */
    public String getPresident() {
        return president;
    }

    /**
     * 设置院长
     *
     * @param president 院长
     */
    public void setPresident(String president) {
        this.president = president == null ? null : president.trim();
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