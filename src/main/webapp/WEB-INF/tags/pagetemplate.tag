<%@ tag pageEncoding="UTF-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="${pageContext.request.locale}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Project IBA</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

    <jsp:invoke fragment="head"/>
</head>
<body>

<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/student">Project IBA</a>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/student">Home</a>
        </div>
    </div>
</nav>

<div class="container">

    <c:if test="${not empty alert_success}">
        <div class="alert alert-success fade in" role="alert">
            <c:out value="${alert_success}"/>
        </div>
    </c:if>

    <div class="container">
        <div class="page-header">
            <c:if test="${not empty title}">
                <h1><c:out value="${title}"/></h1>
            </c:if>
        </div>
    </div>

    <jsp:invoke fragment="body"/>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-2.1.3.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <spring:url value="/resources/js/validation.js" var="validationJS"/>
    <spring:url value="/resources/js/datepicker.js" var="datepickerJS"/>
    <script src="${validationJS}"></script>
    <script src="${datepickerJS}"></script>
</div>
</body>
</html>