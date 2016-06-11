<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<pt:pagetemplate title="Student">
<jsp:attribute name="body">

    <div class="container">
        First name: <c:out value="${student.firstname}"/>
    </div>
    <div class="container">
        Last name: <c:out value="${student.lastname}"/>
    </div>
    <div class="container">
        Birth date: <c:out value="${student.birthdate}"/>
    </div>
    <div class="container">
        Sex: <c:if test="${student.sex}">Man</c:if> <c:if test="${!student.sex}"> Woman</c:if>
    </div>
    <div class="container">
        <a href="${pageContext.request.contextPath}/controller/student/new" class="btn btn-primary">New student</a>
    </div>

</jsp:attribute>
</pt:pagetemplate>
