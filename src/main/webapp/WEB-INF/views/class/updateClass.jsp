<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: normal;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div class="container">

		<br>
		<h1 align="center">
			<spring:message code="language.class.update.title" />
		</h1>
		<br> <br>
		<div align="center">
			<spring:url value="/class/updateClass/${id}" var="update"></spring:url>
			<form:form action="${update}" modelAttribute="classUpdateForm"
				method="post">
				<div align="center">
					<div class="input-group" style="width: 500px;">
						<div class="input-group-prepend">
							<span style="width: 120px;" class="input-group-text" id=""><spring:message
									code="language.class.insert.button1" /></span>
						</div>
						<c:set var="codeHasError">
							<form:errors path="code" />
						</c:set>
						<form:hidden path="code" />
						<form:input path="code" type="text" disabled="true"
							cssClass="form-control ${not empty codeHasError ? 'is-invalid' : ''}" />
						<div class="invalid-feedback">${codeHasError}</div>
					</div>
					<br>

					<div class="input-group" style="width: 500px;">
						<div class="input-group-prepend">
							<span style="width: 120px;" class="input-group-text" id=""><spring:message
									code="language.class.insert.button2" /></span>
						</div>
						<c:set var="lectureridHasError">
							<form:errors path="lecturerid" />
						</c:set>
						<form:select path="lecturerid" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- Please select lecturer ---</form:option>
							<form:options items="${lecturers1}" itemValue="id"
								itemLabel="name"
								cssClass="form-control ${not empty lectureridHasError ? 'is-invalid' : ''}" />
						</form:select>
						<div class="invalid-feedback">${lectureridHasError}</div>
					</div>
					<br>
					<div class="input-group" style="width: 500px;">
						<div class="input-group-prepend">
							<span style="width: 120px;" class="input-group-text" id=""><spring:message
									code="language.class.insert.button3" /></span>
						</div>
						<c:set var="majoridHasError">
							<form:errors path="majorid" />
						</c:set>
						<form:select path="majorid" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- Please select major ---</form:option>
							<form:options items="${majors1}" itemValue="id" itemLabel="name"
								cssClass="form-control ${not empty majoridHasError ? 'is-invalid' : ''}" />
						</form:select>
						<div class="invalid-feedback">${majoridHasError}</div>
					</div>

					<br>

					<div class="row">
						<div class="form-group col">
							<button type="submit" class="btn btn-success">
								<i class="far fa-save"></i>
								<spring:message code="language.class.insert.button4" />
							</button>
							<a href="<spring:url value="/class"/>" class="btn btn-warning"><i
								class="fas fa-angle-left"></i>
							<spring:message code="language.class.insert.button5" /></a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>