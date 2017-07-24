<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.jport.bank.Question"%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, intial-scale=1">
<title>Quest-Results</title>
<link rel="shortcut icon" type="image/x-icon" href="javajuggler.ico" />
<link rel="stylesheet" href="bootstrap.css" >


</head>
<body style="background-color: #e3e3e3">

<h1 align="center" style="background-color:black;color:white">	 <img src="epam.png" class="pull-left">Java Competence</h1>
<h2 align='center' > ${user} You are done with your test</h2>
<div class="container" style="width:700px;" >
<hr/>
<div class="panel panel-primary" style="border-color:white;border-style: outset;">            
                    <div class="panel-heading"> 
                         <h4> Assessment Evaluation Sheet</h4>
                    </div>
                    <div class="panel-body" >
                    <table class="table table-stripped table-bordered">
                      <thead>
                                  <tr><th> Question</th><th>Option</th><th>Outcome</th></tr>
                      </thead>
<%
//HashMap responses = (HashMap) application.getAttribute("response");
HashMap responses = (HashMap) session.getAttribute("uresponse");
//ArrayList list = (ArrayList) application.getAttribute("qlist");
ArrayList list = (ArrayList) session.getAttribute("qlist");
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
	  //String resp = (String) responses.get(key);
	  //int intResp = Integer.parseInt(resp);
	 
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
         out.println("<table class='table table-striped'>");
		  double total = 55;//(rightCount + wrongCount);
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
		 out.println("<tr><td>Score:</td><td>"+ ((int)(Math.round(percentage))) +"</td><td>Result</td><td >"+result+"</td><td rowspan='2'>"+(message) +"</td></tr>");
		 
		 out.println("</table>");
		 out.println("</body></html>");
		 
		 session.invalidate();
		 
		 
         %> 

</table>
</div>
</div>
</div>
</body>
</html>