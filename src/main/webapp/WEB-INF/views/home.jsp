<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<img  src="resources/images/sideWords.jpg">
		</div>
	</aside>
	<aside id="right">
		 <div>
			<img  src="resources/images/sideWords.jpg">
		</div> 
	</aside>
	
<header></header>
<nav>
		<div class="returnButtons">
			
		</div>
	</nav>

	<section>
		<h1>Välkommen till Ordförståelse!</h1>
		<form action="gameSite/" method="post">
		<label>Vem ska testa sin ordkunskap? </label>
		<input type="text" name="name" required>
		<br>
		<br>
		<input type="submit" value="Testa mig!"/>
		</form>
		<br>
		<br>
		<br>
	<P>Du kom till oss idag ${serverTime}.</P>
	</section>
</body>
</html>
