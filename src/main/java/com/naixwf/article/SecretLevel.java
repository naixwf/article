package com.naixwf.article;

/**
 * Created by wangfei on 14-10-30.
 * 文章保密级别，匹配用户的浏览权限以决定文章是否可见
 * TODO
 */
public class SecretLevel {
	//公开
	private static final int PUBLIC = 0;
	//内部人员可看
	private static final int INNER = 100;
	//只有高级内部人员可以看
	private static final int SECRET = 200;
}
