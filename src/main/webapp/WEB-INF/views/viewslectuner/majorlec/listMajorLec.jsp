<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
$(document).ready(
		function() {
	$("#lecturerId").select2();
	})
		
	function paging(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}
	
	
	$(function() {
		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#lecturerId").val('');
			$("#name").val('');
			$("#searchForm").submit();
		})

	})
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigatorLecturer.jsp"%>
	<div class="container">

		<br>
		<h1 align="center">
			<spring:message code="lable.major.title" />
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
			<spring:url value="/viewslectuner/majorlec" var="listAction"></spring:url>
			<form:form modelAttribute="majorSearchForm" method="GET"
				action="${listAction}" id="searchForm">
				<form:hidden path="pn" id="pageNo" />
				<div class="row">
					<div class="form-group col">
						<label for="name"><spring:message code="lable.major.name" /></label>
						<form:input path="name" cssClass="form-control"
							cssErrorClass="form-control is-invalid" />
						<div class="invalid-feedback">
							<form:errors path="name" />
						</div>
					</div>

					<div class="form-group col">
						<label for="lecturerId"><spring:message
								code="lable.major.lecturer" /></label>
						<form:select path="lecturerId" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- <spring:message
									code="lable.major.lecturername.select" /> ---</form:option>
							<form:options items="${lecturers}" itemValue="id"
								itemLabel="name" />
						</form:select>
						<div class="invalid-feedback">
							<form:errors path="lecturerId" />
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

				<jsp:include page="/WEB-INF/views/common/paging.jsp">
					<jsp:param name="paging" value="${paging}" />
				</jsp:include>

			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col"><spring:message code="lable.major.code" /></th>
					<th scope="col"><spring:message code="lable.major.name" /></th>
					<th scope="col"><spring:message code="lable.major.lecturer" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(listMajor) > 0}">
					<c:forEach items="${listMajor}" var="major" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td>${major.code}</td>
							<td>${major.name}</td>
							<td>${major.lecturerName}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<jsp:include page="/WEB-INF/views/common/paging.jsp">
			<jsp:param name="paging" value="${paging}" />
		</jsp:include>
	</div>
</body>
</html>