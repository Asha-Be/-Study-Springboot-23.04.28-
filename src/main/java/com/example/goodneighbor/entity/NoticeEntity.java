package com.example.goodneighbor.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notice")
public class NoticeEntity {
	
	//DB글 순서, 글제목, 글작성자(닉네임), 작성일자 , 수정일자, 글내용
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long noticeId;
	
	@Column(nullable = true)
	private String noticeTitle;
	
	@Column(nullable = true)
	private String noticeNickname;
	
	@Column(nullable = true)
	private String noticeContent;
	
	@Column(nullable = true)
	private LocalDateTime createNotice;
	
	@Column(nullable = true)
	private LocalDateTime updateNotice;

	@Override
	public String toString() {
		return "NoticeEntity [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeNickname="
				+ noticeNickname + ", noticeContent=" + noticeContent + ", createNotice=" + createNotice
				+ ", updateNotice=" + updateNotice + "]";
	}

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

	public LocalDateTime getCreateNotice() {
		return createNotice;
	}

	public void setCreateNotice(LocalDateTime createNotice) {
		this.createNotice = createNotice;
	}

	public LocalDateTime getUpdateNotice() {
		return updateNotice;
	}

	public void setUpdateNotice(LocalDateTime updateNotice) {
		this.updateNotice = updateNotice;
	}
	
	
	//--
	
	

}
