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
	
		<spring:url value="/major/createMajor" var="create"></spring:url>
		<form:form action="${create}" modelAttribute="majorCreateForm"
			method="post">
		<br>
		
		<h1 align="center"><spring:message code="lable.major.title.create" /></h1>
		<br> <br> 
		<div align="center">
		
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text"  style="width: 100px;">
						<spring:message code="lable.major.code" />
					</span>
				</div>
				<c:set var="codeHasError">
					<form:errors path="code" />
				</c:set>
				<form:input path="code"
					cssClass="form-control ${not empty codeHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${codeHasError}</div>
			</div>
			

			<div  class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text"  style="width: 100px;">
						<spring:message code="lable.major.name" />
					</span>
				</div>
				<c:set var="nameHasError">
					<form:errors path="name" />
				</c:set>
				<form:input path="name"
					cssClass="form-control ${not empty nameHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${nameHasError}</div>
			</div>
			
			<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text"  style="width: 100px;">
							<spring:message code="lable.major.lecturer" />
						</span>
					</div>
					<c:set var="lecturerIdHasError">
						<form:errors path="lecturerId" />
					</c:set>
					<form:select path="lecturerId" cssClass="custom-select"
						cssErrorClass="form-control is-invalid">
						<form:option value="">--- <spring:message code="lable.major.lecturername.select" /> ---</form:option>
						<form:options items="${lecturers}" itemValue="id"
							itemLabel="name"
							cssClass="form-control ${not empty lecturerIdHasError ? 'is-invalid' : ''}" />
					</form:select>
					<div class="invalid-feedback">${lecturerIdHasError}</div>
				</div>
			
		<div class="row">
            <div class="form-group col">
            	<button type="submit" class="btn btn-success"><i class="far fa-save"></i>
            	 	<spring:message code="common.button.save" />
            	 </button>
            	<a href="<spring:url value="/major"/>" class="btn btn-warning"><i class="fas fa-angle-left"></i>
            	 	<spring:message code="common.button.back" />
            	 </a>
            </div>
        </div>
			
			
		</div>
		</form:form>
	</div>
</body>
</html>