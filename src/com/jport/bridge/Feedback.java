package com.jport.bridge;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Feedback
 */
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String quality = request.getParameter("quality");
		String experience = request.getParameter("experience");
		String suggestions = request.getParameter("suggestions");

		HttpSession session = request.getSession();
		if (!session.isNew()) {

			String user = (String) session.getAttribute("user");
			System.out.println("User name from feedback.java" + user);
			int dotIndex = user.indexOf(".");
			String fname = user.substring(0, dotIndex);
			String lname = user.substring(dotIndex + 1, user.length());
			
			  try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
			  DriverManager.getConnection( "jdbc:mysql://localhost:3306/test",
			  "root", "root"); //out.println("connected.............");
			  
			  PreparedStatement st =
			  con.prepareStatement("insert into feedback values(?,?,?,?,?)");
			  st.setString(1, fname); st.setString(2,lname);
			  st.setString(3,quality); st.setString(4, experience);
			  st.setString(5,suggestions); int count = st.executeUpdate();
			  if(count > 0){ RequestDispatcher disp =
			  getServletContext().getRequestDispatcher("/results.jsp");
			 con.close(); disp.forward(request, response); } }catch(Exception
			  e){
			  
			  e.printStackTrace(); }
			 }

	}

}
