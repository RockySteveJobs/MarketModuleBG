/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : market_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-10-23 23:05:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imageAddress` varchar(500) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES ('1', 'http://img4q.duitang.com/uploads/item/201501/10/20150110010036_FTTr4.thumb.700_0.jpeg', '1');
INSERT INTO `carousel` VALUES ('2', 'http://pic.nipic.com/2007-09-05/200795103053681_2.jpg', '2');
INSERT INTO `carousel` VALUES ('3', 'http://img.popoho.com/UploadPic/2011-8/201181114422865.jpg', '3');
INSERT INTO `carousel` VALUES ('4', 'http://pic.nipic.com/2007-09-05/200795102359197_2.jpg', '4');
INSERT INTO `carousel` VALUES ('5', 'http://www.qqya.com/userimg/8189/12110H01223.jpg', '5');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `imageAddress` varchar(500) DEFAULT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', '一件红衣服', '100.00', '1', 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477160284&di=d0b5eceb05de82ee03a1e54988dc2ab2&src=http://pic1.ooopic.com/uploadfilepic/zhengbantu/2009-12-30/OOOPIC_frutrr_200912303a56e6ee3dd0b53c.jpg', '这是一件红色的小衣服=。=');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `attentionNumber` int(11) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `QRCode` varchar(200) DEFAULT NULL,
  `signature` varchar(200) DEFAULT NULL,
  `dynamicStruts` tinyint(4) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `push_on` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '两根头发梳中分', null, '15626215416', '123456', '1', 'http://img5.imgtn.bdimg.com/it/u=1035992314,3098539105&fm=21&gp=0.jpg', null, '2016-10-23 03:41:23', null, null, null, null, null);
INSERT INTO `user` VALUES ('2', null, null, '123456', '123456', '0', null, null, '2016-10-23 20:27:27', null, null, null, null, null);

-- ----------------------------
-- Table structure for userproduct
-- ----------------------------
DROP TABLE IF EXISTS `userproduct`;
CREATE TABLE `userproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `buyTime` datetime DEFAULT NULL,
  `expirationTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userproduct
-- ----------------------------
