<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="../resources/css/normalize.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <title>FÄRDIG</title>
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


    <div class="returnButtons">
        <input type="button" onclick="location.href='/'" value="Börja om">
        <input type="button" onclick="location.href='/gameSite/'" value="Välj ny bokstav">
    </div>

</nav>

<section>
    <h1>GRATTIS ${player.name.toUpperCase()} DU KLARADE DET!!!</h1>
    <br> <br>


    <table style="margin-right: 50%">

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
</section>
</body>
</html>
