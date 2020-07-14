package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author KITRI
 * HTML과 JAVA를 연결해야하는데, 그 매개체는 서블릿 JSP
 * HttpServlet을 상속받은 클래스가 서블릿이 되는것임
 * 
 */
public class Example01 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//서버 메모리: Container(서버 메모리)에 Content 단위로 올라간다.
	//각각의 Content 안에 Context(webTesting pjt)
	public Example01() {
		super(); // 상위 클래스 기본 생성자 호출
	}
	//서버는 파일단위로 메모리에 하나씩 올라가는 것의 집합
	//프로젝트는 서버에 프로젝트의 파일단위로 올라감 : 컨테이너(서버) 안에 컨텍스트(=프로젝트)하나가 들어옴
	//작업 디렉터리(프로젝트 디렉터리)와 서버디렉터리(톰켓안에)는 다르다
	//*** doGet()과 destory()는 없으면 디폴트 값으로 실행한다.
	
	//생명주기 - 초기화(init) - 서비스 - 소멸
	public void init() {	//1.초기화 (메모리에 있는지 없는지)
		System.out.println("서블릿 파일 초기화(처음 요청시 단 한번)");
	}
	
	//서비스 메서드(요청) //2. 호출(웹브라우저가 호출)
	public void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//서비스 - get, post 함수 호출
		doGet(request, response); // 3. doGet()
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("!!!!서블릿 내용 doGet함수입니다.");
		
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies.length);
	}
	
	public void destory() { // 4. 
		//소멸
		System.out.println("서블릿 파일 소멸");
	}
}
