package com.lys.zhku.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Roles;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.system.RolesAuthoritiesService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/system/rolesAuthorities")
public class RolesAuthoritiesController {
	
	@Autowired
	private RolesAuthoritiesService rolesAuthoritiesService;

	/**
	 * 处理通用错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/{pathName}", method=RequestMethod.GET)
	public String pathNameView(@PathVariable String pathName) {
		return "system/rolesAuthorities_" + pathName;
	}
	
	@RequestMapping("getRolesAuthoritiesAll")
	@ResponseBody
	public List<Roles> getRolesAuthoritiesAll() {
		List<Roles> list = rolesAuthoritiesService.getAllRolesWithAuthorities(true,true);
		return list;
	}
	
	/**
	 * 根据逻辑删除角色,物理删除角色-权限的关系记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="roles/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message rolesDelete(Integer id) {
		rolesAuthoritiesService.deleteRole(id);
		return new Message(StatusCode.SUCCESS,"删除成功");
	}

	/**
	 * 增加角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value="roles/add", method=RequestMethod.POST)
	@ResponseBody
	public Message rolesAdd(Roles role) {
		rolesAuthoritiesService.insertRole(role);
		return new Message(StatusCode.SUCCESS,"添加角色成功");
	}

	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value="roles/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message rolesUpdate(Roles role) {
		rolesAuthoritiesService.updateRole(role);
		return new Message(StatusCode.SUCCESS,"修改角色成功");
	}

	/**
	 * 获取所有有效的Roles
	 * @return
	 */
	@RequestMapping(value="roles/getRolesList")
	@ResponseBody
	public List<Roles> getRolesList() {
		return rolesAuthoritiesService.getRolesList(true);
	}
	
	/**
	 * 获取所有有效的权限
	 * @return
	 */
	@RequestMapping(value="auths/getAuthsList")
	@ResponseBody
	public List<Authorities> getAuthsList() {
		return rolesAuthoritiesService.getAuthsList(true);
	}

	/**
	 * 获取所有的权限
	 * @return
	 */
	@RequestMapping(value="auths/getAuthsListAll")
	@ResponseBody
	public List<Authorities> getAuthsListAll() {
		return rolesAuthoritiesService.getAuthsListAll();
	}

	@RequestMapping(value="auths/addToRole")
	@ResponseBody
	public Message authsAddToRole(Integer roleId, Integer authId) {
		rolesAuthoritiesService.addAuthToRoles(roleId, authId);
		return new Message(StatusCode.SUCCESS, "添加权限成功");
	}

	/**
	 * 角色删除权限
	 * @param roleId
	 * @param authId
	 * @return
	 */
	@RequestMapping(value="auths/deleteToRole")
	@ResponseBody
	public Message authsDeleteToRole(Integer roleId, Integer authId) {
		rolesAuthoritiesService.deleteAuthToRoles(roleId, authId);
		return new Message(StatusCode.SUCCESS, "删除权限成功");
	}

	/**
	 * 添加权限
	 * @param roleId
	 * @param authId
	 * @return
	 */
	@RequestMapping(value="auths/insert")
	@ResponseBody
	public Message authsInsert(Authorities auth) {
		rolesAuthoritiesService.addAuth(auth);
		return new Message(StatusCode.SUCCESS, "添加权限成功");
	}

	/**
	 * 添加权限
	 * @param roleId
	 * @param authId
	 * @return
	 */
	@RequestMapping(value="auths/update")
	@ResponseBody
	public Message authsUpdate(Authorities auth) {
		rolesAuthoritiesService.updateAuth(auth);
		return new Message(StatusCode.SUCCESS, "修改权限成功");
	}

	/**
	 * 批量删除权限
	 * @param roleId
	 * @param authId
	 * @return
	 */
	@RequestMapping(value="auths/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message authsDelete(Integer[] ids) {
		//TODO: 批量删除权限
		rolesAuthoritiesService.deleteAuthsByIds(ids);
		return new Message(StatusCode.SUCCESS, "修改权限成功");
	}
}
