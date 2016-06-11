<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project IBA</title>
</head>
<body>

    <c:if test="${not empty error}">${error}</c:if>
    <c:if test="${empty error}">
        <c:forEach var="i" begin="1" end="${x}"><div>Hello IBA!</div></c:forEach>
    </c:if>
</body>
</html>
