package com.wty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "instruct")
public class Instruct {
    /**
     * 课程号
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 任课老师
     */
    @Column(name = "TEACHER_ID")
    private String teacherId;

    /**
     * 任课班级
     */
    @Column(name = "CLASS_ID")
    private String classId;

    /**
     * 教授课程
     */
    @Column(name = "LESSON_ID")
    private String lessonId;

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
     * 获取课程号
     *
     * @return ID - 课程号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置课程号
     *
     * @param id 课程号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取任课老师
     *
     * @return TEACHER_ID - 任课老师
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置任课老师
     *
     * @param teacherId 任课老师
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    /**
     * 获取任课班级
     *
     * @return CLASS_ID - 任课班级
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置任课班级
     *
     * @param classId 任课班级
     */
    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    /**
     * 获取教授课程
     *
     * @return LESSON_ID - 教授课程
     */
    public String getLessonId() {
        return lessonId;
    }

    /**
     * 设置教授课程
     *
     * @param lessonId 教授课程
     */
    public void setLessonId(String lessonId) {
        this.lessonId = lessonId == null ? null : lessonId.trim();
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