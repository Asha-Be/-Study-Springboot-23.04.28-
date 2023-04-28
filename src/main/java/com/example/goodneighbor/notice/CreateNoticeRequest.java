package com.example.goodneighbor.notice;

public class CreateNoticeRequest {
	
	private Long noticeId;
	private String noticeTitle;
	private String noticeNickname;
	private String noticeContent;
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeNickname() {
		return noticeNickname;
	}
	public void setNoticeNickname(String noticeNickname) {
		this.noticeNickname = noticeNickname;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Override
	public String toString() {
		return "CreateNoticeRequest [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeNickname="
				+ noticeNickname + ", noticeContent=" + noticeContent + "]";
	}
	
	

}
