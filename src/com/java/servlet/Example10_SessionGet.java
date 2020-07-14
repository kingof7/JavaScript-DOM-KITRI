package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example10_SessionGet
 */

public class Example10_SessionGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example10_SessionGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession() == null) {
			
		HttpSession session = request.getSession();
		
		if(!session.isNew()) {
			String id = (String) session.getAttribute("id"); // Object -> String 다운캐스팅
			String pwd = (String) session.getAttribute("pwd");
			
			System.out.println(id + "\t" + pwd + "\t" + session.getId()); // 서버에서 세션 아이디도 부여
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head><title></title></head>");
			out.print("<body>");
						
			out.print("<h3>"+id+"</h3>"); 
			out.print("<h3>"+pwd+"</h3>"); 
			out.print("</body>");
			out.print("</html>");
			out.close();
			
		}
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
