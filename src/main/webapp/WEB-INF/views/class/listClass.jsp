<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
	$(document).ready(
		function() {
	$("#majorid").select2();
	$("#lecturerid").select2();
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
			$("#majorid").val('');
			$("#lecturerid").val('');
			$("#searchForm").submit();
		})

	})
</script>

</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div class="container">

		<br>
		<h1 align="center"><spring:message code="language.class.title"/></h1>
		<br>

		<!-- BEGIN TOP MESSAGE -->
		<c:if test="${not empty sessionMessageDto}">
        <div>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                 <spring:message code="${sessionMessageDto.messageCode}" arguments="${sessionMessageDto.messageArgs}" />
                 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
            </div>
        </div>
        </c:if>
		<!-- BEGIN SEARCH FORM -->
		<div>
			<spring:url value="/class" var="listAction"></spring:url>
			<form:form modelAttribute="clasessSearchForm" method="GET"
				action="${listAction}" id="searchForm">
				<form:hidden path="pn" id="pageNo" />
				<div class="row">

					<div class="form-group col">
						<label for="lecturerid"><spring:message code="language.class.title1"/>: </label>
						<form:select id="lecturerid" path="lecturerid" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- Please select lecturer ---</form:option>
							<form:options items="${lecturers1}" itemValue="id" itemLabel="name" />
						</form:select>
						<div class="invalid-feedback">
							<form:errors path="lecturerid" />
						</div>
					</div>
					<div class="form-group col">
						<label for="majorid"><spring:message code="language.class.title2"/>: </label>
						<form:select id="majorid" path="majorid" cssClass="form-control"
							cssErrorClass="form-control is-invalid">
							<form:option value="">--- Please select major ---</form:option>
							<form:options items="${majors1}" itemValue="id" itemLabel="name" />
						</form:select>
						<div class="invalid-feedback">
							<form:errors path="majorid" />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="btnSearch">
					<i class="fas fa-search"></i><spring:message code="language.class.button1"/>
				</button>
				<button type="reset" class="btn btn-warning" id="btnClear">
					<i class="fas fa-eraser"></i> <spring:message code="language.class.button2"/>
				</button>
			</form:form>
		</div>

		<!-- BEGIN LIST TABLE -->

		<br>
		<div class="row">
			<div class="col">
				<a href="<spring:url value="/class/createClass"></spring:url>"
					class="btn btn-success"> <i class="fas fa-plus-square"></i>
					<spring:message code="language.class.button3"/>
				</a>
			</div>
			<br>
			<div class="col">

				<%@include file="/WEB-INF/views/common/paging.jsp"%>

			</div>
		</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col"><spring:message code="language.class.table1"/></th>
					<th scope="col"><spring:message code="language.class.table2"/></th>
					<th scope="col"><spring:message code="language.class.table3"/></th>
					<th scope="col"><spring:message code="language.class.table4"/></th>
					<th width="120px;" scope="col"><spring:message code="language.class.table5"/></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="classes" items='${listClass}' varStatus="loop">
					<tr>
						<td scope="row">${loop.index + 1}</td>
						<td>${classes.code}</td>
						<td>${classes.lecturerName1}</td> 
						<td>${classes.majorName1}</td> 
						<td align="center"><a
							href="<spring:url value="/class/updateClass/${classes.id}"></spring:url>">
								<font color="green" size="15"><i class="fas fa-edit"></i></font>
						</a> <a onclick="return confirm('Bạn có muốn xóa không ???')"
							href="<spring:url value="/class/deleteClass/${classes.id}"></spring:url>"> <font
								color="red" size="15"><i class="fas fa-trash-alt"></i></font>
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<%@include file="/WEB-INF/views/common/paging.jsp"%>
	</div>
</body>
</html>