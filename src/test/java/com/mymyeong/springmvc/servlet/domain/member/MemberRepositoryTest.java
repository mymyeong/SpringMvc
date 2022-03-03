package com.mymyeong.springmvc.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberResRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberResRepository.clearStore();
	}

	@Test
	void save() {
		// given
		Member member = new Member("hello", 20);

		// when
		Member saveMember = memberResRepository.save(member);

		// than
		Member findMember = memberResRepository.findByid(saveMember.getId());
		assertThat(findMember).isEqualTo(saveMember);
	}

	@Test
	void findAll() {
		// given
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);
		memberResRepository.save(member1);
		memberResRepository.save(member2);

		// when
		List<Member> result = memberResRepository.findAll();

		// than
		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(member1, member2);
	}

}
