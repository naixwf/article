package com.naixwf.article;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangfei on 14-11-4.
 * 角色定义
 */
public enum AuthorityDefine {
	ROLE_JUNIOR("ROLE_JUNIOR", "初级账号", 100),
	ROLE_SENIOR("ROLE_SENIOR", "高级账号", 200),
	ROLE_ADMIN("ROLE_ADMIN", "管理员", 999);

	private String roleKey;
	private String roleName;
	private int secretLevel;

	public String getRoleKey() {
		return roleKey;
	}

	public String getRoleName() {
		return roleName;
	}

	public int getSecretLevel() {
		return secretLevel;
	}

	private AuthorityDefine(String roleKey, String roleName, int secretLevel) {
		this.roleKey = roleKey;
		this.roleName = roleName;
		this.secretLevel = secretLevel;
	}

	public static Map<String, String> getMap() {
		//TODO 这里改成自适应增减

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put(ROLE_JUNIOR.getRoleKey(), ROLE_JUNIOR.getRoleName());
		map.put(ROLE_SENIOR.getRoleKey(), ROLE_SENIOR.getRoleName());
		map.put(ROLE_ADMIN.getRoleKey(), ROLE_SENIOR.getRoleName());

		return map;
	}
}
