package com.example.goodneighbor.notice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.goodneighbor.entity.MemberEntity;
import com.example.goodneighbor.entity.NoticeEntity;
import com.example.goodneighbor.member.UpdateUserRequest;
import com.example.goodneighbor.member.DeleteUserRequest;

@RestController
@RequestMapping("v1/notice")
public class NoticeController {

	private NoticeService service;

	public NoticeController(NoticeService service) {
		super();
		this.service = service;
	}

	// ---------

	// 글작성

	@PostMapping
	public void createNotice(@RequestBody CreateNoticeRequest request) {
		service.create(request);

	}

	// 글 조회

	@GetMapping("/{noticeId}")
	public NoticeEntity content(@PathVariable Long noticeId) {
		return service.content(noticeId);
	}
	// 글 수정

	@PutMapping("/{noticeId}")
	public void updateNotice(@PathVariable Long noticeId, @RequestBody UpdateNoticeRequest request) {
		service.update(noticeId, request);
		// 업데이트를 위해 @RequestBody에 입력한 비밀번호와 @MemberEntity에있는 비밀번호를 비교하여 수정
	}

	// 글 삭제

	@DeleteMapping("/{noticeId}")
	public void deleteNotice(@PathVariable Long noticeId, DeleteNoticeRequest request) {
		service.delete(noticeId, request);
	}
}
