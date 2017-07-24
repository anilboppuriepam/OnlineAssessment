package com.jport.bridge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jport.bank.Question;

/**
 * Servlet implementation class ForwardServlet
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwardServlet() {
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
		HttpSession session = request.getSession();
		ArrayList list = null;
		String qidStr = request.getParameter("qbid");
		int navCount = (Integer) session.getAttribute("navCount");
		int nextCount = (Integer) session.getAttribute("nextCount");
		int prevCount = (Integer) session.getAttribute("prevCount");

		System.out.println("Prev  = " + prevCount);
		System.out.println("navCount  = " + navCount);
		System.out.println("nextCount = " + nextCount);
		// navCount total questions you answered and navigated
		// nextCount total questions you moved next after previous button is
		// pressed

		if (navCount == nextCount) {

			ServletContext context = getServletContext();
			RequestDispatcher disp = context
					.getRequestDispatcher("/question.jsp");
			disp.forward(request, response);
		} else if (qidStr != null && qidStr.length() > 0) {

			int qbid = Integer.parseInt(qidStr);
			HashMap responses = (HashMap) session.getAttribute("uresponse");
			list = (ArrayList) session.getAttribute("qlist");
			Question question = (Question) list.get(qbid);
			session.setAttribute("qbid", qbid + 1);
			session.setAttribute("bank", question);
			nextCount++;
			session.setAttribute("nextCount", nextCount);
			ServletContext context = getServletContext();
			RequestDispatcher disp = context
					.getRequestDispatcher("/question.jsp");
			disp.forward(request, response);
		}
	}
}
