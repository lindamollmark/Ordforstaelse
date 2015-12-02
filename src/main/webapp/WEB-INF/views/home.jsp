<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

<head>
<link rel="stylesheet" href="resources/css/normalize.css">
<link rel="stylesheet" href="resources/css/style.css">
<title>Start</title>
</head>
<body>
<aside id="left">
		<div>
			<img  src="resources/images/sideNumbers.jpg">
		</div>
	</aside>
	<aside id="right">
		 <div>
			<img  src="resources/images/sideNumbers.jpg">
		</div> 
	</aside>
	<section>
		<h1>Välkommen till mattesidan!</h1>
		<form action="gameSite/" method="post">
		<input type="submit" value="Räkna matte"/>
		</form>
	
	<P>The time on the server is ${serverTime}.</P>
	</section>
</body>
</html>
