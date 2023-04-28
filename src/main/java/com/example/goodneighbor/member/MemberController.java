package com.example.goodneighbor.member;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.goodneighbor.entity.MemberEntity;

@RestController
@RequestMapping("v2/member")
public class MemberController {

	private MemberService service;

	public MemberController(MemberService service) {
		super();
		this.service = service;
	}

	// -------------------

	// 회원가입
	@PostMapping
	public void insert(@RequestBody createUserRequest request) {

		service.insert(request);
	}

	// 단일 조회
	@GetMapping("/{memberId}")
	public MemberEntity detail(@PathVariable Long memberId) {
		return service.detail(memberId);
	}

	// 회원 수정

	@PutMapping("/{memberId}")
	public void update(@PathVariable Long memberId, @RequestBody UpdateUserRequest request) {
		service.update(request, memberId);
	}

	// 회원 삭제
	
	@DeleteMapping("/{memberId}")
	public void delete(@PathVariable Long memberId, @RequestBody DeleteUserRequest request) {
		service.delete(memberId, request.getUserPassword());
	}

	// 아이디, 비밀번호 검색

}
