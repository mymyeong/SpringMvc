package com.mymyeong.springmvc.servlet.web.frontcontroller.v4.controller;

import java.util.Map;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;
import com.mymyeong.springmvc.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberSaveControllerV4 implements ControllerV4 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String userName = paramMap.get("userName");
		int age = Integer.parseInt(paramMap.get("age"));
		Member member = new Member(userName, age);
		memberRepository.save(member);
		System.out.println("member = " + member);

		model.put("member", member);
		return "save-result";
	}

//	@Override
//	public ModelView process(Map<String, String> paramMap) {
//
//		String userName = paramMap.get("userName");
//		int age = Integer.parseInt(paramMap.get("age"));
//		Member member = new Member(userName, age);
//		memberRepository.save(member);
//		System.out.println("member = " + member);
//
//		ModelView mv = new ModelView("save-result");
//		mv.getModel().put("member", member);
//		return mv;
//	}

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
