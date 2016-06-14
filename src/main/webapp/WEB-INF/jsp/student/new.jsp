<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<pt:pagetemplate title="New Student">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/student/new"
               modelAttribute="newStudent" cssClass="form-horizontal" id="form">
        <div class="form-group ${firstname_error?'has-error':''}">
            <form:label path="firstname" cssClass="col-sm-2 control-label">First name</form:label>
            <div class="col-sm-10">
                <form:input path="firstname" type="text" name="firstname" cssClass="form-control"/>
                <form:errors path="firstname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${lastname_error?'has-error':''}">
            <form:label path="lastname" cssClass="col-sm-2 control-label">Last name</form:label>
            <div class="col-sm-10">
                <form:input path="lastname" type="text" name="lastname" cssClass="form-control"/>
                <form:errors path="lastname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${birthdate_error?'has-error':''}">
            <form:label path="birthdate" cssClass="col-sm-2 control-label">Birth date (dd.mm.yyyy)</form:label>
            <div class="col-sm-10">
                <form:input path="birthdate" type="text" name="birthdate"  id="birthdate" cssClass="form-control" />
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
    <%--<script>--%>
        <%--$(function() {--%>

            <%--$("#form").validate({--%>
                <%--rules: {--%>
                    <%--firstname: {--%>
                        <%--required: true,--%>
                        <%--lettersonly: true--%>
                    <%--},--%>
                    <%--lastname: {--%>
                        <%--required: true,--%>
                        <%--lettersonly: true--%>
                    <%--}--%>
                <%--},--%>
                <%--messages: {--%>
                    <%--firstname: {--%>
                        <%--required: 'First name cannot be empty.aaa',--%>
                        <%--lettersonly: 'First name cannot contain any numberaaa'--%>
                    <%--},--%>
                    <%--lastname: {--%>
                        <%--required: 'Last name cannot be empty.aaa',--%>
                        <%--lettersonly: 'Last name cannot contain any numberaaa'--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>

        <%--});--%>
    <%--</script>--%>
    <%--<script>--%>
        <%--$("#form").validate();--%>
    <%--</script>--%>
</jsp:attribute>
</pt:pagetemplate>
