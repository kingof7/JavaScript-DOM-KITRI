package com.java.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * request, response 객체
	 * request객체 - 사용자 요청(기능이 많다.response에 비해)
	 * 한글 Encoding 기능
	 * 파라미터 읽기 기능
	 * 서버와 관련된 정보 읽기
	 * 웹브라우저 관련 정보 읽기 기능
	 * 헤더 읽기 기능
	 * 쿠키 읽기 기능
	 * 속성처리 기능
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩(UTF-8) 설정, 한글가능
		request.setCharacterEncoding("utf-8");
		
		// su 파라미터 가져오기
		int su = Integer.parseInt(request.getParameter("su"));	
		System.out.println(su);
		
		// 서버 관련 정보 읽기
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		System.out.println("서버이름 : " + serverName);
		System.out.println("서버포트 : " + serverPort);
		
		// URL, URI, ContextPath, ServletPath는 진짜 중요중요 정말 많이 쓴다.
		// 파라미터 가져오는건 하도 많이 쓰니 까먹지 않겠지만 다음 기능들은 잘 익혀두자.
		
		// <경로 정의>
		// URL:http~서블릿까지
		// URI:컨텍스트부터~서블릿까지
		// ContextPath:프로젝트경로
		// ServletPath:현재실행중인 서블릿의 풀패키지명
		
		// Uniform Resource Location(URL), http://localhost:8181/webTesting/com/java/servlet/Example06
		StringBuffer url = request.getRequestURL(); 
		// Uniform Resource Identifier(URI), /webTesting/com/java/servlet/Example06
		// 해당 컨텍스트패스부터 시작해서 서블릿까지의 경로
		String uri = request.getRequestURI(); //프로젝트이름부터 하위경로까지 주소
		// URI , URL 의 차이를 확실히 알고가자.
		String contextPath = request.getContextPath(); // /webTesting(프로젝트)
		String servletPath = request.getServletPath();// /com/java/servlet/Example06
		System.out.println("url : "+url);
		System.out.println("uri : "+uri);
		System.out.println("contextPath : "+contextPath);
		System.out.println("servletPath : "+servletPath);
		System.out.println("요청방식 : "+request.getMethod());
		
		// 클라이언트 및 웹브라우저 관련 정보 읽기(자주 쓰지는 않는다)
		System.out.println("요청프로토콜: " + request.getProtocol());
		System.out.println("클라이언트 주소: " + request.getRemoteAddr()); // 로컬서버에서 동작하면 클라 주소가 나오지 않는다.
		System.out.println("클라이언트 포트: " + request.getRemotePort());
		
		// 헤더 읽기, HashMap의 대해 알고접근하자.(Enumeration과 비슷)
		// 나중에 header의 정보를 바꿔 response하는 법을 배울것이다. 이종화바보
		Enumeration<String> header = request.getHeaderNames();
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
			System.out.println("key : " + key + ", value : "+ value);
		}
		//쿠키 읽기(request) - 쿠키 저장(Response)
		//속성 처리(session과 같은)
		// html -> servlet, servlet -> servlet 데이터가 이동할 때 모두 Request 객체를 타고 이동한다.
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
