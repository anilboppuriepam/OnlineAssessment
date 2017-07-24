package com.jport.bridge;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReviewServlet
 */
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Enumeration paramNames = request.getParameterNames();
		 * while(paramNames.hasMoreElements()){ String paramName = (String)
		 * paramNames.nextElement(); String paramValue =
		 * request.getParameter(paramName); System.out.println(paramName + "::"+
		 * paramValue); }
		 */

		// response.getWriter().println("Hello world");
		HttpSession session = request.getSession();
		HashMap review = (HashMap) session.getAttribute("reviewBank");

		if(review.size() >1 ){
		int qbid = Integer.parseInt(request.getParameter("qbid"));
		int userChoice = Integer.parseInt(request.getParameter("userChoice"));

		System.out.println("reve ans ques" + qbid);
		System.out.println("new user choice " + userChoice);

		review.remove(qbid);
		session.setAttribute("reviewBank", review);
		HashMap responses = (HashMap) session.getAttribute("uresponse");
		responses.put(qbid, userChoice);
		session.setAttribute("uresponse", responses);
		
			getServletContext().getRequestDispatcher("/review.jsp").forward(
			request, response);
	}	else if(review.size() == 1){
		int qbid = Integer.parseInt(request.getParameter("qbid"));
	int userChoice = Integer.parseInt(request.getParameter("userChoice"));

	System.out.println("reve ans ques" + qbid);
	System.out.println("new user choice " + userChoice);

	review.remove(qbid);
	session.setAttribute("reviewBank", review);
	HashMap responses = (HashMap) session.getAttribute("uresponse");
	responses.put(qbid, userChoice);
	session.setAttribute("uresponse", responses);

			getServletContext().getRequestDispatcher("/question.jsp").forward(
					request, response);
	}
	}

}
