package com.mymyeong.springmvc.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;
import com.mymyeong.springmvc.servlet.web.frontcontroller.ModelView;
import com.mymyeong.springmvc.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {

		String userName = paramMap.get("userName");
		int age = Integer.parseInt(paramMap.get("age"));
		Member member = new Member(userName, age);
		memberRepository.save(member);
		System.out.println("member = " + member);

		ModelView mv = new ModelView("save-result");
		mv.getModel().put("member", member);
		return mv;
	}

//	@Override
//	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String username = request.getParameter("userName");
//		int age = Integer.parseInt(request.getParameter("age"));
//		Member member = new Member(username, age);
//		memberRepository.save(member);
//		System.out.println("member = " + member);
//		// Model에 데이터를 보관한다.
//		request.setAttribute("member", member);
//
//		return new MyView("/WEB-INF/views/save-result.jsp");
//	}
}
