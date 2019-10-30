/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : share_web

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-30 19:11:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_station
-- ----------------------------
DROP TABLE IF EXISTS `article_station`;
CREATE TABLE `article_station` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `article_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `article_admire` int(10) DEFAULT NULL COMMENT '文章被赞数',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章用户名',
  `article_oppose` int(10) DEFAULT NULL COMMENT '文章反对数',
  `article_brose` int(10) DEFAULT NULL COMMENT '文章浏览次数',
  `article_publish_time` datetime NOT NULL COMMENT '文章发表时间',
  `article_id_edit` int(32) DEFAULT NULL COMMENT '记录编辑文章的id',
  `article_edit_time` datetime DEFAULT NULL COMMENT '记录编辑时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_name_title_time` (`user_name`(10),`article_title`(10),`article_publish_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of article_station
-- ----------------------------
INSERT INTO `article_station` VALUES ('1', '123123', '123123', '1', '11111', '1', '1', '2019-10-29 18:01:55', null, null);

-- ----------------------------
-- Table structure for group_members_station
-- ----------------------------
DROP TABLE IF EXISTS `group_members_station`;
CREATE TABLE `group_members_station` (
  `id` bigint(32) NOT NULL COMMENT '自增id',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `users_group_id` bigint(32) NOT NULL COMMENT '用户所在群id',
  `group_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为群管理员',
  PRIMARY KEY (`id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of group_members_station
-- ----------------------------

-- ----------------------------
-- Table structure for users_groups_station
-- ----------------------------
DROP TABLE IF EXISTS `users_groups_station`;
CREATE TABLE `users_groups_station` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `group_name` varchar(32) NOT NULL COMMENT '群名称',
  `group_create_user_name` varchar(32) NOT NULL COMMENT '群创建者用户名',
  `group_members_station_id` bigint(32) NOT NULL COMMENT '群成员数据库表id',
  `group_file_message_id` bigint(32) DEFAULT NULL COMMENT '群共享文件或消息的id值',
  `group_create_time` datetime NOT NULL COMMENT '群创建时间',
  PRIMARY KEY (`id`),
  KEY `name_group` (`group_name`(10),`group_create_user_name`(10)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_groups_station
-- ----------------------------

-- ----------------------------
-- Table structure for users_station
-- ----------------------------
DROP TABLE IF EXISTS `users_station`;
CREATE TABLE `users_station` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_role` enum('ADMIN','COMMON','GUEST') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'GUEST' COMMENT '用户角色',
  `user_login_time` datetime NOT NULL COMMENT '用户登录时间',
  `user_regist_time` datetime NOT NULL COMMENT '用户注册时间',
  `user_status` enum('NORMAL','FORBIDDEN') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态',
  `user_forbidden_time` datetime DEFAULT NULL COMMENT '用户禁言时间',
  `user_money` decimal(10,2) DEFAULT NULL COMMENT '用户充值的金额',
  `user_vip_lost_time` datetime DEFAULT NULL COMMENT '用户失去VIP资格的时间',
  `user_vip_init_time` datetime DEFAULT NULL COMMENT '用户获得VIP资格的时间',
  `user_vip_valid` tinyint(1) DEFAULT '0' COMMENT '用户是否为VIP',
  `user_phone_number` int(11) DEFAULT NULL COMMENT '用户手机号码',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱地址',
  `user_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户所在地地址',
  `user_points` int(8) DEFAULT NULL COMMENT '用户在系统内的积分',
  `user_password_question` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '找回密码时用户设置的问题',
  `user_password_answer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '找回密码时用户设置的问题答案',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `name` (`user_name`(10),`user_status`,`user_phone_number`,`user_email`) USING BTREE COMMENT '用户名索引'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users_station
-- ----------------------------
INSERT INTO `users_station` VALUES ('1', '11111', '	b0baee9d279d34fa1dfd71aadb908c3f', 'ADMIN', '2019-10-28 13:07:18', '2019-09-30 19:50:35', 'NORMAL', null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `users_station` VALUES ('2', 'yiranqingqing', '6a204bd89f3c8348afd5c77c717a097a', 'COMMON', '2019-10-03 10:08:31', '2019-10-03 10:08:36', 'NORMAL', null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `users_station` VALUES ('3', '22222', '3d2172418ce305c7d16d4b05597c6a59', 'COMMON', '2019-10-21 13:07:42', '2019-10-21 13:07:42', 'NORMAL', null, null, null, null, '0', null, null, null, null, null, null);

SET FOREIGN_KEY_CHECKS = 1;