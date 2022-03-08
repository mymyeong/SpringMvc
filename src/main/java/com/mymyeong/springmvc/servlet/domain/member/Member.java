package com.mymyeong.springmvc.servlet.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {

	private Long id;
	private String userName;
	private int age;

	public Member(String userName, int age) {
		this.userName = userName;
		this.age = age;
	}
}
