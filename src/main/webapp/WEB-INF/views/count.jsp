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
<input type="button"  onclick="location.href='/math/'" value="B�rja om" >
<input type="button"  onclick="location.href='/math/gameSite/'" value="V�lj ny tabell" >
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
	<section>
		<h1>Nu ska vi r�kna matte ${playerName}</h1>
		<br>
		<br>
		
	<div id="toCount">
	<h1>${toCount}</h1>
	</div>  
	<div>
		<form action="submit" method="post" id="submitAnswer">
			<input type="number" name="answer" id="answerSubmit">
			<input type="submit" value="R�tta" >
			<br>
			<h2>${resultAnswer}</h2>
			Antal f�rs�k:
			<h2>${noOfTrials}</h2>
			Antal r�tt:
			<h2>${noOfCorrectAnswers}</h2>
		</form>
	</div>
	
	</section>
	<script type="text/javascript"> document.submitAnswer.answerSubmit.focus();</script>
</body>
</html>