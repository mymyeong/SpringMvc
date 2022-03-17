package com.mymyeong.springmvc.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;

@Controller
public class SpringMemberSaveControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members/save")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member(userName, age);
		System.out.println("member = " + member);
		memberRepository.save(member);
		ModelAndView mv = new ModelAndView("save-result");
		mv.addObject("member", member);
		return mv;
	}
}
