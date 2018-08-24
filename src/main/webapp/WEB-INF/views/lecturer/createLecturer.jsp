<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(document).on(
						'change',
						'.btn-file :file',
						function() {
							var input = $(this), label = input.val().replace(
									/\\/g, '/').replace(/.*\//, '');
							input.trigger('fileselect', [ label ]);
						});

				$('.btn-file :file').on(
						'fileselect',
						function(event, label) {

							var input = $(this).parents('.input-group').find(
									':text'), log = label;

							if (input.length) {
								input.val(log);
							} else {
								if (log)
									alert(log);
							}

						});
				function readURL(input) {
					if (input.files && input.files[0]) {
						var reader = new FileReader();

						reader.onload = function(e) {
							$('#img-upload').attr('src', e.target.result);
						}

						reader.readAsDataURL(input.files[0]);
					}
				}

				$("#imgInp").change(function() {
					readURL(this);
				});
			});
</script>
<style type="text/css">
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}

#img-upload {
	width: 50%;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div align="center" class="container">

		<br>
		<h1 align="center"><spring:message code="language.lecturer.insert.title"/></h1>
		<br>
		<spring:url value="/lecturer/createLecturer" var="create"></spring:url>
		<form:form action="${create}" modelAttribute="lecturerCreateForm" 
			method="post">
			<div class="input-group" style="width: 500px;">
					<div class="input-group-prepend">
						<span style="width: 75px;" class="input-group-text" id=""><spring:message code="language.lecturer.insert.button1"/></span>
					</div>
					<c:set var="codeHasError">
						<form:errors path="code" />
					</c:set>
					<form:input path="code" type="text"
						cssClass="form-control ${not empty codeHasError ? 'is-invalid' : ''}" />
					<div class="invalid-feedback">${codeHasError}</div>
				</div>
			<br>
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 75px;" class="input-group-text" id=""><spring:message code="language.lecturer.insert.button2"/></span>
				</div>
				<c:set var="nameHasError">
					<form:errors path="name" />
				</c:set>
				<form:input path="name" type="text"
					cssClass="form-control ${not empty nameHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${nameHasError}</div>
			</div>
			<br>
			<div class="col">
				<div class="form-group" style="width: 500px">
					<div class="input-group">
						<span style="width: 75px;" class="btn btn-secondary btn-file">
							Browse… <input type="file" name="file" id="imgInp">
						</span>
						<form:input path="photo" cssClass="form-control"
							cssErrorClass="form-control is-invalid" readonly="true" />
					</div>
					<img id='img-upload' />
				</div>
			</div>
			<br>
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 75px;" class="input-group-text" id=""><spring:message code="language.lecturer.insert.button4"/></span>
				</div>
				<c:set var="emailHasError">
					<form:errors path="email" />
				</c:set>
				<form:input path="email" type="email"
					cssClass="form-control ${not empty emailHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${emailHasError}</div>
			</div>
			<br>
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 75px;" class="input-group-text" id=""><spring:message code="language.lecturer.insert.buttot5"/></span>
				</div>
				<c:set var="photoHasError">
					<form:errors path="phone" />
				</c:set>
				<form:input path="phone" type="number"
					cssClass="form-control ${not empty phoneHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${phoneHasError}</div>
			</div>
			<br>
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 75px;" class="input-group-text" id=""><spring:message code="language.lecturer.insert.button6"/></span>
				</div>
				<c:set var="photoHasError">
					<form:errors path="salary" />
				</c:set>
				<form:input path="salary" type="number"
					cssClass="form-control ${not empty salaryHasError ? 'is-invalid' : ''}" />
				<div class="invalid-feedback">${salaryHasError}</div>
			</div>
			<br>
			<div class="row">

				<div class="form-group col">
					<button type="submit" class="btn btn-success">
						<i class="far fa-save"></i> <spring:message code="language.lecturer.insert.button7"/>
					</button>
					<a href="<spring:url value="/lecturer"/>" class="btn btn-warning"><i
						class="fas fa-angle-left"></i> <spring:message code="language.lecturer.insert.button8"/></a>
				</div>
			</div>
		</form:form>
	</div>
</body>