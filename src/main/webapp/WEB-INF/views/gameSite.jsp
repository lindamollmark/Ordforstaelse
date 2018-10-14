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
<input class="returnButtons" type="button"  onclick="location.href='/'" value="Börja om" >
	</nav>
	
	<section>
		<h1>Vilken bokstav vill du öva på ${player.name}?</h1>
		<div>
			<form action="count" method="post" >
				<button style="border:none" type="submit" name="letter" value="A"><img src="../resources/images/amanda.jpg">
				</button><form action="count" method="post" >
				<button style="border:none" type="submit" name="letter" value="J"><img src="../resources/images/joel2.jpg"></button>
				<button style="border:none" type="submit" name="letter" value="S"><img src="../resources/images/skiing.jpg"></button>

			<%--&lt;%&ndash;	<INPUT TYPE="image" SRC="../resources/images/b.jpg" id="letter"--%>
					   <%--ALT="SUBMIT!" name="letter" value="b"> &ndash;%&gt;--%>
				<%--<INPUT TYPE="image" SRC="../resources/images/e.jpg" id="letter"--%>
					   <%--ALT="SUBMIT!" name="letter" value="e">--%>
				<%--<INPUT TYPE="image" SRC="../resources/images/g.jpg" id="letter"--%>
					   <%--ALT="SUBMIT!" name="letter" value="g">--%>
				<%--<INPUT TYPE="image" SRC="../resources/images/h.jpg" id="letter"--%>
					<%--ALT="SUBMIT!" name="letter" value="h">--%>
				<%--<INPUT TYPE="image" SRC="../resources/images/a.jpg" id="letter"--%>
					<%--ALT="SUBMIT!" name="letter" value="a">--%>
				<%--<INPUT TYPE="image" SRC="../resources/images/mix.png" id="letter"--%>
					   <%--ALT="SUBMIT!" name="letter" value="mix">--%>

			</form>
		</div>
	</section>
</body>
</html>