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
<script type="text/javascript">
	function paging(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}

	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#code").val('');
			$("#name").val('');
			$("#searchForm").submit();
		})

	})
</script>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigatorLecturer.jsp"%>


	<div class="container">

		<br>
		<h1 align="center">
			<spring:message code="lable.student.title" />
		</h1>
		<br>
		<!-- BEGIN TOP MESSAGE -->
		<c:if test="${not empty sessionMessageDto}">
			<div>
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<spring:message code="${sessionMessageDto.messageCode}"
						arguments="${sessionMessageDto.messageArgs}" />
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>

		<!-- BEGIN SEARCH FORM -->

		<div>
			<form:form modelAttribute="studentSearchForm" method="GET"
				id="searchForm">
				<form:hidden path="pn" id="pageNo" />
			</form:form>
			<spring:url value="/viewslectuner/studentlec" var="listAction"></spring:url>
			<form:form modelAttribute="studentSearchForm" method="GET"
				action="${listAction}" id="searchForm">
				<div class="row">
					<div class="form-group col">
						<label for="code"> <spring:message
								code="lable.student.code" /></label>
						<form:input path="code" cssClass="form-control"
							cssErrorClass="form-control is-invalid" />
						<div class="invalid-feedback">
							<form:errors path="code" />
						</div>
					</div>
					<div class="form-group col">
						<label for="name"><spring:message
								code="lable.student.name" /></label>
						<form:input path="name" cssClass="form-control"
							cssErrorClass="form-control is-invalid" />
						<div class="invalid-feedback">
							<form:errors path="name" />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="btnSearch">
					<i class="fas fa-search"></i>
					<spring:message code="common.button.search" />
				</button>
				<button type="reset" class="btn btn-warning" id="btnClear">
					<i class="fas fa-eraser"></i>
					<spring:message code="common.button.clear" />
				</button>
			</form:form>
		</div>

		<!-- BEGIN LIST TABLE -->

		<br>
		<div class="row">

			<div class="col">
				<%@include file="/WEB-INF/views/common/paging.jsp"%>
			</div>
		</div>

		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col"><spring:message code="lable.student.code" /></th>
					<th scope="col"><spring:message code="lable.student.name" /></th>
					<th scope="col"><spring:message code="lable.student.photo" /></th>
					<th scope="col"><spring:message code="lable.student.email" /></th>
					<th scope="col"><spring:message code="lable.student.phone" /></th>
					<th scope="col"><spring:message code="lable.student.class" /></th>
					<th scope="col"><spring:message code="lable.student.major" /></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${listStudent}" varStatus="count">
					<tr>
						<td scope="row">${count.index + 1}</td>
						<td>${student.code}</td>
						<td>${student.name}</td>
						<td><c:if test="${not empty student.photo}">
								<img alt="${student.code}"
									src="<spring:url value="upload/${student.photo}"></spring:url>"
									width="100px" />
							</c:if> <c:if test="${empty student.photo}">
								<img alt="${student.code}"
									src="<spring:url value="/upload/default-user-image.png"></spring:url>"
									width="100px" />
							</c:if></td>
						<td>${student.email}</td>
						<td>${student.phone}</td>
						<td>${student.clasess.code}</td>
						<td>${student.major.name}</td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
		<%@include file="/WEB-INF/views/common/paging.jsp"%>

	</div>
</body>
</html>