<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>

<html lang="en">
    <body>
        <h2>XKCD in JSP</h2>
        <br/>
        <img src="${todaysComicUrl}">

        <br/>

        <c:if test="${userBean.isSignedIn()}">
            Note: you are signed in as ${userBean.userName} since ${userBean.signInDate}
        </c:if>
    </body>
</html>
