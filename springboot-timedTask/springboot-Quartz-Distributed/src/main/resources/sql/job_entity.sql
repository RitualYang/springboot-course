SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `job_entity`;
CREATE TABLE `job_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'job名称',
  `job_group` varchar(255) DEFAULT NULL COMMENT 'job组名',
  `job_cron` varchar(255) DEFAULT NULL COMMENT '执行的cron',
  `parameter` varchar(255) NOT NULL COMMENT 'job的参数',
  `description` varchar(255) DEFAULT NULL COMMENT 'job描述信息',
  `vm_param` varchar(255) DEFAULT NULL COMMENT 'vm参数',
  `jar_path` varchar(255) DEFAULT NULL COMMENT 'job的jar路径',
  `status` varchar(255) DEFAULT NULL COMMENT 'job的执行状态,open运行,false暂停',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;