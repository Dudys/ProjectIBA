<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<pt:pagetemplate title="New Student">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/controller/student/new"
               modelAttribute="newStudent" cssClass="form-horizontal">
        <div class="form-group ${firstname_error?'has-error':''}">
            <form:label path="firstname" cssClass="col-sm-2 control-label">First name</form:label>
            <div class="col-sm-10">
                <form:input path="firstname" cssClass="form-control"/>
                <form:errors path="firstname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${lastname_error?'has-error':''}">
            <form:label path="lastname" cssClass="col-sm-2 control-label">Last name</form:label>
            <div class="col-sm-10">
                <form:input path="lastname" cssClass="form-control"/>
                <form:errors path="lastname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${birthdate_error?'has-error':''}">
            <form:label path="birthdate" cssClass="col-sm-2 control-label">Birth date (dd.mm.yyyy)</form:label>
            <div class="col-sm-10">
                <form:input path="birthdate" cssClass="form-control"/>
                <form:errors path="birthdate" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="sex" cssClass="col-sm-2 control-label">Sex</form:label>
            <div class="col-sm-10">
                <form:radiobutton path="sex" value="true"/> man
                <form:radiobutton path="sex" value="false"/> woman
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Create student</button>
    </form:form>
</jsp:attribute>
</pt:pagetemplate>
