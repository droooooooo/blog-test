CREATE TABLE article(
  id INT(10) PRIMARY KEY AUTO_INCREMENT,
  article_name VARCHAR(20) NOT NULL COMMENT '文章标题',
  article_content TEXT  COMMENT '文章内容',
  article_author VARCHAR(10) DEFAULT ""  COMMENT '文章作者',
  article_description VARCHAR(20) DEFAULT ""  COMMENT '文章描述',
  article_pv INT(10) DEFAULT 0  COMMENT '浏览量',
  article_type INT (4) DEFAULT 0 COMMENT '文章类型0作者，1其他人,默认作者',
  category_id INT(10) NOT NULL COMMENT '分类id',
  status INT (4) DEFAULT 1 COMMENT '文章状态0停用，1启用，默认启用',
  create_time TIMESTAMP NULL COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  flag INT (4) DEFAULT 0 COMMENT ''
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT '文章表'