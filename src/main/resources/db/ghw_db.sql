SHOW DATABASES;
DROP DATABASE IF EXISTS `ghw_db`;
SELECT VERSION();
-- 创建数据库
CREATE DATABASE IF NOT EXISTS `ghw_db` DEFAULT CHARSET utf8 COLLATE utf8_general_ci ;

DROP TABLE IF EXISTS `ghw_db`.`ghw_test` ;

CREATE TABLE `ghw_db`.`ghw_test` (
  `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID,自增',
  `test_remark` VARCHAR (32) NOT NULL COMMENT '备注',
  `test_description` VARCHAR (32) DEFAULT '' COMMENT '描述',
  `is_delete` TINYINT (1) DEFAULT 0 COMMENT '删除标志,默认0,1删除',
  `add_time` TIMESTAMP  COMMENT '添加时间',
  `edit_time` TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX index_test_remark (`test_remark`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '测试表' ;