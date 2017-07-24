<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, intial-scale=1"> 
<title>Quest</title>
<link rel="stylesheet" href="bootstrap.css">
<link rel="shortcut icon" type="image/x-icon" href="javajuggler.ico" />


</head>

<body style="background-color: #e3e3e3"  >
	<h1 align="center" style="background-color: black; color: white;">
		 <img src="epam.png" class="pull-left"/>Java Competence</h1>

	<div class="container" style="width: 700px;">
		<form name="myform" method="post" action="next">

			<div class="panel panel-primary"
				style="border-color: white; border-style: outset;">
				<div class="panel-heading">
					Question #: ${bank.qbid } <input type="hidden" name="qbid"
						value="${bank.qbid }">
					<div class="pull-right">${user}</div>
					<div class="pull-right">Time Left: ${timer.totalTime}</div>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<td>Question:</td>
							<td><b>${bank.question}</b></td>

						<tr>
							<td>1)</td>
							<td><input type="radio" name="userChoice" value="1" >
								${bank.choice1}</td>
						</tr>
						<tr>
							<td>2)</td>
							<td><input type="radio" name="userChoice" value="2" >
								${bank.choice2}</td>
						</tr>
						<tr>
							<td>3)</td>
							<td><input type="radio" name="userChoice" value="3" >
								${bank.choice3}</td>
						</tr>
						<tr>
							<td>4)</td>
							<td><input type="radio" name="userChoice" value="4" >
								${bank.choice4}</td>
						</tr>
						<tr>
							<td>5)</td>
							<td><input type="radio" name="userChoice" value="5" >
								${bank.choice5}</td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							
									<td>Mark 4 Review: <input type="checkbox" name="reviewChk" /></td>
										<td><input type="submit" name="Next"  value="Answer"
								class="btn btn-success"  /></td>
									<td> <input type="submit" name="ReviewAll"  value="Review"
								class="btn btn-danger"  /></td>
						
								</tr>
							<tr>
							<td><input type="submit" name="Previous" value="Previous"
								class="btn btn-primary"  /></td>	
									<td><input type="submit" name="Forward"  value="Forward"
								class="btn btn-primary" onclick="history.forward();"  /></td>
									<td><input type="submit" name="Finish"  value="Finish"
								class="btn btn-danger"  /></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</div>
	<hr/>
	
	
</body>
</html>