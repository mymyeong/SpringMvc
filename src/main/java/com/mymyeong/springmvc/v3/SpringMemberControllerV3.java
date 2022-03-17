package com.mymyeong.springmvc.v3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@GetMapping("/new-form")
	public String newForm() {
		return "new-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("userName") String userName, @RequestParam("age") int age, Model mav) {
		Member member = new Member(userName, age);
		memberRepository.save(member);
		mav.addAttribute("member", member);
		return "save-result";
	}

	@GetMapping
	public String members(Model mav) {
		List<Member> members = memberRepository.findAll();
		mav.addAttribute("members", members);
		return "members";
	}
}
