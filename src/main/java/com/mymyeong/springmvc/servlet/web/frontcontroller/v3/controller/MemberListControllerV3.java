package com.mymyeong.springmvc.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;
import com.mymyeong.springmvc.servlet.web.frontcontroller.ModelView;
import com.mymyeong.springmvc.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		System.out.println("MvcMemberListServlet.service");
		List<Member> members = memberRepository.findAll();

		ModelView mv = new ModelView("members");
		mv.getModel().put("members", members);
		return mv;
	}

//	@Override
//	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		System.out.println("MvcMemberListServlet.service");
//		List<Member> members = memberRepository.findAll();
//		request.setAttribute("members", members);
//
//		return new MyView("/WEB-INF/views/members.jsp");
//	}

}
