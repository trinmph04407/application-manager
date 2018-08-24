<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div align="center" class="container">

		<br>
		<h1 align="center"><spring:message code="label.account.title.create"/></h1>
		<br>

		<spring:url value="/account/createAccount" var="insertAction"></spring:url>
		<form:form modelAttribute="accountCreateForm" action="${insertAction}"
			method="POST">
			<div class="input-group" style="width: 500px;">
			
			
				<div class="input-group-prepend" style="width: 500px;">
					<span style="width: 135px;" class="input-group-text" id=""><spring:message code="lable.account.name"/></span>
					<form:select path="lecturerId" class="form-control">
						<form:options items="${lecturers}" itemValue="id" itemLabel="name"></form:options>
					</form:select >
				</div>
			</div>
			<p style="color: red;text-align: center;">${exist}</p>
			<br>
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 110px;" class="input-group-text" id=""><spring:message code="lable.account.username"/></span>
				</div>
				<c:set var="usernameHasError">
					<form:errors path="username" />
				</c:set>
				<form:input class="form-control" path="username" type="text"
					cssClass="form-control ${not empty usernameHasError ? 'is-invalid' : ''} " />
				<div class="invalid-feedback">${usernameHasError}</div>

			</div>
			<br>

			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 110px;" class="input-group-text" id=""><spring:message code="lable.account.password"/></span>
				</div>
				<c:set var="passwordHasError">
					<form:errors path="password" />
				</c:set>
				<form:input class="form-control" path="password" type="password"
				cssClass="form-control ${not empty passwordHasError ? 'is-invalid' : ''} "  />
				<div class="invalid-feedback">${passwordHasError}</div>
			</div>

			<br>

			<div class="form-group">
				<div class="input-group-prepend" style="width: 500px;">
					<span style="width: 135px;" class="input-group-text" id=""><spring:message code="lable.account.role"/></span>
					<form:select class="custom-select" path="role"
						cssErrorClass="form-control is-invalid">
						<form:option value="1" label="Admin" />
						<form:option value="0" label="Giảng viên" />
					</form:select>
				</div>
			</div>

			<br>
			<div class="row">
				<div class="form-group col">
					<button type="submit" class="btn btn-success">
						<i class="far fa-save"></i> <spring:message code="common.button.save"/>
					</button>
					<a href="<spring:url value="/account"/>" class="btn btn-warning"><i
						class="fas fa-angle-left"></i> <spring:message code="common.button.back"/></a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>