<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>XKCD Range</title>
</head>
<body>

<table>
    <tbody>
        <c:forEach items="${range}" var="comic">
            <tr>
                <td>${comic.num}</td>
                <td><img src="${comic.img}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
