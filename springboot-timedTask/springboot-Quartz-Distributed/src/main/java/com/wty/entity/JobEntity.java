package com.wty.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 任务实体
 * @author wty
 * @date 2020/8/24 23:13
 */
@Data
@ToString
@Entity
@Table(name = "job_entity")
public class JobEntity implements Serializable {

    private static final long serialVersionUID = 422787185246674236L;

    @Column(name = "id")
    private Long id;

    /**
     * job名称
     */
    @Column(name = "name")
    private String name;

    /**
     * job组名
     */
    @Column(name = "job_group")
    private String jobGroup;

    /**
     * 执行的cron
     */
    @Column(name = "job_cron")
    private String jobCron;

    /**
     * job的参数
     */
    @Column(name = "parameter")
    private String parameter;

    /**
     * job描述信息
     */
    @Column(name = "description")
    private String description;

    /**
     * vm参数
     */
    @Column(name = "vm_param")
    private String vmParam;

    /**
     * job的jar路径
     */
    @Column(name = "jar_path")
    private String jarPath;

    /**
     * job的执行状态,open运行,false暂停
     */
    @Column(name = "status")
    private String status;

}
