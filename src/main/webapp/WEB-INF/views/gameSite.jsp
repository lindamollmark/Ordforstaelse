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
			<img  src="../resources/images/sideNumbers.jpg">
		</div>
	</aside>
	<aside id="right">
		 <div>
			<img  src="../resources/images/sideNumbers.jpg">
		</div> 
	</aside>
	<section>
	<h1>Nu ska vi räkna matte</h1>
	<div>
	<img id="numbers"  src="../resources/images/ett.jpg" onClick="alert('Nummer 1')">
	<img id="numbers"  src="../resources/images/2.jpg" onClick="alert('Nummer 2')">
	<img id="numbers"  src="../resources/images/3.jpg" onClick="alert('Nummer 3')">
	<img id="numbers"  src="../resources/images/4.jpg" onClick="alert('Nummer 4')">
	<img  id="numbers" src="../resources/images/5.jpg" onClick="alert('Nummer 5')">
	</div>
</section>
</body>
</html>