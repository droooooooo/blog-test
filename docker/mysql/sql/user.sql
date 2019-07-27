CREATE TABLE user(
  id INT(10) PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(20) NOT NULL COMMENT '用户名',
  user_password VARCHAR(20) NOT NULL COMMENT '密码',
  user_nikename VARCHAR(20) DEFAULT '' COMMENT '昵称',
  user_telephone VARCHAR (20) DEFAULT '' COMMENT '手机号码',
  user_type INT(4)  DEFAULT 1 COMMENT '用户类型 0管理员,1用户',
  status INT (4)  DEFAULT 1 COMMENT '用户状态0停用，1启用，默认启用',
  create_time TIMESTAMP NULL COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  flag INT (4) DEFAULT 0 COMMENT '',
   UNIQUE KEY `user_name`(`user_name`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

-- INSERT INTO test.user (username,PASSWORD,nikename,phone,create_time) VALUES ('小明','123','小霸王','13333333333',CURRENT_TIMESTAMP());