-- 建库
CREATE DATABASE IF NOT EXISTS `article` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE article;

-- DROP TABLE IF EXISTS `user`;
-- create table `user`(
--  id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
--  username varchar(64) not null COMMENT '用户名',
--  password varchar(255) not null COMMENT '密码，暂时存明文',
--  role_id int(11) not null default 1 COMMENT '角色id，refer role.id',
--  is_admin tinyint(1) not null default 0 COMMENT '是否是管理员，管理员可以管理文章'
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


-- DROP TABLE IF EXISTS `role`;
-- create table `role`(
--  id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
--  role_name varchar(64) not null COMMENT '用户名',
--  secret_level int(11) not null COMMENT '保密级别，与article.secret_level有业务联系'
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


DROP TABLE IF EXISTS `article`;
create table `article`(
  id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
  title varchar(255) not null COMMENT '标题，不能超过255',
  content text not null COMMENT '内容',
  content_html text not null COMMENT '转换成html后的内容',
  category_id int(11) not null COMMENT '文章分类',
  secret_level int(11) not null default 0 COMMENT '文章保密级别',
  creator_id varchar(256) not null COMMENT '创建者id，refer username',
  create_time datetime not null COMMENT '创建时间',
  modifier_id varchar(256) not null COMMENT '最后修改人id,refer username',
  modify_time datetime not null COMMENT '最后修改时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

DROP TABLE IF EXISTS `category`;
create table `category`(
 id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
 categroy_name varchar(64) not null COMMENT '类别名称'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章类别表';

insert into category select 1,'开发';
insert into category select 2,'运维';
insert into category select 3,'软件工程';


DROP TABLE IF EXISTS `users`;
create table users (
  id int(11) not null AUTO_INCREMENT primary key COMMENT '自增主键',
  username varchar(256) not null,
  password varchar(256) not null,
  enabled boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='spring security users';

DROP TABLE IF EXISTS `authorities`;
create table authorities (
  username  varchar(256) not null primary key,
  authority varchar(256) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='spring security authorities';



insert into users (id,username, password, enabled) values (1,'admin', 'admin', true);
insert into users (id,username, password, enabled) values (2,'junior', 'junior', true);
insert into users (id,username, password, enabled) values (3,'senior', 'senior', true);

insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('junior', 'ROLE_JUNIOR');
insert into authorities (username, authority) values ('senior', 'ROLE_SENIOR');


