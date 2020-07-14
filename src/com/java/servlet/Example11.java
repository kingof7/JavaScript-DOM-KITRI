package com.java.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example11
 */
@WebServlet("/Example11")
public class Example11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 세션 생성 시간
		long createTime = session.getCreationTime();
		
		// 세션 마지막 접근시간
		long lastTime = session.getLastAccessedTime();
	
		
		//  사이트 머문시간 = 생성시간 - 마지막 접근시간
		long userTime = (lastTime - createTime)/6000;
					
		
		Date date = new Date(createTime);	
		System.out.println("세션 생성시간 : " + createTime + "\t" + date);		
		System.out.println("마지막 접근시간: " + lastTime + "\t" + new Date(lastTime).toString());
		System.out.println("머문시간 : " + userTime);
		
		/*
		 * if(userTime < 5) { session.invalidate();
		 * 
		 * }
		 */
		int max = session.getMaxInactiveInterval() / 60; // 30분 부여
		System.out.println(max);
		
		//액션이 없을 경우 세션 시간 설정으로 자동 종료
		session.setMaxInactiveInterval(60);
		if(request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효합니다.");
		}else {
			System.out.println("세션 아이디가 유효하지 않습니다.");
		}
		//session.setMaxInactiveInterval(60*20);	// <- 구문이 없다면 디폴트값이 30분임
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
