package com.naixwf.article;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangfei on 14-10-30.
 * 文章保密级别，匹配用户的浏览权限以决定文章是否可见
 * TODO
 */
public class SecretLevel {
	//公开
	public static final int PUBLIC = 0;
	//内部人员可看
	public static final int INNER = 100;
	//只有高级内部人员可以看
	public static final int SECRET = 200;

	/**
	 * 文章安全等级 key->value
	 * @return
	 */
	public static Map<String, String> getSecretLevelMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(String.valueOf(PUBLIC), "公开");
		map.put(String.valueOf(INNER), "内部资料");
		map.put(String.valueOf(SECRET), "保密");
		return map;
	}
}
