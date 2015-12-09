<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.css">
<link rel="stylesheet" href="../resources/css/style.css">
<title>Spelsida</title>
<script type="text/javascript">

 var numbersOnly = /^\d+$/;
 function testInputData(myfield, restrictionType) {

	  var myData = document.getElementById(myfield).value;
	  if(myData!==''){
	   if(restrictionType.test(myData)){
	   }else{
	    alert('Your data input is invalid!');
	   }
	  }else{
	   alert('Please enter data!');
	  }
	  return;
	    
	 }
	 </script>
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
		<form action="submit" method="post" id="submitAnswer" onSubmit="return testInputData('answerSubmit',numbersOnly);">
			<input type="number" name="answer" id="answerSubmit">
			<input type="submit" value="Rätta" >
			<br>
			<h2>${resultAnswer}</h2>
			Antal försök:
			<h2>${noOfTrials}</h2>
			Antal rätt:
			<h2>${noOfCorrectAnswers}</h2>
		</form>
	</div>
	
	</section>
	<script type="text/javascript"> document.submitAnswer.answerSubmit.focus();</script>
</body>
</html>