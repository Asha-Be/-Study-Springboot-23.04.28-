package com.example.goodneighbor.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="memberList")
public class MemberEntity {

	// 멤버아이디, 아이디, 비번, 닉네임,나이, 주소, 전화번호 , 생성날짜,수정날짜.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 생성된 값 (전략 = 세대유형.IDENTITY)
	private Long memberId;

	@Column(nullable = true, unique = true)
	private String userId;

	@Column(nullable = true)
	private String userPassword;

	@Column(nullable = true)
	private String nickname;

	@Column(nullable = true)
	private String userAge;

	@Column(nullable = true)
	private String Address;

	@Column(nullable = true)
	private String Tel;

	@Column(nullable = true)
	private LocalDateTime createUser;

	@Column(nullable = true)
	private LocalDateTime updateUser;

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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public LocalDateTime getCreateUser() {
		return createUser;
	}

	public void setCreateUser(LocalDateTime createUser) {
		this.createUser = createUser;
	}

	public LocalDateTime getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(LocalDateTime updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "MemberEntity [memberId=" + memberId + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", nickname=" + nickname + ", userAge=" + userAge + ", Address=" + Address + ", Tel=" + Tel
				+ ", createUser=" + createUser + ", updateUser=" + updateUser + "]";
	}

}
