package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09_CookieDel
 */
public class Example09_CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(int i=0;i<cookies.length;i++) {
				cookies[i].setMaxAge(0); // 쿠키설정을 0으로
				response.addCookie(cookies[i]);
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니를 비웠습니다.');"); //세미콜론 2번임
		out.print("location.href='http://localhost:8181/webTesting/Servlet/09_Example.html';"); //처음화면으로 되돌아가기
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
