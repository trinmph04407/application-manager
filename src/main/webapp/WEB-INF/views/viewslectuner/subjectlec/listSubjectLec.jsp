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
	$("#majorId").select2();
	})
	
	function paging(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}

	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#name").val('');
			$("#majorId").val('');
			$("#lecturerId").val('');
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
			<spring:message code="lable.subject.title" />
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
			<spring:url value="/viewslectuner/subjectlec" var="listAction"></spring:url>
			<form:form modelAttribute="subjectSearchForm" method="GET"
				action="${listAction}" id="searchForm">

				<form:hidden path="pn" id="pageNo" />

				<div class="row">

					<div class="form-group col">
						<label for="lecturerId"><spring:message
								code="lable.subject.lecturer" /></label>
						<form:select path="lecturerId" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- <spring:message
									code="lable.subject.lecturername.select" /> ---</form:option>
							<form:options items="${lecturers}" itemValue="id"
								itemLabel="name" />
						</form:select>
						<div class="invalid-feedback">
							<form:errors path="lecturerId" />
						</div>
					</div>

				</div>


				<div class="row">

					<div class="form-group col">
						<label for="name"><spring:message
								code="lable.subject.name" /></label>

						<form:input id="name" path="name" cssClass="form-control"
							cssErrorClass="form-control is-invalid" />
					</div>

					<div class="form-group col">
						<label for="lecturerId"><spring:message
								code="lable.subject.major" /></label>
						<form:select path="majorId" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- <spring:message
									code="lable.subject.majorname.select" /> ---</form:option>
							<form:options items="${majors}" itemValue="id" itemLabel="name" />
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

				<%@include file="/WEB-INF/views/common/paging.jsp"%>

			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col"><spring:message code="lable.subject.code" />
					</th>
					<th scope="col"><spring:message code="lable.subject.name" />
					</th>
					<th scope="col"><spring:message code="lable.subject.major" />
					</th>
					<th scope="col"><spring:message code="lable.subject.lecturer" />
					</th>

				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(listSubject) > 0}">
					<c:forEach var="subject" items='${listSubject}' varStatus="loop">
						<tr>

							<td scope="row">${loop.index + 1}</td>
							<td>${subject.code}</td>
							<td>${subject.name}</td>
							<td>${subject.majorName}</td>
							<td>${subject.lecturerName}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<%@include file="/WEB-INF/views/common/paging.jsp"%>
	</div>
</body>
</html>