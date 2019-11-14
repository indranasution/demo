/*
 Navicat Premium Data Transfer

 Source Server         : kyc-dbs
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : db_home

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/11/2019 00:32:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (1);
INSERT INTO `hibernate_sequence` VALUES (1);
COMMIT;

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_properties` json DEFAULT NULL,
  `user_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
BEGIN;
INSERT INTO `user_menu` VALUES (1, 12, '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 2}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 3}, {\"moduleName\": \"HistoryCard\", \"moduleOrder\": 4}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 5}]', 'UserA');
INSERT INTO `user_menu` VALUES (2, 17, '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 2}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 3}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 4}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 5}]', 'UserB');
INSERT INTO `user_menu` VALUES (3, 42, '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 2}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 3}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 4}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 5}]', NULL);
COMMIT;

-- ----------------------------
-- Table structure for users_group
-- ----------------------------
DROP TABLE IF EXISTS `users_group`;
CREATE TABLE `users_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_type_properties` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of users_group
-- ----------------------------
BEGIN;
INSERT INTO `users_group` VALUES (1, 'UserA', '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 2}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 3}, {\"moduleName\": \"HistoryCard\", \"moduleOrder\": 4}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 5}]');
INSERT INTO `users_group` VALUES (2, 'UserB', '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 2}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 3}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 4}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 5}]');
INSERT INTO `users_group` VALUES (3, 'UserC', '[{\"moduleName\": \"PromoCard\", \"moduleOrder\": 1}, {\"moduleName\": \"FlashSaleCard\", \"moduleOrder\": 2}, {\"moduleName\": \"CategoryCard\", \"moduleOrder\": 3}, {\"moduleName\": \"NewsCard\", \"moduleOrder\": 4}, {\"moduleName\": \"HistoryCard\", \"moduleOrder\": 5}]');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
