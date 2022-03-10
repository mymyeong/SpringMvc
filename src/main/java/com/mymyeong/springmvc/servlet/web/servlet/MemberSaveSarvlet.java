package com.mymyeong.springmvc.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;

@WebServlet(name = "memberSaveSarvlet", urlPatterns = "/servlet/members/save")
public class MemberSaveSarvlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		int age = Integer.parseInt(req.getParameter("age"));

		Member member = new Member(userName, age);
		memberRepository.save(member);

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter w = resp.getWriter();
		w.write("<html>\n" + //
				"<head>\n" + //
				" <meta charset=\"UTF-8\">\n" + //
				"</head>\n" + //
				"<body>\n" + //
				"성공\n" + //
				"<ul>\n" + //
				" <li>id=" + member.getId() + "</li>\n" + //
				" <li>username=" + member.getUserName() + "</li>\n" + //
				" <li>age=" + member.getAge() + "</li>\n" + //
				"</ul>\n" + //
				"<a href=\"/index.html\">메인</a>\n" + //
				"</body>\n" + //
				"</html>");
	}
}
