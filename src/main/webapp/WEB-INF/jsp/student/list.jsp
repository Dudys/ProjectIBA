<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<pt:pagetemplate title="Student">
<jsp:attribute name="body">

    <a href="${pageContext.request.contextPath}/student/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        New student
    </a>

    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Birth date</th>
                <th>Sex</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.id}"/></td>
                    <td><c:out value="${student.firstname}"/></td>
                    <td><c:out value="${student.lastname}"/></td>
                    <td><joda:format value="${student.birthdate}" style="M-"/></td>
                    <td>
                        <c:if test="${student.sex}">Man</c:if>
                        <c:if test="${!student.sex}">Woman</c:if>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/student/detail/${student.id}" class="btn btn-primary">Detail</a>
                        <a href="${pageContext.request.contextPath}/student/update/${student.id}" class="btn btn-primary">Update</a>
                        <form method="post" action="${pageContext.request.contextPath}/student/delete/${student.id}">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</pt:pagetemplate>
