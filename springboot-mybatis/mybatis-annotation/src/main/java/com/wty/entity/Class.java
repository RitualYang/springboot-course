package com.wty.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Class {
    /**
     * 班级ID
     *
     * @Id 注解使用：该数据库属性为int 或long类型,并设置主键自增才能使用
     * 如果不是。需要设置  mybatis.configuration.use-generated-keys=false
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 所在学院
     */
    @Column(name = "COLLEGE_ID")
    private String collegeId;

    /**
     * 所属专业
     */
    @Column(name = "MAJOR_ID")
    private String majorId;

    /**
     * 班级名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 班级人数
     */
    @Column(name = "STUDENT_NUMBER")
    private Integer studentNumber;

    /**
     * 辅导员
     */
    @Column(name = "ADVISER")
    private String adviser;

    /**
     * 成立时间
     */
    @Column(name = "ESTAB_DATE")
    private Date estabDate;

    /**
     * 学习年数
     */
    @Column(name = "YEAR_NUMBER")
    private Integer yearNumber;

    /**
     * 版本号
     */
    @Column(name = "VERSION")
    private Integer version;

    /**
     * 创建人
     */
    @Column(name = "CRATED_BY")
    private String cratedBy;

    /**
     * 创建时间
     */
    @Column(name = "CRATED_TIME")
    private Date cratedTime;

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
     * 获取班级ID
     *
     * @return ID - 班级ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置班级ID
     *
     * @param id 班级ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取所在学院
     *
     * @return COLLEGE_ID - 所在学院
     */
    public String getCollegeId() {
        return collegeId;
    }

    /**
     * 设置所在学院
     *
     * @param collegeId 所在学院
     */
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    /**
     * 获取所属专业
     *
     * @return MAJOR_ID - 所属专业
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 设置所属专业
     *
     * @param majorId 所属专业
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    /**
     * 获取班级名称
     *
     * @return NAME - 班级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置班级名称
     *
     * @param name 班级名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取班级人数
     *
     * @return STUDENT_NUMBER - 班级人数
     */
    public Integer getStudentNumber() {
        return studentNumber;
    }

    /**
     * 设置班级人数
     *
     * @param studentNumber 班级人数
     */
    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * 获取辅导员
     *
     * @return ADVISER - 辅导员
     */
    public String getAdviser() {
        return adviser;
    }

    /**
     * 设置辅导员
     *
     * @param adviser 辅导员
     */
    public void setAdviser(String adviser) {
        this.adviser = adviser == null ? null : adviser.trim();
    }

    /**
     * 获取成立时间
     *
     * @return ESTAB_DATE - 成立时间
     */
    public Date getEstabDate() {
        return estabDate;
    }

    /**
     * 设置成立时间
     *
     * @param estabDate 成立时间
     */
    public void setEstabDate(Date estabDate) {
        this.estabDate = estabDate;
    }

    /**
     * 获取学习年数
     *
     * @return YEAR_NUMBER - 学习年数
     */
    public Integer getYearNumber() {
        return yearNumber;
    }

    /**
     * 设置学习年数
     *
     * @param yearNumber 学习年数
     */
    public void setYearNumber(Integer yearNumber) {
        this.yearNumber = yearNumber;
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
     * @return CRATED_BY - 创建人
     */
    public String getCratedBy() {
        return cratedBy;
    }

    /**
     * 设置创建人
     *
     * @param cratedBy 创建人
     */
    public void setCratedBy(String cratedBy) {
        this.cratedBy = cratedBy == null ? null : cratedBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CRATED_TIME - 创建时间
     */
    public Date getCratedTime() {
        return cratedTime;
    }

    /**
     * 设置创建时间
     *
     * @param cratedTime 创建时间
     */
    public void setCratedTime(Date cratedTime) {
        this.cratedTime = cratedTime;
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

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", majorId='" + majorId + '\'' +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", adviser='" + adviser + '\'' +
                ", estabDate=" + estabDate +
                ", yearNumber=" + yearNumber +
                ", version=" + version +
                ", cratedBy='" + cratedBy + '\'' +
                ", cratedTime=" + cratedTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}