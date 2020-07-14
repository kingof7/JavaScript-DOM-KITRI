package com.java.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example04 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		System.out.println("get입니다.");
		System.out.println("name : "+ name + " phone: " + phone + " addr: " + addr);
		
//		PrintWriter - 출력보조스트림
		
//		OutputStream 
//		OutputStreamWriter 
//		BufferedWriter - (서버->클라로) 이 세개의 클래스로 문자열 입력을 받은 다음 바이너리데이터로 외부로 보낼 수 있다.
//		하지만 이 세개의 클래스를 한번에 제공해주는 HttpServletResponse의 강력한 함수가있다.
		resp.setContentType("text/html;charset=utf-8");
//		resp.getCharacterEncoding();
		PrintWriter pw = resp.getWriter(); // getWRiter()가 출력스트림역할을 해준다.
		pw.print("<html>");
		pw.print("<head><title></title></head>");
		pw.print("<body>");
		pw.print("<h3>회원가입이 완료됬습니다.!" + name +"</h3>");
		pw.print("</body>");
		pw.print("<html>");
		
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp); // 코드 중복을 막기 위해 post 요청이 들어올때 doGet()을 호출해준다.
	}

}
