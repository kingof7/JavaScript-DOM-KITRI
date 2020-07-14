package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09_CookieSet
 */
public class Example09_CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] godness = request.getParameterValues("mankind"); //배열타입으로 name 받기 (이미지가 3개니까)
		System.out.println(godness.length);
		//sessionScope : context(webTesting)안에 모든 page에서 공유
		//response : 쿠키 설정(저장), request: 쿠키 읽기
		
		if(godness.length !=0) {
			for(int i=0;i<godness.length;i++) {
				// key, value
				String key = "godness" + (i+1);
				String value = godness[i];
				System.out.println(key + "\t" + value);
				
				//장바구니는 별로 중요한 정보가 아니므로 쿠키방식으로 저장(클라이언트에)
				Cookie cookie = new Cookie(key, value);
				cookie.setMaxAge(60*60*24); //10분	//초*분*시*일 (60*60*24*365) = 1년 //앞에께 다채워지면 뒤에걸 그냥 읽으면됨( 단위는 초)
				response.addCookie(cookie);
			}
		}
				
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<html>");
				out.print("<head><title></title></head>");
				out.print("<body>");
				
				out.print("<script type='text/javascript'>");
				out.print("alert('장바구니에 담겼습니다.');"); //세미콜론 2번임
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
