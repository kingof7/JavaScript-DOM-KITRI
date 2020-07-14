package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example07
 */
public class Example07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Response 객체
	 * 문서 타입, 한글 : setContentType() 설정
	 * 출력 : getWriter()
	 * 쿠기 저장(설정) 기능, 헤더 설정(파일업로드시) 기능
	 * 페이지 이동 : sendRedirect
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		System.out.println(id + " " + pwd);
		
		String dbId = "abc123";
		String dbPwd = "abc123";
		
		//URL, URI 둘다 쓸 수 있다.(다음 경우에는 URI를 사용하였다.)
		if (id.equals(dbId) && pwd.equals(dbPwd)) {
			// sendRedirect를 이용해서 다른 페이지로 이동했을 때 클라이언트 측에서
			// 파라미터로 보내준 데이터는 이런식으로는 같이 넘길 수 없다.
			// setAttribute를 이용해서 다시 request객체에 심어주어 같이 넘겨주어야한다.
			// 그 방법은 다음에 배우도록 한다.
			response.sendRedirect("http://localhost:8080/webTesting/com/java/servlet/Example07_Success");
		} else {
			response.sendRedirect("http://localhost:8080/webTesting/com/java/servlet/Example07_Fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
