# Host: localhost  (Version 5.7.27-log)
# Date: 2019-11-04 15:57:15
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "permission"
#

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(50) DEFAULT NULL COMMENT '权限描述表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限表';

#
# Data for table "permission"
#

INSERT INTO `permission` VALUES (1,'add',''),(6,'delete',''),(7,'get',''),(8,'admin','');

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(50) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'admin',''),(2,'user','');

#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  KEY `role_premission_uid_fk` (`role_id`) USING BTREE,
  KEY `role_premission_pid_fk` (`permission_id`) USING BTREE,
  CONSTRAINT `role_premission_pid_fk` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `role_premission_uid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` VALUES (1,1),(1,6),(1,7),(1,8),(2,1),(2,7);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'zsf','123'),(2,'aa','aa'),(3,'root','root');

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `user_role_uid_fk` (`user_id`) USING BTREE,
  KEY `user_role_rid_fk` (`role_id`) USING BTREE,
  CONSTRAINT `user_role_rid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_uid_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2);
