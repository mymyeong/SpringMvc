package com.mymyeong.springmvc.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;
import com.mymyeong.springmvc.servlet.web.frontcontroller.MyView;
import com.mymyeong.springmvc.servlet.web.frontcontroller.v2.ControllerV2;

public class MemberListControllerV2 implements ControllerV2 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("MvcMemberListServlet.service");
		List<Member> members = memberRepository.findAll();
		request.setAttribute("members", members);

		return new MyView("/WEB-INF/views/members.jsp");
	}

//	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("MvcMemberListServlet.service");
//		List<Member> members = memberRepository.findAll();
//		request.setAttribute("members", members);
//		String viewPath = "/WEB-INF/views/members.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//		dispatcher.forward(request, response);
//	}

}
