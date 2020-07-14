package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example08_Sub
 */
public class Example08_Sub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example08_Sub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // req, resp 받음
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); //한글처리(웹으로부터 받음)
		String message = request.getParameter("message"); // msg 받음
		String name = (String) request.getAttribute("name");
		String phone = (String) request.getAttribute("phone");
		System.out.println("Example08_Sub: " + message);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		out.print("<h3 style='color:blue'>" + message + "</h3>");
		out.print("<h3 style='color:blue'>" + name + "</h3>");
		out.print("<h3 style='color:blue'>" + phone + "</h3>");
		
		out.print("</body>");
		out.print("</html>");
		//out.close(); //해주면 안됨, 다른 서블릿의  RequestDispatcher rd 에서 넘어온거라
		//close() include 방식에서는 스트림 닫혀서 출력 안된다. forward 된다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
