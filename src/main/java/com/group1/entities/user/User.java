package com.group1.entities.user;

import java.io.Serializable;

public class User implements Serializable {

	private String userId;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private Role roleIdentity;

	private String roleId;

	private Boolean enabled;

	private Boolean status;

	public User() {
	}

	public User(String userId, String firstName, String lastName, String userName, String password, Role roleIdentity,
			String roleId, Boolean enabled, Boolean status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.roleIdentity = roleIdentity;
		this.roleId = roleId;
		this.enabled = enabled;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRoleIdentity() {
		return roleIdentity;
	}

	public void setRoleIdentity(Role roleIdentity) {
		this.roleIdentity = roleIdentity;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "userId=" + userId + "\n       firstName=" + firstName + "\n       lastName=" + lastName
				+ "\n       userName=" + userName + "\n       password=" + password + "\n       roleIdentity="
				+ roleIdentity + "\n       roleId=" + roleId + "\n       enabled=" + enabled + "\n       status="
				+ status;
	}


}
