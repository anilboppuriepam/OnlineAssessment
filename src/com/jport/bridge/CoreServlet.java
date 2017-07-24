package com.jport.bridge;

import com.jport.alarm.MyTimer;

import com.jport.threads.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jport.bank.Question;

import java.sql.Statement;

/**
 * Servlet implementation class CoreServlet
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean flag = false;
	ArrayList<Question> list = new ArrayList<Question>();
	private int prevCount = 0;
	private int navCount = 0;
	private int nextCount = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int timeLeft = 0;
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		HttpSession session = null;
		long creationTime = 0;
		session = request.getSession();
		if ((fname != null && fname.length() > 0)
				&& (lname != null && lname.length() > 0)) {
			if (session.isNew()) {
				// session.setMaxInactiveInterval(60 * 5000);
				// creationTime = session.getCreationTime();
				session.setAttribute("user", fname + "." + lname);

			}
			if (!flag) {
				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/test", "root", "root");
					out.println("connected.............");

					Statement st = con.createStatement();
					String sql = "select * from qbank where qbid <=5";
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						Question question = new Question();
						question.setQbid(rs.getInt(1));
						question.setQuestion(rs.getString(2));
						question.setChoice1(rs.getString(3));
						question.setChoice2(rs.getString(4));
						question.setChoice3(rs.getString(5));
						question.setChoice4(rs.getString(6));
						question.setChoice5(rs.getString(7));
						question.setAnswer(rs.getInt(8));
						question.setTopic(rs.getString(9));
						question.setLevel(rs.getString(10));
						list.add(question);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				flag = true;
			}
			int count = 1;
			// System.out.println(list);
			// System.out.println(creationTime);
			// session.setAttribute("start", creationTime);

			session.setAttribute("prevCount", prevCount);
			session.setAttribute("navCount", navCount);
			session.setAttribute("nextCount", nextCount);
			session.setAttribute("qlist", list);
			session.setAttribute("bank", list.get(0));
			session.setAttribute("qcount", count);
			MyTimer mtimer = new MyTimer();
			Timer timer = new Timer();
			timer.schedule(mtimer, 60 * 1000, 60 * 1000);
			session.setAttribute("timer", mtimer);
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context
					.getRequestDispatcher("/question.jsp");
			dispatcher.forward(request, response);
		}
	}
}
