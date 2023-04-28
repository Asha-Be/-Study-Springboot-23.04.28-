package com.example.goodneighbor.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTestDataSupplier {

	public static List<Anime> getAnimeList() {
		return Arrays.asList(
				new Anime("센과 치히로", "일본", 900L, 1000L),
				new Anime("하이큐", "일본", 500L, 600L),
				new Anime("방랑밥", "일본", 200L, 150L),
				new Anime("오버로드", "일본", 9000L, 180000L),
				new Anime("헬싱", "일본", 100L, 400L),
				new Anime("최애의아이", "일본", 600L, 450L),
				new Anime("우마무스메", "일본", 800L, 1100L),
				new Anime("시끌별녀석들", "일본", 600L, 300L),
				new Anime("여우비", "한국", 150L, 100L),
				new Anime("은비까비", "한국", 800L, 50L),
				new Anime("머털도사", "한국", 700L, 80L),
				new Anime("배추도사무도사", "한국", 500L, 100L),
				new Anime("러브프로듀서", "중국", 200L, 400L),
				new Anime("파워퍼프걸", "미국", 900L, 500L),
				new Anime("사우스파크", "미국", 800L, 500L),
				new Anime("겁쟁이강아지크루지", "미국", 600L, 400L),
				new Anime("사무라이소드", "미국", 150L, 50L)
				

		);
	}

	static class Anime {
		String name;
		String country;
		Long viewCount;
		Long revenue;

		public Anime(String name, String country, Long viewCount, Long revenue) {
			super();
			this.name = name;
			this.country = country;
			this.viewCount = viewCount;
			this.revenue = revenue;
		}

	}
}
