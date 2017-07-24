package com.jport.bridge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jport.alarm.MyTimer;
import com.jport.bank.Question;
import com.jport.bank.ReviewQuestions;

/**
 * Servlet implementation class Next
 */
public class Next extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Integer> responses = new HashMap<Integer, Integer>();
	private HashMap<Integer, Question> review = new HashMap<Integer, Question>();
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Next() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String btnPrev = request.getParameter("Previous");
		String btnForward = request.getParameter("Forward");
		String reviewQno = request.getParameter("qno");
		String reviewAll = request.getParameter("ReviewAll");
		String btnNext = request.getParameter("Next");
		String btnFinish = request.getParameter("Finish");
		String qbidStr = request.getParameter("qbid");

		String userChoiceStr = request.getParameter("userChoice");
		if (btnPrev != null) {

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/previous");
			dispatcher.forward(request, response);
		} else if (btnForward != null && Integer.parseInt(qbidStr) < 5) {

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/forward");
			dispatcher.forward(request, response);
		} else if (reviewQno != null) {
			HashMap reviewMap = (HashMap) session.getAttribute("reviewBank");
			System.out.println("Mapv size " + reviewMap.size());
			Question reviewQuestion = (Question) reviewMap.get(Integer
					.parseInt(reviewQno));
			// System.out.println(reviewQno+":>"+ reviewQuestion);
			session.setAttribute("reviewQuestion", reviewQuestion);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/review.jsp");
			dispatcher.forward(request, response);
		} else if (reviewAll != null) { // (reviewQno != null) {
			// HashMap reviewMap= (HashMap) session.getAttribute("reviewBank");
			// System.out.println("Mapv size "+ reviewMap.size());
			// Question reviewQuestion = (Question)
			// reviewMap.get(Integer.parseInt(reviewQno));
			// System.out.println(reviewQno+":>"+ reviewQuestion);
			// session.setAttribute("reviewQuestion",reviewQuestion);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/review.jsp");
			dispatcher.forward(request, response);
		}

		else if (btnNext != null && userChoiceStr == null) { // this code
																// process
																// "Answer"
																// button, if
																// the user
																// doesn't
																// select any
																// option no
																// navigation
																// happens
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/question.jsp");
			dispatcher.forward(request, response);
		} else if (btnFinish != null) {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/fb.html");
			dispatcher.forward(request, response);

		} else { // this code actually processes an option selected by a user
					// and setups the code necessary for navigating to the next
					// question

			// String qbidStr = request.getParameter("qbid");
			String userChoiceStr2 = request.getParameter("userChoice");
			String reviewBox = request.getParameter("reviewChk");
			if (qbidStr != null && userChoiceStr2 != null) {
				int qbid = Integer.parseInt(qbidStr);
				int userChoice = Integer.parseInt(userChoiceStr2);
				responses.put(qbid, userChoice);
				session = request.getSession();
				session.setAttribute("uresponse", responses);
				// session.setAttribute("userChoice",userChoiceStr2);
				ArrayList list = (ArrayList) session.getAttribute("qlist");
				if (qbid < list.size()) {
					int count = (Integer) session.getAttribute("qcount");
					Question question = (Question) list.get(qbid);
					// System.out.println("qbid from Next button " + qbid);
					// System.out.println("question from Next button" +
					// question);
					int navCount = (Integer) session.getAttribute("navCount");
					navCount++;
					session.setAttribute("navCount", navCount);
					session.setAttribute("qbid", qbid);
					session.setAttribute("bank", question);
					// MyTimer timer = (MyTimer) session.getAttribute("timer");
					// timer.

					if (reviewBox != null) {
						Question reviewQuestion = (Question) list.get(qbid - 1);
						reviewQuestion.setUserChoice(userChoice);
						int qno = reviewQuestion.getQbid();

						review.put(qno, reviewQuestion);
						session.setAttribute("reviewBank", review);

						System.out.println("question to review " + qno);
					}

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/question.jsp");
					dispatcher.forward(request, response);
				} else {

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/fb.html");
					dispatcher.forward(request, response);
				}
			}
		}
	} // end of dopost
}// end of servlet
