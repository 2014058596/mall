use test;

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
                              `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员名',
                              `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
                              `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
                              `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 1男0女',
                              `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
                              `birthday` date NULL DEFAULT NULL COMMENT '出生日',
                              `createTime` date NULL DEFAULT NULL COMMENT '注册日期',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;




DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                                   `id` int(11) NOT NULL COMMENT '主键',
                                   `user_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
                                   `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info`  (
                                  `id` int(11) NOT NULL COMMENT '权限id',
                                  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法类型',
                                  `zuul_prefix` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网关前缀',
                                  `service_prefix` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务前缀',
                                  `uri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
                                  `createTime` date NULL DEFAULT NULL COMMENT '创建日期',
                                  `updateTime` date NULL DEFAULT NULL COMMENT '更新日期',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
                            `id` int(11) NOT NULL COMMENT '角色id',
                            `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
                            `valid` tinyint(1) NULL DEFAULT NULL COMMENT '是否有效 1是 0否',
                            `createTime` date NULL DEFAULT NULL COMMENT '创建日期',
                            `updateTime` date NULL DEFAULT NULL COMMENT '更新日期',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
                                       `id` int(11) NOT NULL COMMENT '主键',
                                       `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
                                       `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


role_permission
role_info
permission_info
user_role
user_info