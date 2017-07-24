<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.jport.bank.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, intial-scale=1">
<title>Quest-Review</title>
<link rel="stylesheet" href="bootstrap.css">
<link rel="shortcut icon" type="image/x-icon" href="javajuggler.ico" />

<script type="text/javascript" language="javascript">
	function validate() {
	
		   var status = false;
			var radios = new Array();
			radios = document.getElementsByName('userChoice');
			var val;
			for (var i = 0; i < radios.length; i++) {
				if (radios[i].checked) {
					val = radios[i].value;
					alert(val);
				}
			}
	
			if (val == "") {
				status= false;
				alert("Please choose one option!");
			} else {
				
				status= true;
			}
		return status;
	}
</script>
</head>
<body style="background-color: #e3e3e3">
	<div>
		<h1 align="center" style="background-color: black; color: white;">
			<img src="epam.png" class="pull-left" />Java Competence - Review
			Page
		</h1>
	</div>
	<div class="container" style="width: 700px;">


		<div>
			<form name="myform" method="post" action="review" onsubmit="validate();">

				<div class="panel panel-primary"
					style="border-color: white; border-style: outset;">
					<div class="panel-heading">
						Question #: ${reviewQuestion.qbid } <input type="hidden"
							name="qbid" value="${reviewQuestion.qbid }">
						<div class="pull-right">${user}</div>

					</div>
					<div class="panel-body">
						<table class="table table-bordered">

							<thead>

								<tr>
									<td>
										<h4>Q#</h4>
									</td>
									<td><h4>
											Question: <span class="pull-right">Your Previous
												Choice : ${reviewQuestion.userChoice}</span>
										</h4></td>
								</tr>
							</thead>


							<tr>
								<td><h4 style="color: red">${reviewQuestion.qbid}</h4></td>
								<td><b>${reviewQuestion.question}</b></td>
							</tr>
							<tr>
								<td>1)</td>
								<td><input type="radio" name="userChoice" value="1" />${reviewQuestion.choice1}</td>
							</tr>
							<tr>
								<td>2)</td>
								<td><input type="radio" name="userChoice" value="2" />${reviewQuestion.choice2}</td>
							</tr>
							<tr>
								<td>3)</td>
								<td><input type="radio" name="userChoice" value="3" />${reviewQuestion.choice3}</td>
							</tr>
							<tr>
								<td>4)</td>
								<td><input type="radio" name="userChoice" value="4" />${reviewQuestion.choice4}</td>
							</tr>
							<tr>
								<td>5)</td>
								<td><input type="radio" name="userChoice" value="5" />
									${reviewQuestion.choice5}</td>
							</tr>

						</table>
						<input type="submit" class="btn btn-primary" />
					</div>
				</div>
			</form>
		</div>
		<div class="well well-large">

			<table class="table table-warning">
				<h4>Review Questions</h4>

				<c:forEach var="qno" items="${reviewBank}">

					<tr>
						<td>Question: <a href="next?qno=${qno.key}"><span
								class="badge badge-danger">${qno.key}</span></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>