package com.mymyeong.springmvc.servlet.basic.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// [status-line]
		resp.setStatus(HttpServletResponse.SC_OK);

		// [response-header]
		resp.setHeader("Content-Type", "text/plain;charset=UTF-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setHeader("Pargma", "no-cache");
		resp.setHeader("my-header", "hello");

		// [Header ���� �޼���]
		content(resp);
		cookie(resp);
		redirect(resp);

		resp.getWriter().write("ok");
	}

	private void content(HttpServletResponse response) {
		// Content-Type: text/plain;charset=utf-8
		// Content-Length: 2
		// response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		// response.setContentLength(2); //(������ �ڵ� ����)
	}

	private void cookie(HttpServletResponse response) {
		// Set-Cookie: myCookie=good; Max-Age=600;
		// response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600); // 600��
		response.addCookie(cookie);
	}

	private void redirect(HttpServletResponse response) throws IOException {
		// Status Code 302
		// Location: /basic/hello-form.html
		// response.setStatus(HttpServletResponse.SC_FOUND); //302
		// response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}
}
