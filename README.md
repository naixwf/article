# Article(文档管理工具)设计说明

## 题目

设计一个Web版本的在线文档管理系统```(Java)```   
要求如下：   

1. 实现文档管理功能（增删改）
2. 文档的分类管理和浏览
3. 前台页面文档的查看
4. 查看权限的管理

## 成品测试地址

Article未做浏览器兼容，只在Chrome for mac(38.0.2125.111)下测试通过。

测试地址：http://test.wangfeing.cn   
测试账号：

* 初级用户 junior/junior	
* 高级用户 senior/senior	
* 管理员 admin/admin


## 设计思路
整个系统的主业务，需要涉及的实体有：

* 文档（article）
* 文档类别(category)
* 用户(user)
* 用户权限(authority)

Article要做的，主要是对上述四类实体的操作。
本着功能上尽量简约的原则，这部分主要需要实现以下功能点以满足题目要求。



### 文档管理

需要满足如下需求：

1. 对【文档】进行增删改查
2. 对【文档类别】进行增删改查
3. 按【文档类别】查看【文档】


### 文档查看

为了达到```【易读易写】```的目的，Article使用[Markdown](http://wowubuntu.com/markdown/index.html)作为书写标准。

为什么选择markdown?   

* 我可以选用纯文本，极易书写，但是【极难阅读】（因为在网页上纯文本会挤到一起，排版会变的很糟）
* 我可以选用HTML，可以写出很好的排版效果，但是对普通用户来说【极难书写】

于是，我选择了markdown，写起来不那么费劲，读起来却很流畅。



### 权限管理

Article的用户分为【游客】和【注册用户】，其中注册用户有三种角色：初级账号、高级账号、管理员

Article以如下策略管理【文档查看权限】：
Article知道用户甲的【安全级别】a ,以及他想查看的文档X的【安全级别】b。
只有a>=b时，甲可以查看X文档。

具体实现策略如下：

* 文章分三种【安全级别】：公开、内部资料、保密（安全级别分别为0、100、200）
* 游客（安全级别0）只可以看公开的文档
* 初级账号（安全级别100）可以看公开、内部资料文档
* 高级账号（安全级别200）可以看所有文档
* 只有管理员（999）可以增、删、改文档

## 技术实现

* 【IoC container】spring-boot : 极大提升j2ee应用的开发速度 
* 【MVC】spring-mvc : 老牌mvc框架
* 【DAO】mybatis : 配合mybatis-generator使用，单表操作很方便
* 【security】spring-security : 直接使用spring-security做权限控制
* 【decoritor】sitemesh3 : 统一页面装饰,不用sitemesh2纯属是为了尝鲜。配置确实比2简单一些。
* 【tags】freemarker : 最大的好处是可以自定义宏
* 【markdown】markdown4j : markdown的一个老牌java实现
* 【FE】bootstrap3 + jquery ，使用bower管理前端依赖


