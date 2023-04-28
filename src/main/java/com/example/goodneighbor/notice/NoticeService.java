package com.example.goodneighbor.notice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.goodneighbor.entity.MemberEntity;
import com.example.goodneighbor.entity.NoticeEntity;
import com.example.goodneighbor.exception.NeighborErrorCode;
import com.example.goodneighbor.exception.NeighborException;
import com.example.goodneighbor.repository.MemberRepository;
import com.example.goodneighbor.repository.NoticeRepository;

@Service
public class NoticeService {

	private NoticeRepository noticeRepository;
	private MemberRepository memberRepository;


	public NoticeService(NoticeRepository noticeRepository, MemberRepository memberRepository) {
		super();
		this.noticeRepository = noticeRepository;
		this.memberRepository = memberRepository;
	}
	// create

	public void create(CreateNoticeRequest request) {

		var entity = new NoticeEntity();

		entity.setNoticeId(request.getNoticeId());
		entity.setNoticeTitle(request.getNoticeTitle());
		entity.setNoticeNickname(request.getNoticeNickname());
		entity.setNoticeContent(request.getNoticeContent());
		entity.setCreateNotice(LocalDateTime.now());
		entity.setUpdateNotice(LocalDateTime.now());

		var insufficientArgs = Arrays.asList(
				request.getNoticeTitle(),
				request.getNoticeNickname(),
				request.getNoticeContent()
				).stream()
				.map(it -> Long.parseLong(it))
				.allMatch(it -> it != null);
		
		
		
		List<Long> blah = Arrays.asList(
				request.getNoticeTitle(),
				request.getNoticeNickname(),
				request.getNoticeContent()
				).stream()
				.map(it -> Long.parseLong(it))
				.filter(it -> it > 10)
				.filter(it -> it < 100)
				.collect(Collectors.toList());
//		insufficientArgs
//		.stream()
//		.filter(str -> str == null)
//		.anyMatch(it -> it == null);
		
//		var newList = new ArrayList<String>();
//		for (String string : insufficientArgs) {
//			if ( string == null) {
//				newList.add(string);
//			}
//		}
		
		
		if (insufficientArgs) {
			NeighborErrorCode.INSUFFICIENT_ARGS_IN_NOTICE.doThrowNeighborException();
		}
//		if (request.getNoticeNickname() == null) {
//			throw NeighborException.from("499", "공지 작성 중 닉네임이 NoticeService에 전달되지 않았습니다.");
//		}
//		if (request.getNoticeContent() == null) {
//			throw NeighborException.from("499", "공지 작성 중 글내용이 NoticeService에 전달되지 않았습니다.");
//		}
		noticeRepository.save(entity);

	}

	// 조회

	public NoticeEntity content(Long noticeId) {
		return noticeRepository.findById(noticeId).orElseThrow(null);
	}

	// update

	public void update(Long noticeId, UpdateNoticeRequest request) {

		var entity = noticeRepository.findById(noticeId)
				.orElseThrow(NeighborErrorCode.INVALID_PASSWORD.exceptionSupplier());

		entity.setNoticeTitle(request.getNoticeTitle());
		entity.setNoticeContent(request.getNoticeContent());
		entity.setUpdateNotice(LocalDateTime.now());
		
		if(request.getMemberId() == null) {
			throw NeighborException.from("498", "공지 수정 중 memberId가 NoticeService에 전달되지 않았습니다.");
		}

		if (request.getNoticeTitle() == null) {
			throw NeighborException.from("498", "공지 수정 중 제목이 NoticeService에 전달되지 않았습니다.");
		}
		if (request.getNoticeContent() == null) {
			throw NeighborException.from("498", "공지 수정 중 글내용이 NoticeService에 전달되지 않았습니다.");
		}

		// 비밀번호를...
		var memberEntity = memberRepository.findById(request.getMemberId())
				.orElseThrow(() -> NeighborException.from("201", "(공지수정) memberEntity에서 userPassword 를 받아오지 못했습니다. "));
		
//		var foo = memberRepository.findById(request.getMemberId());
//		if (foo == null) {
//			throw NeighborException.from("201", "(공지수정) memberEntity에서 userPassword 를 받아오지 못했습니다. ");
//		}
		// Supplier<Exception>
		// public Exception get() {
		// 
		// }
		// () 		-> 		{}
		// 인자값.			리턴
		// () -> NeithborException.from("201", "(공지수정) memberEntity에서 userPassword 를 받아오지 못했습니다. ")

		// if문을 사용해 memberDB의 패스워드와 작성한 패스워드가 같은지 비교하기

		if (memberEntity.getUserPassword().equals(request.getUserPassword())) {
			noticeRepository.save(entity);
		} else {
			throw NeighborException.from("501", "notice수정을 위한 비밀번호 확인 과정에서 오류가 발생했습니다.");
		}

	}

	// delete

	public void delete(Long noticeId, DeleteNoticeRequest request ) {

		var entity = noticeRepository.findById(noticeId)
				.orElseThrow(() -> NeighborException.from("503", "(공지삭제)잘못된 NoticeId 입니다."));
		
		//memberEntity에 있는 userPassword와 입력한 userPassword를 비교하여 같을시에만 삭제 하도록 
		
		var memberEntity = memberRepository.findById(request.getMemberId())
				.orElseThrow(() -> NeighborException.from("202", "(공지삭제) memberEntity에서 userPassword를 받아오지 못했습니다."));
		
		if(memberEntity.getUserPassword().equals(request.getUserPassword())) {
			
			noticeRepository.delete(entity);
		}else {
			throw NeighborException.from("502","notice 삭제를 위한 비밀번호 확인 과정에서 오류가 발생했습니다.");
		}

	}

}
