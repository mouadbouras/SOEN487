<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In with Spotify</title>
    </head>
    <body>
        <h1>Feeds!</h1>
        <jsp:include page="/feeds" />
        <a href="signin">SIGN IN TO SPOTIFY</a>
        <br>
        <c:forEach items="${playlists}" var="pl">
            ${pl.name} <br><br>
        </c:forEach>
    </body>
</html>
