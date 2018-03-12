package com.lys.zhku.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.AuthoritiesMapper;
import com.lys.zhku.mapper.RolesAuthoritiesMapper;
import com.lys.zhku.mapper.RolesMapper;
import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Roles;
import com.lys.zhku.model.RolesAuthorities;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.service.system.RolesAuthoritiesService;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Service
public class RolesAuthoritiesServiceImpl implements RolesAuthoritiesService {

	@Autowired
	private RolesMapper rolesMapper;
	
	@Autowired
	private AuthoritiesMapper authoritiesMapper;
	
	@Autowired
	private RolesAuthoritiesMapper rolesAuthoritiesMapper;
	
	
	@Override
	public List<Roles> getAllRolesWithAuthorities(boolean rolesEnable, boolean authoritiesEnable) {
		return rolesMapper.selectAllWithAuthorities(rolesEnable, authoritiesEnable);
	}

	@Override
	public int deleteRole(Integer id) {
		rolesAuthoritiesMapper.deleteByRolesId(id);
		return rolesMapper.updateByPrimaryKeyForEnable(id, false);
	}

	@Override
	public int insertRole(Roles role) {
		if(StringUtils.isEmpty(role.getRole())) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "丢失请求参数:role");
		}
		Roles selectRole = rolesMapper.selectByRole(role.getRole());
		if(selectRole!=null) {
			throw new ErrorException(StatusCode.EXIST, role.getRole()+" -角色已经存在,请令起角色名字");
		}
		role.setEnable(true);
		return rolesMapper.insert(role);
	}

	@Override
	public List<Roles> getRolesList(boolean enable) {
		return rolesMapper.selectAllByEnable(enable);
	}

	@Override
	public List<Authorities> getAuthsList(boolean enable) {
		return authoritiesMapper.selectAllByEnable(enable);
	}

	@Override
	public int addAuthToRoles(Integer roleId, Integer authId) {
		RolesAuthorities rolesAuthorities =  rolesAuthoritiesMapper.selectByRoleIdAndAuthId(roleId, authId);
		if(rolesAuthorities!=null) {
			throw new ErrorException(StatusCode.EXIST, "记录已经存在");
		}
		RolesAuthorities target = new RolesAuthorities();
		target.setRolesId(roleId);
		target.setAuthoritiesId(authId);
		return rolesAuthoritiesMapper.insert(target);
	}

	@Override
	public int deleteAuthToRoles(Integer roleId, Integer authId) {
		return rolesAuthoritiesMapper.deleteByRolesIdAndAuthsId(roleId, authId);
	}

	@Override
	public List<Authorities> getAuthsListAll() {
		return authoritiesMapper.selectAll();
	}

	@Override
	public int addAuth(Authorities auth) {
		if(StringUtils.isEmpty(auth.getAuthority())) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM,"缺失请求参数");
		}
		Authorities select = authoritiesMapper.selectByAuthority(auth.getAuthority());
		if(select!=null) {
			throw new ErrorException(StatusCode.EXIST,"数据已存在");
		}
		auth.setEnable(true);
		return authoritiesMapper.insert(auth);
	}

	@Override
	public int updateAuth(Authorities auth) {
		if(auth==null || !ModelUtils.isNotNullForAllNotNullField(auth)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM,"缺失请求参数");
		}
		return authoritiesMapper.updateByPrimaryKey(auth);
	}

	@Override
	public int deleteAuthsByIds(Integer[] ids) {
		return authoritiesMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int updateRole(Roles role) {
		if(role==null || !ModelUtils.isNotNullForAllNotNullField(role)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM,"缺失请求参数");
		}
		return rolesMapper.updateByPrimaryKey(role);
	}
}
