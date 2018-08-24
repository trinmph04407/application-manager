<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div style="width: 500px;" class="container">

		<spring:url value="/subject/createSubject" var="create"></spring:url>
		<form:form action="${create}" modelAttribute="subjectCreateForm"
			method="post">

			<br>
			<h1 align="center"><spring:message code="lable.subject.title.create" /></h1>
			<br>
			<br>
			<div align="center">

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text"  style="width: 100px;">
							<spring:message code="lable.subject.code" />
						</span>
					</div>
					 <form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="code"/></div>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text"  style="width: 100px;">
							<spring:message code="lable.subject.name" />
						</span>
					</div>
					 <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback"><form:errors path="name"/></div>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text"  style="width: 100px;">
							<spring:message code="lable.subject.major" />
						</span>
					</div>
					<c:set var="majorIdHasError">
						<form:errors path="majorId" />
					</c:set>
					<form:select path="majorId" cssClass="custom-select"
						cssErrorClass="form-control is-invalid">
						<form:option value="">--- <spring:message code="lable.subject.majorname.select" /> ---</form:option>
						<form:options items="${majors}" itemValue="id"
							itemLabel="name"
							cssClass="form-control ${not empty majorIdHasError ? 'is-invalid' : ''}" />
					</form:select>
					<div class="invalid-feedback">${majorIdHasError}</div>
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text"  style="width: 100px;">
							<spring:message code="lable.subject.lecturer" />
						</span>
					</div>
					<c:set var="lecturerIdHasError">
						<form:errors path="lecturerId" />
					</c:set>
					<form:select path="lecturerId" cssClass="custom-select"
						cssErrorClass="form-control is-invalid">
						<form:option value="">--- <spring:message code="lable.subject.lecturername.select" /> ---</form:option>
						<form:options items="${lecturers}" itemValue="id"
							itemLabel="name"
							cssClass="form-control ${not empty lecturerIdHasError ? 'is-invalid' : ''}" />
					</form:select>
					<div class="invalid-feedback">${lecturerIdHasError}</div>
				</div>

				<div class="row">
					<div class="form-group col">
						<button type="submit" class="btn btn-success">
							<i class="far fa-save"></i> 
								<spring:message code="common.button.save" />
						</button>
						<a href="<spring:url value="/subject"/>" class="btn btn-warning"><i
							class="fas fa-angle-left"></i>
								<spring:message code="common.button.back" />	
							</a>
					</div>
				</div>


			</div>
		</form:form>
	</div>
</body>
</html>