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
			<img src="../resources/images/sideWords.jpg">
		</div>
	</aside>
	<aside id="right">
		<div>
			<img src="../resources/images/sideWords.jpg">
		</div>
	</aside>
<nav>
<input class="returnButtons" type="button"  onclick="location.href='/'" value="Börja om" >
	</nav>
	
	<section>
		<h1>Vilken bokstav vill du öva på ${player.name}?</h1>
		<div>
			<form action="count" method="post" >
				<INPUT TYPE="image" SRC="../resources/images/h.jpg" id="letter"
					ALT="SUBMIT!" name="letter" value="h">
			</form>
		</div>
	</section>
</body>
</html>