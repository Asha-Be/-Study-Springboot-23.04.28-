package com.example.goodneighbor.member;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import com.example.goodneighbor.entity.*;
import com.example.goodneighbor.exception.NeighborException;
import com.example.goodneighbor.repository.MemberRepository;

@Service
public class MemberService {

	private MemberRepository repository;

	public MemberService(MemberRepository repository) {
		super();
		this.repository = repository;
	}

//---------------------

	public void insert(createUserRequest request) {

		var entity = new MemberEntity();

		entity.setUserId(request.getUserId());
		entity.setUserPassword(request.getUserPassword());
		entity.setNickname(request.getNickname());
		entity.setUserAge(request.getUserAge());
		entity.setAddress(request.getAddress());
		entity.setTel(request.getTel());
		entity.setCreateUser(LocalDateTime.now());
		entity.setUpdateUser(LocalDateTime.now());

		if (request.getUserId() == null) {
			throw NeighborException.from("1", "회원가입 시 아이디가 MemberService에 전달되지 않았습니다.");
		}
		if (request.getUserPassword() == null) {
			throw NeighborException.from("1", "회원가입 시 비밀번호가 MemberService에 전달되지 않았습니다.");
		}

		if (request.getNickname() == null) {
			throw NeighborException.from("1", "회원가입 시 닉네임이 MemberService에 전달되지 않았습니다.");
		}
		if (request.getUserAge() == null) {
			throw NeighborException.from("1", "회원가입 시 나이가 MemberService에 전달되지 않았습니다.");
		}
		if (request.getTel() == null) {
			throw NeighborException.from("1", "회원가입 시 전화번호가 MemberService에 전달되지 않았습니다.");
		}
		if (request.getAddress() == null) {
			throw NeighborException.from("1", "회원가입 시 주소가 MemberService에 전달되지 않았습니다.");
		}
		

		repository.save(entity);
	}

//-------------
	public MemberEntity detail(Long memberId) {

		return repository.findById(memberId).orElseThrow(null);
	}

//-------------

	public void update(UpdateUserRequest request, Long memberId) {

		var entity = repository.findById(memberId)
				.orElseThrow(() -> NeighborException.from("200", "(회원수정)잘못된 MemberId 입니다."));

		entity.setUserPassword(request.getUserPassword());
		entity.setNickname(request.getNickname());
		entity.setTel(request.getTel());
		entity.setAddress(request.getAddress());
		entity.setUpdateUser(LocalDateTime.now());

		if (request.getUserPassword() == null) {
			throw NeighborException.from("1", "회원수정 시 비밀번호가 MemberService에 전달되지 않았습니다.");
		}

		if (request.getNickname() == null) {
			throw NeighborException.from("1", "회원수정 시 닉네임이 MemberService에 전달되지 않았습니다.");
		}
		if (request.getTel() == null) {
			throw NeighborException.from("1", "회원수정 시 전화번호가 MemberService에 전달되지 않았습니다.");
		}
		if (request.getAddress() == null) {
			throw NeighborException.from("1", "회원수정 시 나이가 MemberService에 전달되지 않았습니다.");
		}

		repository.save(entity);
	}
//---------------

	public void delete(Long memberId, String UserPassword) {

		var entity = repository.findById(memberId)
				.orElseThrow(() -> NeighborException.from("200", "(회원삭제)잘못된 MemberId 입니다."));

		if (!entity.getUserPassword().equals(UserPassword)) {
			throw NeighborException.from("300", "입력하신 비밀번호가 옳지 않습니다.");

		}

		repository.deleteById(memberId);
	}

}
