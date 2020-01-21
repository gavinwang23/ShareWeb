/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 123.57.52.18:3306
 Source Schema         : share_web

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/01/2020 18:03:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_collection_station
-- ----------------------------
DROP TABLE IF EXISTS `article_collection_station`;
CREATE TABLE `article_collection_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `collection_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文集名称',
  `article_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章名称',
  `article_id` bigint DEFAULT NULL COMMENT '文章id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改更新时间',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文集简要说明',
  `collection_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文集类型',
  `public_or_not` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否公开',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `article_collection` (`user_name`(10),`collection_name`(10),`article_name`(10),`create_time`,`collection_type`,`public_or_not`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of article_collection_station
-- ----------------------------
BEGIN;
INSERT INTO `article_collection_station` VALUES (1, '11111', 11111, 'ahaha', 'xixixi', 2, '2019-11-26 17:53:36', '2019-11-26 17:53:42', NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (2, '11111', 11111, 'fafafa', 'gagaga', 3, '2019-11-27 15:50:17', '2019-11-27 15:50:21', NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (3, '11111', 1, 'gaga', 'gaga', NULL, '2019-11-27 08:12:23', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (4, '11111', 1, 'gaga', '12313', NULL, '2019-11-27 08:12:24', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (5, '11111', 1, 'gaga', '12313', NULL, '2019-12-08 09:16:48', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (6, '11111', 1, 'gaga', '231', NULL, '2019-12-08 09:17:10', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (7, '11111', 1, 'gagax', 'xixixix', NULL, '2019-12-08 09:18:30', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (8, '11111', 1, 'gaga', 'xixixi', NULL, '2019-12-08 09:22:25', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (9, '11111', 1, 'gaga', 'gagagagaga', NULL, '2019-12-08 09:23:44', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (10, '11111', 1, 'gagax哈哈', 'xixixix嘎嘎', NULL, '2019-12-23 07:43:27', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (11, '11111', 1, '第1次web测试', 'xixixix嘎嘎', NULL, '2019-12-23 07:49:59', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (12, '11111', 1, '第1次web测试', 'xixixix嘎嘎', NULL, '2019-12-25 07:47:43', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (13, '11111', 1, '第1次web测试', NULL, NULL, '2019-12-25 08:27:26', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (14, '11111', 1, '1111', '', NULL, '2019-12-25 10:48:27', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (15, '11111', 1, '111111', '', NULL, '2019-12-25 10:48:28', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (16, '11111', 1, '1111', '', NULL, '2019-12-25 10:48:28', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (17, '11111', 1, 'qqq', '', NULL, '2019-12-25 10:49:35', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (18, '11111', 1, '第1次web测试', NULL, NULL, '2019-12-25 10:51:25', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (19, '11111', 1, '1111', '', NULL, '2019-12-25 10:51:43', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (20, '11111', 1, '1111', '', NULL, '2019-12-25 10:52:03', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (21, '11111', 1, 'a', '', NULL, '2019-12-25 10:52:35', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (22, '11111', 1, 'a', '', NULL, '2019-12-25 10:52:36', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (23, '11111', 1, 'a', '', NULL, '2019-12-25 10:52:36', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (24, '11111', 1, 'q', '', NULL, '2019-12-25 10:52:43', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (25, '11111', 1, 'q', '', NULL, '2019-12-25 10:54:48', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (26, '11111', 1, 'q', '', NULL, '2019-12-25 10:55:47', NULL, NULL, NULL, 1);
INSERT INTO `article_collection_station` VALUES (27, '11111', 1, '1111', '', NULL, '2019-12-25 11:04:35', NULL, NULL, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for article_station
-- ----------------------------
DROP TABLE IF EXISTS `article_station`;
CREATE TABLE `article_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `article_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `article_admire` int DEFAULT NULL COMMENT '文章被赞数',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章用户名',
  `article_oppose` int DEFAULT NULL COMMENT '文章反对数',
  `article_brose` int DEFAULT NULL COMMENT '文章浏览次数',
  `article_publish_time` datetime NOT NULL COMMENT '文章发表时间',
  `article_id_edit` int DEFAULT NULL COMMENT '记录编辑文章的id',
  `article_edit_time` datetime DEFAULT NULL COMMENT '记录编辑时间',
  `can_be_reprint` tinyint(1) NOT NULL DEFAULT '1' COMMENT '能否被转载',
  `reprint_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '转载出处的用户名',
  `reprint_link` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '转载出版的网址',
  `article_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章类型',
  `article_or_comment` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为评论',
  `targeted_id` bigint DEFAULT NULL COMMENT '评论目标id',
  `targeted_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论目标用户名',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_name_title_time` (`user_name`(10),`article_title`(10),`article_publish_time`,`article_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2316 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of article_station
-- ----------------------------
BEGIN;
INSERT INTO `article_station` VALUES (1, '123123', '<h3>很久很久以前</h3> <p>有个补碗匠叫赵光义。赵光义是补碗匠中的高手。</p> <img src=\"https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=ac04969241a98226accc2375ebebd264/cb8065380cd79123d01d8093af345982b3b78053.jpg\"><p>这天，赵光义挑着工具担子，刚走进一条胡同，便被一个人拽进一处院子里。这个人叫王直，他...</p>', 1, '11111', 1, 1, '2019-10-29 18:01:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2, '666', '666', 6, '11111', 1, 1, '2019-12-09 16:32:04', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (3, '444', '422', 333, '2323', 2325, 555, '2019-12-09 16:34:04', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (6, '222', '232', 22323, '2323', 23132, 2321, '2019-12-09 16:32:34', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (8, '888', '888', 888, '888', 88, 88, '2019-12-09 16:35:09', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (26, '12313', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (29, '12313', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (44, '55', '444', 44, '44', 44, 44, '2019-12-09 16:36:15', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (54, '12313', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (63, '12313', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (77, '231', '1231', 444, '11111', 44, 44, '2019-12-09 16:33:35', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (95, '22', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (96, '34', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (99, '45', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (134, '56', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (230, '90', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (231, '3782', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (263, '15623', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (296, '9845', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (297, '4982', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (299, '134', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (534, '854', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (954, '9605', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (996, '3279', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (1883, '695', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (1884, '6124', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2230, '56743', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2263, '19823', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2310, '09653', '21313', 123213, '2132', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2313, '384', '11111', 123213, '11111', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `article_station` VALUES (2315, 'gaga', '这个是评论', 123213, '11111', 231, 23132, '2019-12-09 16:32:55', NULL, NULL, 1, NULL, NULL, NULL, 1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for fans_station
-- ----------------------------
DROP TABLE IF EXISTS `fans_station`;
CREATE TABLE `fans_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '处增id',
  `followed_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被关注的用户名',
  `followed_user_id` bigint DEFAULT NULL COMMENT '被关注的用户id',
  `fans_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '粉丝用户名',
  `fans_user_id` bigint NOT NULL COMMENT '粉丝用户id',
  `create_time` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`followed_user_id`,`fans_user_id`,`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for favorite_articles_station
-- ----------------------------
DROP TABLE IF EXISTS `favorite_articles_station`;
CREATE TABLE `favorite_articles_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `author_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者名',
  `article_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of favorite_articles_station
-- ----------------------------
BEGIN;
INSERT INTO `favorite_articles_station` VALUES (1, '11111', '11111', '大大大');
INSERT INTO `favorite_articles_station` VALUES (2, '11111', '222', '嘻嘻嘻');
INSERT INTO `favorite_articles_station` VALUES (3, '11111', 'xixixi', 'dsadad');
INSERT INTO `favorite_articles_station` VALUES (4, '1234', 'fghdhd', 'fgfdgdgd');
COMMIT;

-- ----------------------------
-- Table structure for group_members_station
-- ----------------------------
DROP TABLE IF EXISTS `group_members_station`;
CREATE TABLE `group_members_station` (
  `id` bigint NOT NULL COMMENT '自增id',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `users_group_id` bigint NOT NULL COMMENT '用户所在群id',
  `group_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为群管理员',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for index_information_station
-- ----------------------------
DROP TABLE IF EXISTS `index_information_station`;
CREATE TABLE `index_information_station` (
  `id` bigint NOT NULL COMMENT '自增id',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `index_article_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首页文章名称',
  `index_picture_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首页图片地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` enum('EN','DIS') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `index_article_id` bigint DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `common_index` (`user_name`,`index_article_name`,`state`) USING BTREE COMMENT '普通索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for interactive_station
-- ----------------------------
DROP TABLE IF EXISTS `interactive_station`;
CREATE TABLE `interactive_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `article_id` bigint NOT NULL COMMENT '文章id',
  `article_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章名称',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作用户名',
  `interactive_type` int NOT NULL COMMENT '互动类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for users_groups_station
-- ----------------------------
DROP TABLE IF EXISTS `users_groups_station`;
CREATE TABLE `users_groups_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `group_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群名称',
  `group_create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群创建者用户名',
  `group_members_station_id` bigint NOT NULL COMMENT '群成员数据库表id',
  `group_file_message_id` bigint DEFAULT NULL COMMENT '群共享文件或消息的id值',
  `group_create_time` datetime NOT NULL COMMENT '群创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `name_group` (`group_name`(10),`group_create_user_name`(10)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for users_station
-- ----------------------------
DROP TABLE IF EXISTS `users_station`;
CREATE TABLE `users_station` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
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
  `user_phone_number` int DEFAULT NULL COMMENT '用户手机号码',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱地址',
  `user_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户所在地地址',
  `user_points` int DEFAULT NULL COMMENT '用户在系统内的积分',
  `user_password_question` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '找回密码时用户设置的问题',
  `user_password_answer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '找回密码时用户设置的问题答案',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `name` (`user_name`(10),`user_status`,`user_phone_number`,`user_email`) USING BTREE COMMENT '用户名索引'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users_station
-- ----------------------------
BEGIN;
INSERT INTO `users_station` VALUES (1, '11111', '	b0baee9d279d34fa1dfd71aadb908c3f', 'ADMIN', '2020-01-18 10:25:47', '2019-09-30 19:50:35', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users_station` VALUES (2, 'yiranqingqing', '6a204bd89f3c8348afd5c77c717a097a', 'COMMON', '2019-10-03 10:08:31', '2019-10-03 10:08:36', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users_station` VALUES (3, '22222', '3d2172418ce305c7d16d4b05597c6a59', 'COMMON', '2019-10-21 13:07:42', '2019-10-21 13:07:42', 'NORMAL', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
