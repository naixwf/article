package com.naixwf.article.define;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
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

	/**
	 * role_key->role_name
	 * @return
	 */
	public static Map<String, String> getMap() {
		//TODO 这里改成自适应增减

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put(ROLE_JUNIOR.getRoleKey(), ROLE_JUNIOR.getRoleName());
		map.put(ROLE_SENIOR.getRoleKey(), ROLE_SENIOR.getRoleName());
		map.put(ROLE_ADMIN.getRoleKey(), ROLE_ADMIN.getRoleName());

		return map;
	}

	/**
	 * role_key->role
	 * @return
	 */
	public static Map<String, AuthorityDefine> getDefineMap() {
		Map<String, AuthorityDefine> map = new LinkedHashMap<String, AuthorityDefine>();

		map.put(ROLE_JUNIOR.getRoleKey(), ROLE_JUNIOR);
		map.put(ROLE_SENIOR.getRoleKey(), ROLE_SENIOR);
		map.put(ROLE_ADMIN.getRoleKey(), ROLE_ADMIN);

		return map;
	}

	/**
	 * 获取当前账户对应role的【最高】安全级别
	 * @return
	 */
	public static int getCurrentUserSecretLevel() {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		Map<String, AuthorityDefine> authorityMap = getDefineMap();

		int level = 0;//如果没有角色，则用户安全级别是0
		for (GrantedAuthority a : authorities) {
			AuthorityDefine def = authorityMap.get(a.getAuthority());
			if (def == null) {
				continue;
			} else if (def.getSecretLevel() > level) {
				level = def.getSecretLevel();
			} else {
				continue;
			}
		}

		return level;
	}
}
