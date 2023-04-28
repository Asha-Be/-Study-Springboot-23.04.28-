package com.example.goodneighbor.member;

public class DeleteUserRequest {

	private String userPassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "DeleteUserRequest [userPassword=" + userPassword + "]";
	}

	
	
}
