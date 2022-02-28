package com.mymyeong.springmvc.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParameterServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		allParam(request, resp);
	}

	private void allParam(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		System.out.println("[��ü �Ķ���� ��ȸ] - start");

		request.getParameterNames().asIterator()//
				.forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

		System.out.println("[��ü �Ķ���� ��ȸ] - end");
		System.out.println();

		System.out.println("[���� �Ķ���� ��ȸ]");
		String username = request.getParameter("username");
		System.out.println("request.getParameter(username) = " + username);
		String age = request.getParameter("age");
		System.out.println("request.getParameter(age) = " + age);
		System.out.println();

		System.out.println("[�̸��� ���� ���� �Ķ���� ��ȸ]");
		System.out.println("request.getParameterValues(username)");
		String[] usernames = request.getParameterValues("username");
		for (String name : usernames) {
			System.out.println("username=" + name);
		}
		System.out.println();
		resp.getWriter().write("ok");
	}
}
