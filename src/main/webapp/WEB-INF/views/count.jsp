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
	<section>
		<h1>Nu ska vi räkna matte</h1>
		<br>
		<br>
		
	<div id="toCount">
	<h1>${toCount}</h1>
	</div>  
	<div>
		<form action="submit" method="post" id="submitAnswer">
			<input name="answer" id="answerSubmit">
			<input type="submit" value="Rätta" >
			<br>
			<h2>${resultAnswer}</h2>
			<h2>${noOfTrials}</h2>
		</form>
	</div>
	
	</section>
	<script type="text/javascript"> document.submitAnswer.answerSubmit.focus();</script>
</body>
</html>