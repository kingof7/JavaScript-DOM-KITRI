package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example08_
 */

public class Example08_ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example08_() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message"); // 파라미터 타고 넘어옴, 메시지 받음
		System.out.println(message);

		response.setContentType("text/html;charset=utf-8"); // 응답
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		request.setAttribute("name", "홍길동"); // 파라미터타고 넘어오는게 아니고, 데이터 추가 해줌
		request.setAttribute("phone", "010-123-1234");

		RequestDispatcher rd = request.getRequestDispatcher("/com/java/servlet/Example08_Sub"); // 넘어갈곳, path니까
																								// 패키지명부터다써줌 // 인터페이스형
		rd.include(request, response); // 웹에서 Example08_Sub로 req, resp 던짐

		out.print("<hr color='red' width='600px'/>");
		out.print("<h3> include는 다시 돌아온다. 제어권을 넘겨주지 않는다. </h3>");
		out.print("<h3> 서블릿에서 데이터는 생명주기 : pageScope, requestScope, sessionScope, applicationScope이다 </h3>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message"); // 파라미터 타고 넘어옴, 메시지 받음
		System.out.println(message);

		response.setContentType("text/html;charset=utf-8"); // 응답
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		request.setAttribute("name", "홍길동"); // 파라미터타고 넘어오는게 아니고, 데이터 추가 해줌
		request.setAttribute("phone", "010-123-1234");

		RequestDispatcher rd = request.getRequestDispatcher("/com/java/servlet/Example08_Sub"); // 넘어갈곳, path니까
																								// 패키지명부터다써줌 // 인터페이스형
		rd.forward(request, response); // 웹에서 Example08_Sub로 req, resp 던짐 ,안돌아옴

		// rd.include가 돌아온다면 이 아래라인이 출력됨
		
		out.print("<hr color='red' width='600px'/>");
		out.print("<h3> include는 다시 돌아온다. 제어권을 넘겨주지 않는다. </h3>");
		out.print("<h3> 서블릿에서 데이터는 생명주기 : pageScope, requestScope, sessionScope, applicationScope이다 </h3>");
		out.print("</body>");
		out.print("</html>");
	}


}