/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/01/2020 23:09:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint(11) NOT NULL COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `age` bigint(20) NULL DEFAULT NULL COMMENT '年龄',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, 'root', 123, '123456');
INSERT INTO `user` VALUES (1, 'admin', 13, '777777');
INSERT INTO `user` VALUES (2, 'user', 31, '654321');
INSERT INTO `user` VALUES (3, '好人', 21, '000000');
INSERT INTO `user` VALUES (4, '着魔', 33, '111111');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户介绍',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (0, 0, '这是一位root用户', '11231237012', '11231237012@qq.com');
INSERT INTO `userinfo` VALUES (1, 1, '这是一位管理员', '213897123', '213897123@163.com');
INSERT INTO `userinfo` VALUES (2, 2, '用户介绍', '2131234', '2131234@qq.com');
INSERT INTO `userinfo` VALUES (3, 3, '是个用户', '37120392183', '37120392183@qq.com');
INSERT INTO `userinfo` VALUES (4, 4, '是个狼人', '123213123124', '123213123124@163.com');
INSERT INTO `userinfo` VALUES (5, 2, '还是这个用户的介绍', '123821731', '123821731@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
