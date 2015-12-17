<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.css">
<link rel="stylesheet" href="../resources/css/style.css">
<title>Spelsida</title>

</head>
<body>
	<aside id="left">
		<div>
			<img src="../resources/images/sideNumbers.jpg">
		</div>
	</aside>
	<aside id="right">
		<div>
			<img src="../resources/images/sideNumbers.jpg">
		</div>
	</aside>
	<nav>
		<div class="returnButtons">
			<input type="button" onclick="location.href='/math/'" value="Börja om"> 
				<input type="button" onclick="location.href='/math/gameSite/'" value="Välj ny tabell">
		</div>

		<table>
			
				<tr>
				<th><h4>Resultat</h1></h4>
				</tr>
				<tr>
					<th>Tabell</th>
					<th>Poäng</th>
				</tr>
				<c:forEach var="r" items="${resultlist}">
				<tr>
					<td>${r.chart}</td>
					<td>${r.score}</td>
				</tr>
			</c:forEach>
		</table>
	</nav>

	<section>
		<h1>Nu ska vi räkna matte ${playerName}</h1>
		<br> <br>

		<div id="toCount">
			<h1>${toCount}</h1>
		</div>
		<div>
			<form action="submit" method="post" id="submitAnswer">
				<input type="number" name="answer" id="answerSubmit"> <input
					type="submit" value="Rätta"> <br>
				<h2>${resultAnswer}</h2>
				Antal försök:
				<h2>${noOfTrials}</h2>
				Antal rätt:
				<h2>${noOfCorrectAnswers}</h2>
			</form>
		</div>

	</section>
	<script type="text/javascript">
		document.submitAnswer.answerSubmit.focus();
	</script>
</body>
</html>