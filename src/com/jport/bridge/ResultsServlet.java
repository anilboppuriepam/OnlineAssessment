package com.jport.bridge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jport.bank.Question;

/**
 * Servlet implementation class ResultsServlet
 */
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 /*HashMap responses = (HashMap) getServletContext().getAttribute("response");
		 PrintWriter out = response.getWriter();
		 
		out.println("<H2 align='center' >you are done with your test.....</h2>" );
		 out.println("<hr/>");
		 out.println("<h3> The following are your responses</h3>");
		 out.println("<table border='2'> " );
		 out.println("<thead>");
		 out.println("<th> Question#");
		 out.println("<th> Your Choice");
		 out.println("</thead>");
		 Set set = responses.keySet();
		 Iterator iter = set.iterator();
		 while(iter.hasNext()){
			 out.println("<tr>");
			  int key = (Integer) iter.next();
			  out.println("<td>"+ key +"</td> <td>"+ responses.get(key) +"</td>");
			 out.println("</tr>");
		 }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HashMap responses = (HashMap) getServletContext().getAttribute("response");
		 ArrayList list = (ArrayList) getServletContext().getAttribute("qlist");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Final Results</title>");
		 out.println("</head><body>");
		out.println("<H2 align='center' >you are done with your test.....</h2>" );
		 out.println("<hr/>");
		 out.println("<h3> The following are your responses</h3>");
		 out.println("<table border='2'> " );
		 out.println("<thead>");
		 out.println("<th> Question#");
		 out.println("<th> Your Choice");
		 out.println("<th> Result");
		 out.println("</thead>");
		 Set set = responses.keySet();
		 Iterator iter = set.iterator();
		 double wrongCount=0;
		 double rightCount = 0;
		 while(iter.hasNext()){
			 out.println("<tr>");
			  int key = (Integer) iter.next();
			 Question question = (Question)  list.get(key-1);
			  int answer =  question.getAnswer();
			  int resp = (Integer)  responses.get(key);
			  if( answer != resp){
				  wrongCount++;
			  out.println("<td>"+ key +"</td> <td>"+ resp +"</td>"+"<td> wrong </td>");
			  }
			  else{
				  rightCount++;
				  out.println("<td>"+ key +"</td> <td>"+ resp +"</td>"+"<td> correct </td>");
			  }
				  
			 out.println("</tr>");
			 
			 
		 }
		 out.println("</table>");
		 out.println("<table border='1'>");
		  double total = 54;// (rightCount + wrongCount);
		  out.println("<tr><td> Total Questions</td><td>"+ ((int)(total))+" <td> Correct Answers</td> <td>"+ ((int)rightCount) +"</td><td>In-Correct Answers</td><td>"+((int)wrongCount)+"</td></tr>");
		  System.out.println(rightCount);
		  System.out.println(wrongCount);
		  System.out.println(total);
		 double percentage = ((( rightCount * 100 )/ total ))  ;
		 String result =null;
		 String message = null;
		 if(percentage > 69){
			 result="Passed"; message="Congratulations!";
		 }
		 else{
			 result="Try again";message="Better Luck Next Time!";
		 }
		 out.println("<tr><td>Score:</td><td>"+ ((int)(Math.round(percentage))) +"</td><td>Result</td><td>"+result+"</td><td rowspan='2'>"+message+"</td></tr>");
		 
		 out.println("</table>");
		 out.println("</body></html>");
	}
         
}
