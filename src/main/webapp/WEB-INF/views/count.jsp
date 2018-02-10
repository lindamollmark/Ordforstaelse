<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<img src="../resources/images/sideWords.jpg">
		</div>
	</aside>
	<aside id="right">
		<div>
			<img src="../resources/images/sideWords.jpg">
		</div>
	</aside>
	<nav>

		<table>

				<tr>
				<th><h4>Resultat</h4>
				</tr>
				<tr>
					<th>Tabell</th>
					<th>Poäng</th>
				</tr>
				<c:forEach var="r" items="${resultlist}">
				<tr>
					<td>${r.letter}</td>
					<td>${r.score}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="returnButtons">
			<input type="button" onclick="location.href='/'" value="Börja om">
				<input type="button" onclick="location.href='/gameSite/'" value="Välj ny bokstav">
		</div>

	</nav>

	<section>
		<h1>Nu ska vi lära oss ord ${player.name}</h1>
		<br> <br>

		<div id="words">
			<h1>${words.get(0).word}</h1>
		</div>
		<div>
			<form action="submit" method="post" id="submitAnswer">
				<input type="hidden" name="id" value="${words.get(0).id}">
				<textarea name="answer" id="answerSubmit" cols="30" rows="2"></textarea>
				<input type="submit" value="Rätta"> <br>
				<h2>${resultAnswer}</h2>
				Antal försök:

				<h2>${resultService.numberOfTrials}</h2>
				Antal rätt:
				<h2>${resultService.numberOfCorrectAnswers}</h2>

			</form>
		</div>

	</section>
	<script type="text/javascript">
		document.submitAnswer.answerSubmit.focus();
	</script>
</body>
</html>