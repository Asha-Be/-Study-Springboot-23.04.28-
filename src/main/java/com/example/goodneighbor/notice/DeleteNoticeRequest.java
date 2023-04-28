package com.example.goodneighbor.notice;

public class DeleteNoticeRequest {
	
	private String userPassword;
	
	private Long memberId;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "DeleteNoticeRequest [userPassword=" + userPassword + ", memberId=" + memberId + "]";
	}
	
	
	
	
	

}
