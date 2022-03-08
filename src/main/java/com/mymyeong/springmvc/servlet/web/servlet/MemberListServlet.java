package com.mymyeong.springmvc.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymyeong.springmvc.servlet.domain.member.Member;
import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;

@WebServlet(name = "nemberListServlet", urlPatterns = "/servlet/members/list")
public class MemberListServlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");

		PrintWriter w = resp.getWriter();
		w.write("<html>");
		w.write("<head>");
		w.write(" <meta charset=\"UTF-8\">");
		w.write(" <title>nemberListServlet</title>");
		w.write("</head>");
		w.write("<body>");
		w.write("<a href=\"/index.html\">����</a>");
		w.write("<table>");
		w.write(" <thead>");
		w.write(" <th>id</th>");
		w.write(" <th>username</th>");
		w.write(" <th>age</th>");
		w.write(" </thead>");
		w.write(" <tbody>");
		/*
		 * w.write(" <tr>"); w.write(" <td>1</td>"); w.write(" <td>userA</td>");
		 * w.write(" <td>10</td>"); w.write(" </tr>");
		 */
		for (Member member : members) {
			w.write(" <tr>");
			w.write(" <td>" + member.getId() + "</td>");
			w.write(" <td>" + member.getUserName() + "</td>");
			w.write(" <td>" + member.getAge() + "</td>");
			w.write(" </tr>");
		}
		w.write(" </tbody>");
		w.write("</table>");
		w.write("</body>");
		w.write("</html>");
	}
}