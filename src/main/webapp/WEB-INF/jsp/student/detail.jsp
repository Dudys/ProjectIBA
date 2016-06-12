<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<my:pagetemplate title="Student detail">
<jsp:attribute name="body">

    <div class="row">
        <div class="col-xs-6">
            <h3>
                <c:out value="${student.firstname}  "/> <c:out value="${student.lastname}"/> (ID: <c:out value="${student.id}"/>)
            </h3>
            <h4><joda:format value="${student.birthdate}" style="M-"/></h4>
            <h4>
                <c:if test="${student.sex}">Man</c:if>
                <c:if test="${!student.sex}">Woman</c:if>
            </h4>
        </div>
    </div>
</jsp:attribute>
</my:pagetemplate>
