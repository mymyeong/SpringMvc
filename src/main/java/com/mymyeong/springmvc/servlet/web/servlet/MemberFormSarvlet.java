package com.mymyeong.springmvc.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymyeong.springmvc.servlet.domain.member.MemberRepository;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/newform")
public class MemberFormSarvlet extends HttpServlet {

//	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter w = resp.getWriter();
		w.write("<!DOCTYPE html>\n" //
				+ "<html>\n" //
				+ "<head>\n" //
				+ " <meta charset=\"UTF-8\">\n" //
				+ " <title>memberFormServlet</title>\n" //
				+ "</head>\n" //
				+ "<body>\n" //
				+ "<form action=\"/servlet/members/save\" method=\"post\">\n" //
				+ " userName: <input type=\"text\" name=\"userName\" />\n" //
				+ " age: <input type=\"text\" name=\"age\" />\n" //
				+ " <button type=\"submit\">����</button>\n" //
				+ "</form>\n" //
				+ "</body>\n" //
				+ "</html>\n");
	}
}
