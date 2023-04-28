package com.example.goodneighbor.notice;

import java.time.LocalDateTime;


public class UpdateNoticeRequest {
	
	
	
	

	private String noticeTitle;

	private String noticeContent;

	private LocalDateTime updateNotice;
	
	private String userPassword;

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public LocalDateTime getUpdateNotice() {
		return updateNotice;
	}

	public void setUpdateNotice(LocalDateTime updateNotice) {
		this.updateNotice = updateNotice;
	}

	
	public String getUserPassword() {
		return userPassword;
	}

	@Override
	public String toString() {
		return "UpdateNoticeRequest [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", updateNotice=" + updateNotice + ", userPassword=" + userPassword + ", memberId=" + memberId + "]";
	}

	///--------
	
	
	private Long memberId;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
	

}
