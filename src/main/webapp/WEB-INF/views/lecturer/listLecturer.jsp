<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
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
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div class="container">

		<br>
		<h1 align="center"><spring:message code="language.lecturer.title"/></h1>
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
			<spring:url value="/lecturer" var="listAction"></spring:url>
			<form:form modelAttribute="LecturerSearchForm" method="GET"
				action="${listAction}" id="searchForm">
				<form:hidden path="pn" id="pageNo" />
				<div class="row">
					<div class="form-group col">
						<label for="code"><spring:message code="language.lecturer.title1"/></label>
						<form:input path="code" cssClass="form-control" cssErrorClass="form-control is-invalid" />
						<div class="invalid-feedback">
							<form:errors path="code" />
						</div>
					</div>
					<div class="form-group col">
						<label for="name"><spring:message code="language.lecturer.title2"/></label> 
						<form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid" />
						<div class="invalid-feedback">
							<form:errors path="name" />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="btnSearch">
					<i class="fas fa-search"></i><spring:message code="language.lecturer.button1"/>
				</button>
				<button type="reset" class="btn btn-warning" id="btnClear">
					<i class="fas fa-eraser"></i><spring:message code="language.lecturer.button2"/>
				</button>
			</form:form>
		</div>

		<!-- BEGIN LIST TABLE -->

		<br>
		<div class="row">
			<div class="col">
				<a href="<spring:url value="/lecturer/createLecturer"></spring:url>"
					class="btn btn-success"> <i class="fas fa-plus-square"></i>
					<spring:message code="language.lecturer.button3"/>
				</a>
			</div>
			<div class="col">
				<jsp:include page="/WEB-INF/views/common/paging.jsp">
					<jsp:param name="paging" value="${paging}" />
				</jsp:include>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col"><spring:message code="language.lecturer.table1"/></th>
					<th scope="col"><spring:message code="language.lecturer.table2"/></th>
					<th scope="col"><spring:message code="language.lecturer.table3"/></th>
					<th scope="col"><spring:message code="language.lecturer.table4"/></th>
					<th scope="col"><spring:message code="language.lecturer.table5"/></th>
					<th scope="col"><spring:message code="language.lecturer.table6"/></th>
					<th scope="col"><spring:message code="language.lecturer.table7"/></th>
					<th width="120px;" scope="col"><spring:message code="language.lecturer.table8"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="gv" items="${lecturer}" varStatus="count" >
					<tr>
						<td>${count.count}</td>
						<td>${gv.code }</td>	
						<td>${gv.name }</td>	
						<td>
							<c:if test="${not empty gv.photo}">
                                <img alt="${gv.id}" src="upload/${gv.photo}" style="width: 130px;"/>
                            </c:if>
                            <c:if test="${empty gv.photo}">
                                <img alt="${gv.id}" src="upload/default-user-image.png" style="width: 130px;"/>
                            </c:if>
						</td>
						<td>${gv.phone }</td>
						<td>${gv.email }</td>
						<td>${gv.salary }</td>
						<td align="center"><a
							href="<spring:url value="/lecturer/updateLecturer/${gv.id}"></spring:url>">
								<font color="green" size="15"><i class="fas fa-edit"></i></font>
						</a> <a href="<spring:url value="/lecturer/deleteLecturer/${gv.id}"></spring:url>"
							style="color: #fff;"
							onclick="return confirm('Bạn có muốn xóa không ???')"> <font
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