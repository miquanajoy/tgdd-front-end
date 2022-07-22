package com.group1.entities.user;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{

	private String roleId;

	private Set<User> usersWithRoleID;

	private String roleName;
	
	public Role() {
	}

	public Role(String roleId, Set<User> usersWithRoleID, String roleName) {
		super();
		this.roleId = roleId;
		this.usersWithRoleID = usersWithRoleID;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Set<User> getUsersWithRoleID() {
		return usersWithRoleID;
	}

	public void setUsersWithRoleID(Set<User> usersWithRoleID) {
		this.usersWithRoleID = usersWithRoleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "roleId=" + roleId + "\n       usersWithRoleID=" + usersWithRoleID + "\n       roleName=" + roleName;
	}

	
}