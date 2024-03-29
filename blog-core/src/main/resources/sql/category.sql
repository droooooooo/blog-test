CREATE TABLE category(
 id INT(10) PRIMARY KEY AUTO_INCREMENT,
 category_name VARCHAR(50) NOT NULL DEFAULT '' COMMENT'分类名',
 category_type INT(3) NOT NULL DEFAULT 0 COMMENT'分类类型',
 status INT (4)  DEFAULT 1 COMMENT '用户状态0停用，1启用，默认启用',
 create_time TIMESTAMP NULL COMMENT '创建时间',
 update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 flag INT (4) DEFAULT 0 COMMENT ''
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT '分类表'