-- 建库
CREATE DATABASE IF NOT EXISTS `article` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE article;

DROP TABLE IF EXISTS `user`;
create table `user`(
 id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
 username varchar(64) not null COMMENT '用户名',
 password varchar(255) not null COMMENT '密码，暂时存明文',
 role_id int(11) not null default 1 COMMENT '角色id，refer role.id',
 is_admin tinyint(1) not null default 0 COMMENT '是否是管理员，管理员可以管理文章'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


DROP TABLE IF EXISTS `role`;
create table `role`(
 id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
 role_name varchar(64) not null COMMENT '用户名',
 secret_level int(11) not null COMMENT '保密级别，与article.secret_level有业务联系'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


DROP TABLE IF EXISTS `article`;
create table `article`(
  id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
  title varchar(255) not null COMMENT '标题，不能超过255',
  content text not null COMMENT '内容',
  category_id int(11) not null COMMENT '文章分类',
  secret_level int(11) not null default 0 COMMENT '文章保密级别, 与role.secret_level有业务联系',
  creator_id int(11) not null COMMENT '创建者id，refer user.id',
  create_time datetime not null COMMENT '创建时间',
  modifier_id int(11) not null COMMENT '最后修改人id,refer user.id',
  modify_time datetime not null COMMENT '最后修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

DROP TABLE IF EXISTS `category`;
create table `category`(
 id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
 categroy_name varchar(64) not null COMMENT '类别名称'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章类别表';