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
		<h1 align="center"><spring:message code="label.record.title.create"/> </h1>
		<br>

		<spring:url value="/record/createRecord" var="insertAction"></spring:url>
		<form:form modelAttribute="recordCreateForm" action="${insertAction}"
			method="POST">
			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
				<span style="width: 120px;" class="input-group-text" id=""><spring:message code="lable.record.name"/></span>
					
					<form:select path="lecturerId" style="width: 400px;"
						class="form-control">
						<form:options items="${lecturers}" itemValue="id"
							itemLabel="name"></form:options>
					</form:select><br>
				
					
				</div>
			</div>
			<br>

			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
				<span style="width: 120px;" class="input-group-text" id=""><spring:message code="lable.record.typeRecord"/></span>
				</div><br>
				<form:radiobutton path="typeRecord" value="true" label="Khen thưởng" />
				<form:radiobutton path="typeRecord" value="false" label="Kỷ luật" />
			</div>
			<br>
			<div class="input-group" style="width: 500px;">
				<c:set var="dateHasError">
					<form:errors path="dateRecord" />
				</c:set>
				<span style="width: 120px;" class="input-group-text" id="">
				<spring:message code="lable.record.date"/></span>
				<form:input class="form-control" path="dateRecord" type="date"
					cssClass="form-control ${not empty dateHasError ? 'is-invalid' : ''} " />
				<div class="invalid-feedback">${dateHasError}</div>
			</div>
			
			<br>

			<div class="input-group" style="width: 500px;">
				<div class="input-group-prepend">
					<span style="width: 120px;" class="input-group-text" id=""><spring:message code="lable.record.note"/></span>
				</div>
				<form:textarea path="note" class="form-control"></form:textarea>
			</div>
			<br>
			<div class="row">
				<div class="form-group col">
					<button type="submit" class="btn btn-success">
						<i class="far fa-save"></i> <spring:message code="common.button.save"/>
					</button>
					<a href="<spring:url value="/record"/>" class="btn btn-warning"><i
						class="fas fa-angle-left"></i> <spring:message code="common.button.back"/></a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>