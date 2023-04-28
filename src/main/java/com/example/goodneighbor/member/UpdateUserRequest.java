package com.example.goodneighbor.member;

public class UpdateUserRequest {
	
	private String userPassword;
	private String nickname;
	private String Tel;
	private String address;
	private String updateUser;
	
	public String getUserPassword() {
		return userPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public String getTel() {
		return Tel;
	}
	public String getAddress() {
		return address;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	@Override
	public String toString() {
		return "UpdateUserRequest [userPassword=" + userPassword + ", nickname=" + nickname + ", Tel=" + Tel
				+ ", address=" + address + ", updateUser=" + updateUser + "]";
	}
	
	

}
