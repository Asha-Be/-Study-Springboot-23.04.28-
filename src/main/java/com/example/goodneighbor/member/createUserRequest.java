package com.example.goodneighbor.member;

public class createUserRequest {
	
	private Long memberId;
	private String userId;
	private String userPassword;
	private String nickname;
	private String userAge;
	private String address;
	private String tel;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "createUserRequest [memberId=" + memberId + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", nickname=" + nickname + ", userAge=" + userAge + ", address=" + address + ", tel=" + tel + "]";
	}
	
	

}
