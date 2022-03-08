package com.mymyeong.springmvc.servlet.web.frontcontroller.v4.controller;

import java.util.List;
import java.util.Map;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;
import com.mymyeong.springmvc.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		System.out.println("MvcMemberListServlet.service");
		List<Member> members = memberRepository.findAll();

		model.put("members", members);

		return "members";
	}

//	@Override
//	public ModelView process(Map<String, String> paramMap) {
//		System.out.println("MvcMemberListServlet.service");
//		List<Member> members = memberRepository.findAll();
//
//		ModelView mv = new ModelView("members");
//		mv.getModel().put("members", members);
//		return mv;
//	}

}
