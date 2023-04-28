package com.example.goodneighbor.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTestCodeVerifier {

	// 1번문제 : 조회수가 300 이상인 전체 애니메이션은 몇개인가요 ?
	public static Long problem1() {
		return StreamTestDataSupplier.getAnimeList().stream().filter(it -> it.viewCount >= 300).count();
	}

	// 2번문제 : 조회수가 300 이상, 400 이하 이면서 제조국이 한국인 애니메이션은 몇개인가요 ?
	public static Long problem2() {
		return StreamTestDataSupplier.getAnimeList().stream().filter(it -> it.viewCount >= 300)
				.filter(it -> it.viewCount <= 400).filter(it -> it.country.equals("한국")).count();
	}

	// 3번문제 : 매출액이 500 이상인 애니메이션은 몇개인가요 ?
	public static Long problem3() {
		return StreamTestDataSupplier.getAnimeList().stream().filter(it -> it.revenue >= 500).count();
	}

	// 4번문제 : 제조국이 미국인 애니메이션은 몇개인가요 ?
	public static Long problem4() {
		return StreamTestDataSupplier.getAnimeList().stream().filter(it -> it.country.equals("미국")).count();
	}

	// 5번문제 : 제조국이 일본이면서,조회수는 100이 넘고, 매출액은 200이 안되는 애니메이션은 몇개인가요 ?
	public static Long problem5() {
		return StreamTestDataSupplier.getAnimeList().stream().filter(it -> it.viewCount > 100).filter(it -> it.revenue <200).count();
	}
	
	// 6번문제 : 제조국이 일본인 모든 애니메이션의 제목을 주세요.
	public static List<String> problem6() {
		return StreamTestDataSupplier.getAnimeList()
				.stream()
				.filter(it -> it.country.equals("일본"))
				.map(it -> it.name)
				.collect(Collectors.toList());
	}
	
	// 7번문제 : 매출액이 500 이상인 모든 애니메이션의 이름과, 제조국을 주세요.
	public static List<AnimeSummary> problem7() {
		return StreamTestDataSupplier.getAnimeList()
				.stream()
				.filter(it -> it.revenue >= 500)
				.map(it -> new AnimeSummary(it.name, it.country))
				.toList();
	}
	static class AnimeSummary {
		String name;
		String country;
		public AnimeSummary(String name, String country) {
			super();
			this.name = name;
			this.country = country;
		}
	}
	// 8번문제 : 매출액이 300이상인 애니메이션을 제조한 국가들의 목록을 주세요. 중복없이.
}
