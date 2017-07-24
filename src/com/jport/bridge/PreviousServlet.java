package com.jport.bridge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jport.bank.Question;

/**
 * Servlet implementation class PreviousServlet
 */
public class PreviousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreviousServlet() {
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
		PrintWriter out = response.getWriter();
		out.println("Ola");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= 	 request.getSession();
		ArrayList list= null;
		String qidStr = request.getParameter("qbid");
	    int prevCount = (Integer) session.getAttribute("prevCount");
		int nextCount = (Integer) session.getAttribute("nextCount");
	//	System.out.println("qno = " + qidStr);
		   int qbid=0;
		   if(qidStr != null && qidStr.length() > 0){
			   
			       qbid= Integer.parseInt(qidStr);
		   }
		// TODO Auto-generated method stub
		
		// int count = (Integer) session.getAttribute("qcount");
		// if (qbid > 0) {
		if (qbid == 1) {
			ServletContext context = getServletContext();
			RequestDispatcher disp = context
					.getRequestDispatcher("/question.jsp");
			disp.forward(request, response);
		}else if (qbid > 1) {
			 
			     if(nextCount >0){
			    	 nextCount--;
			    	 session.setAttribute("nextCount", nextCount);
			     }
				qbid = (Integer) session.getAttribute("qbid");
			//	System.out.println(qbid);
				list = (ArrayList) session.getAttribute("qlist");
				// System.out.println("Previous count " + qbid);
				Question question = (Question) list.get(qbid - 1);
				session.setAttribute("qbid", qbid - 1);
				session.setAttribute("bank", question);
                prevCount++;
				session.setAttribute("prevCount", prevCount);
				ServletContext context = getServletContext();
				RequestDispatcher disp = context
						.getRequestDispatcher("/question.jsp");
				disp.forward(request, response);
			} else if (qbid == 0) {
				// System.out.println("Previous count " + qbid);
				Question question = (Question) list.get(qbid);
				// System.out.println(question);
				prevCount++;
				session.setAttribute("prevCount", prevCount);
			     if(nextCount >0){
			    	 nextCount--;
			    	 session.setAttribute("nextCount", nextCount);
			     }
     			session.setAttribute("qbid", qbid - 1);
				session.setAttribute("bank", question);

				ServletContext context = getServletContext();
				RequestDispatcher disp = context
						.getRequestDispatcher("/question.jsp");
				disp.forward(request, response);

			}
		}

	}

