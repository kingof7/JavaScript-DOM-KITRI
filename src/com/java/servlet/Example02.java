package com.java.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example02 extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	
	// init() -> service() -> doGet()호출 -> destory()
	
	//웹 브라우저가 요청을 doGet에 던져줌 == 웹브라우저에게 요청을 받음
	//요청이라면 request의 메소드를 통해 doGet에 객체를 던져줌
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("doGetFunction------");
		String su = request.getParameter("su"); //외부에서 넘어오는 파라미터는 모두 String 타입
		
		//파싱 : 데이터 추출, 가공
		//문자열 -> 정수 (요청이 들어올 때)
		int value = Integer.parseInt(su);
		String a = String.valueOf(value);
		
		//정수 -> 문자열(응답할 때)
		Integer i = value;
		String b = i.toString();
		System.out.println(a +"\t"+ b);
		
		Cookie[] cookies = request.getCookies();
		System.out.println("쿠키 갯수: " + cookies.length);
	}
	
	//요청 -> Json(key,value) -> Arraylist + map -> 응답
	//웹페이지요청 : 쓰레드 -> 톰캣이 내부에서 다해줌
	
	
}
