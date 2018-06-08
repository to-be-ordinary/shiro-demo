/*
 Navicat Premium Data Transfer

 Source Server         : my-local-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : for_shiro

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 08/06/2018 17:46:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_permission
-- ----------------------------
DROP TABLE IF EXISTS `basic_permission`;
CREATE TABLE `basic_permission`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_permission
-- ----------------------------
INSERT INTO `basic_permission` VALUES (1, '获取当前用户', 'user:select:current');

-- ----------------------------
-- Table structure for basic_role
-- ----------------------------
DROP TABLE IF EXISTS `basic_role`;
CREATE TABLE `basic_role`  (
  `id` int(11) NOT NULL,
  `role_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_role
-- ----------------------------
INSERT INTO `basic_role` VALUES (1, 'admin', '超级管理员');

-- ----------------------------
-- Table structure for basic_user
-- ----------------------------
DROP TABLE IF EXISTS `basic_user`;
CREATE TABLE `basic_user`  (
  `id` int(11) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_user
-- ----------------------------
INSERT INTO `basic_user` VALUES (1, 'sun', 'smj', '0421023498c0c48d3d8df382f59415f3');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
