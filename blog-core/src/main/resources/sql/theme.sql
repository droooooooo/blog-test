CREATE TABLE theme(
  id INT(10) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL COMMENT '名称',
  color VARCHAR(10) NOT NULL COMMENT '值',
  type INT (4) DEFAULT 0 COMMENT '类型',
  status INT (4) DEFAULT 0 COMMENT '状态0停用，1启用，默认启用',
  create_time TIMESTAMP NULL COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  flag INT (4) DEFAULT 0 COMMENT ''
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT '皮肤表'

-- INSERT INTO theme (NAME,color,create_time) VALUES('red','#ff5b57',NOW())
-- INSERT INTO theme (NAME,color,create_time) VALUES('blue','#348fe2',NOW())
-- INSERT INTO theme (NAME,color,create_time) VALUES('purple','#727cb6',NOW())
-- INSERT INTO theme (NAME,color,create_time) VALUES('orange','#f59c1a',NOW())
-- INSERT INTO theme (NAME,color,create_time) VALUES('black','#2d353c',NOW())