/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : share_web

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 28/10/2019 21:31:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_station
-- ----------------------------
DROP TABLE IF EXISTS `article_station`;
CREATE TABLE `article_station`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `article_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `article_admire` int(10) NULL DEFAULT NULL COMMENT '文章被赞数',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章用户名',
  `article_oppose` int(10) NULL DEFAULT NULL COMMENT '文章反对数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_station
-- ----------------------------
INSERT INTO `article_station` VALUES (1, 'tttttt', 'asdfasdf', 1, '11111', 19);

-- ----------------------------
-- Table structure for users_station
-- ----------------------------
DROP TABLE IF EXISTS `users_station`;
CREATE TABLE `users_station`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_role` enum('ADMIN','COMMON','GUEST') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'GUEST' COMMENT '用户角色',
  `user_login_time` datetime(0) NOT NULL COMMENT '用户登录时间',
  `user_regist_time` datetime(0) NOT NULL COMMENT '用户注册时间',
  `user_status` enum('NORMAL','FORBIDDEN') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态',
  `user_forbidden_time` datetime(0) NULL DEFAULT NULL COMMENT '用户禁言时间',
  `user_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '用户充值的金额',
  `user_vip_lost_time` datetime(0) NULL DEFAULT NULL COMMENT '用户失去VIP资格的时间',
  `user_vip_init_time` datetime(0) NULL DEFAULT NULL COMMENT '用户获得VIP资格的时间',
  `user_vip_valid` tinyint(1) NULL DEFAULT 0 COMMENT '用户是否为VIP',
  `user_phone_number` int(11) NULL DEFAULT NULL COMMENT '用户手机号码',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱地址',
  `user_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在地地址',
  `user_points` int(8) NULL DEFAULT NULL COMMENT '用户在系统内的积分',
  `user_password_question` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '找回密码时用户设置的问题',
  `user_password_answer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '找回密码时用户设置的问题答案',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`user_name`(10), `user_status`, `user_phone_number`, `user_email`) USING BTREE COMMENT '用户名索引'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_station
-- ----------------------------
INSERT INTO `users_station` VALUES (1, '11111', '	b0baee9d279d34fa1dfd71aadb908c3f', 'ADMIN', '2019-10-28 13:07:18', '2019-09-30 19:50:35', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users_station` VALUES (2, 'yiranqingqing', '6a204bd89f3c8348afd5c77c717a097a', 'COMMON', '2019-10-03 10:08:31', '2019-10-03 10:08:36', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users_station` VALUES (3, '22222', '3d2172418ce305c7d16d4b05597c6a59', 'COMMON', '2019-10-21 13:07:42', '2019-10-21 13:07:42', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
