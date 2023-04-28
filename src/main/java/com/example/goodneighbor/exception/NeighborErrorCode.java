package com.example.goodneighbor.exception;

import java.util.function.Supplier;

public enum NeighborErrorCode {
	INVALID_RESOURCE_ID("1000", "입력한 ID 값이 일치하지 않습니다."), // ID 정보 불일
	INVALID_PASSWORD("2000", "입력하신 비밀번호가 정확하지 않습니다."),
	INVALID_NOTICE_ID("500", "(공지수정) 과정에서 noticeId를 받아오지 못했습니다."),
	INSUFFICIENT_ARGS_IN_NOTICE("499", "공지 작성 중 내용이 NoticeService에 전달되지 않았습니다.")
	;
	
	private final String code;
	private final String message;
	private NeighborErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public  Supplier<NeighborException> exceptionSupplier() {
		return () -> NeighborException.from(code, message);
	}
	
	public void doThrowNeighborException() {
		throw NeighborException.from(code, message);
	}
	
}
/**
 * enum 이란 ? ( Enumerable ) 열거형 타입을 말한다. 일반적으로 사용하는 static 상수 값과 유사하며, 여기에 더 많은
 * 정보를 담아서 나열할 수 있다.
 * 
 * supply : 영어로 보급하다는 의미. supplier : 보급하는 사람을 의미한다. 그러므로 exception supplier 는
 * excpetion 을 만들어서 리턴하는 행위 람다식을 의미한다.
 * 
 * 
 * Collection ( Map, List, Set.. ) : 데이터 저장 및 표현을 위한 자료형.
 * Stream : 데이터 연산을 위한 자료형.
 * 
 * Java Stream 이란 ?
 * 컬렉션을 유용하게 다루기 위한 자료형태.
 * 편의 기능이 많이 존재하며, 대부분의 인자로 람다식을 받는다.
 * 많이 쓰는 함수
 * 1. filter : 리턴 타입이 스트림이다. 근데. 내가 원하는 조건의 요소들만 가지게 걸러낸다.
 * 2. anyMatch : 스트림 내에 어떠한 엘리먼트(구성요소)가 조건을 만족한다면 true. 모두 만족하지 않을때 false.
 * 3. allMatch : 스트림 내에 모든 구성요소가 해당 조건을 만족한다면 true. 하나라도 만족하지 않으면 false.
 * 4. map : 지금 스트림을 구성하는 요소의 형태를 특정한 다른 타입의 스트림으로 바꾸고 싶을때 사용한다.
 * 5. collect : 스트림으로 계산을 끝냈으니 표현하기 좋은 List, Map 의 형태로 다시 돌아갈래!
 * ex. Stream<String> -> Stream<Long>
 * 
 * Optional 이란?
 * 자바에서 null 을 보다 쉽게 다룰수 있게 만들어주는 클래스.
 * 자주 쓰는 함수.
 * 1. orElseThrow : 만약에 내가 가지고 있는 값이 null 이라면 던져버리겠다.
 * 2. orElse : 내가 가지고 있는 값이 null 이라면 이걸줄게.
 * 3. orElseGet : 내가 가지고 있는 값이 null 이라면 어디가서 얻어올게.
 * 4. ifPresent : 내가 가지고 있는 값이 null 이 아니라면 뭔갈 할거야.
 * 5. get : 내가 가지고 있는게 null 이던 말건 줄게.
 * 
 * Consumer : 소비하는 사람. 소비자.
 * Predicate :단언하다. true / false 를 결정한다.
 **/