package com.wty.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Student {
    /**
     * 学号
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
     * 所在班级
     */
    @Column(name = "CLASS_ID")
    private String classId;

    /**
     * 学生姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 身份证号
     */
    @Column(name = "ID_CARD_NO")
    private String idCardNo;

    /**
     * 英文名
     */
    @Column(name = "ENG_NAME")
    private String engName;

    /**
     * 手机号
     */
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    /**
     * 性别
     */
    @Column(name = "GENDER")
    private String gender;

    /**
     * 出生日期
     */
    @Column(name = "BIRTH")
    private Date birth;

    /**
     * 头像
     */
    @Column(name = "AVATAR")
    private String avatar;

    /**
     * 身高
     */
    @Column(name = "HEIGHT")
    private BigDecimal height;

    /**
     * 体重
     */
    @Column(name = "WEIGHT")
    private BigDecimal weight;

    /**
     * 名族
     */
    @Column(name = "NATION")
    private String nation;

    /**
     * 政治面貌
     */
    @Column(name = "POLITICAL")
    private String political;

    /**
     * 婚姻状况
     */
    @Column(name = "MARITAL")
    private String marital;

    /**
     * 籍贯（省） 国标行政区域代码-省级
     */
    @Column(name = "DOMICILE_PLACE_PROVINCE")
    private String domicilePlaceProvince;

    /**
     * 籍贯（市） 国标行政区域代码-市级
     */
    @Column(name = "DOMICILE_PLACE_CITY")
    private String domicilePlaceCity;

    /**
     * 户籍地址
     */
    @Column(name = "DOMICILE_PLACE_ADDRESS")
    private String domicilePlaceAddress;

    /**
     * 爱好
     */
    @Column(name = "HOBBY")
    private String hobby;

    /**
     * 简要介绍
     */
    @Column(name = "INTRO")
    private String intro;

    /**
     * 居住地址
     */
    @Column(name = "PRESENT_ADDRESS")
    private String presentAddress;

    /**
     * 电子邮件
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 入学日期
     */
    @Column(name = "ENTRY_DATE")
    private Date entryDate;

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private String status;

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
     * 获取学号
     *
     * @return ID - 学号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学号
     *
     * @param id 学号
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
     * 获取所在班级
     *
     * @return CLASS_ID - 所在班级
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置所在班级
     *
     * @param classId 所在班级
     */
    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    /**
     * 获取学生姓名
     *
     * @return NAME - 学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生姓名
     *
     * @param name 学生姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取身份证号
     *
     * @return ID_CARD_NO - 身份证号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置身份证号
     *
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    /**
     * 获取英文名
     *
     * @return ENG_NAME - 英文名
     */
    public String getEngName() {
        return engName;
    }

    /**
     * 设置英文名
     *
     * @param engName 英文名
     */
    public void setEngName(String engName) {
        this.engName = engName == null ? null : engName.trim();
    }

    /**
     * 获取手机号
     *
     * @return MOBILE_PHONE - 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机号
     *
     * @param mobilePhone 手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取性别
     *
     * @return GENDER - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取出生日期
     *
     * @return BIRTH - 出生日期
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取头像
     *
     * @return AVATAR - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取身高
     *
     * @return HEIGHT - 身高
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * 设置身高
     *
     * @param height 身高
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * 获取体重
     *
     * @return WEIGHT - 体重
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取名族
     *
     * @return NATION - 名族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置名族
     *
     * @param nation 名族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取政治面貌
     *
     * @return POLITICAL - 政治面貌
     */
    public String getPolitical() {
        return political;
    }

    /**
     * 设置政治面貌
     *
     * @param political 政治面貌
     */
    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    /**
     * 获取婚姻状况
     *
     * @return MARITAL - 婚姻状况
     */
    public String getMarital() {
        return marital;
    }

    /**
     * 设置婚姻状况
     *
     * @param marital 婚姻状况
     */
    public void setMarital(String marital) {
        this.marital = marital == null ? null : marital.trim();
    }

    /**
     * 获取籍贯（省） 国标行政区域代码-省级
     *
     * @return DOMICILE_PLACE_PROVINCE - 籍贯（省） 国标行政区域代码-省级
     */
    public String getDomicilePlaceProvince() {
        return domicilePlaceProvince;
    }

    /**
     * 设置籍贯（省） 国标行政区域代码-省级
     *
     * @param domicilePlaceProvince 籍贯（省） 国标行政区域代码-省级
     */
    public void setDomicilePlaceProvince(String domicilePlaceProvince) {
        this.domicilePlaceProvince = domicilePlaceProvince == null ? null : domicilePlaceProvince.trim();
    }

    /**
     * 获取籍贯（市） 国标行政区域代码-市级
     *
     * @return DOMICILE_PLACE_CITY - 籍贯（市） 国标行政区域代码-市级
     */
    public String getDomicilePlaceCity() {
        return domicilePlaceCity;
    }

    /**
     * 设置籍贯（市） 国标行政区域代码-市级
     *
     * @param domicilePlaceCity 籍贯（市） 国标行政区域代码-市级
     */
    public void setDomicilePlaceCity(String domicilePlaceCity) {
        this.domicilePlaceCity = domicilePlaceCity == null ? null : domicilePlaceCity.trim();
    }

    /**
     * 获取户籍地址
     *
     * @return DOMICILE_PLACE_ADDRESS - 户籍地址
     */
    public String getDomicilePlaceAddress() {
        return domicilePlaceAddress;
    }

    /**
     * 设置户籍地址
     *
     * @param domicilePlaceAddress 户籍地址
     */
    public void setDomicilePlaceAddress(String domicilePlaceAddress) {
        this.domicilePlaceAddress = domicilePlaceAddress == null ? null : domicilePlaceAddress.trim();
    }

    /**
     * 获取爱好
     *
     * @return HOBBY - 爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置爱好
     *
     * @param hobby 爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    /**
     * 获取简要介绍
     *
     * @return INTRO - 简要介绍
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置简要介绍
     *
     * @param intro 简要介绍
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * 获取居住地址
     *
     * @return PRESENT_ADDRESS - 居住地址
     */
    public String getPresentAddress() {
        return presentAddress;
    }

    /**
     * 设置居住地址
     *
     * @param presentAddress 居住地址
     */
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress == null ? null : presentAddress.trim();
    }

    /**
     * 获取电子邮件
     *
     * @return EMAIL - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取入学日期
     *
     * @return ENTRY_DATE - 入学日期
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 设置入学日期
     *
     * @param entryDate 入学日期
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * 获取状态
     *
     * @return STATUS - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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