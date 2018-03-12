package com.lys.zhku.service.system;

import java.util.List;

import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Roles;

public interface RolesAuthoritiesService {

	public List<Roles> getAllRolesWithAuthorities(boolean rolesEnable, boolean authoritiesEnable);

	public int deleteRole(Integer id);

	public int insertRole(Roles role);

	public List<Roles> getRolesList(boolean enable);

	public List<Authorities> getAuthsList(boolean enable);

	public int addAuthToRoles(Integer roleId, Integer authId);

	public int deleteAuthToRoles(Integer roleId, Integer authId);

	public List<Authorities> getAuthsListAll();

	public int addAuth(Authorities auth);

	public int updateAuth(Authorities auth);

	public int deleteAuthsByIds(Integer[] ids);

	public int updateRole(Roles role);
}
