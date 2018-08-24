<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
$(document).ready(
		function() {
	$("#name").select2();})
	function paging(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}
	
	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#name").val('');
			$("#username").val('');
			$("#searchForm").submit();
		})

	})
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>


	<div class="container">
		<div>
			<spring:url value="/account" var="listAction"></spring:url>
			<form:form modelAttribute="accountSearchForm" method="GET"
				action="${listAction}" id="searchForm">
				
		<br>
		<h1 align="center"><spring:message code="label.account.title"/></h1>
		<br>
		
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
				
				<form:hidden path="pn" id="pageNo" />
				<div class="row">
					<div class="form-group col">
                         <label for="lecturerId"><spring:message code="lable.account.name"/>: </label>
                         <form:select id="name" path="lecturerId" cssClass="form-control" cssErrorClass="form-control is-invalid">
                            <form:option value="">--- <spring:message code="label.account.lecturername.select"/> ---</form:option>
                            <form:options items="${lecturers}" itemValue="id" itemLabel="name"/>
                         </form:select>
                         
                     </div>

					<div class="form-group col">
						<label for="username"><spring:message code="lable.account.username"/>: </label>
						<form:input id="username" path="username" cssClass="form-control"
							cssErrorClass="form-control is-invalid" />

					</div>
				</div>

				<button type="submit" class="btn btn-primary" id="btnSearch">
					<i class="fas fa-search"></i> <spring:message code="common.button.search"/>
				</button>
				<button type="reset" class="btn btn-warning" id="btnClear">
					<i class="fas fa-eraser"></i> <spring:message code="common.button.clear"/>
				</button>
			</form:form>
		</div>

		<!-- BEGIN LIST TABLE -->

		<br>
		<div class="row">
			<div class="col">
				<a href="<spring:url value="/account/createAccount"></spring:url>"
					class="btn btn-success"> <i class="fas fa-plus-square"></i>
					<spring:message code="common.button.create"/>
				</a>
			</div>
			<div class="col">
				<%@include file="/WEB-INF/views/common/paging.jsp"%>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col"><spring:message code="lable.account.name"/></th>
					<th scope="col"><spring:message code="lable.account.username"/></th>
					<th scope="col"><spring:message code="lable.account.role"/></th>
					<th width="120px;" scope="col"><spring:message code="lable.account.action"/></th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${fn:length(listAccount) > 0}">
				<c:forEach items="${listAccount}" var="list" varStatus="loop">
					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td>${list.lecturerName}</td>
						<td>${list.username}</td>
						
						<td>
						<c:choose>
						<c:when test="${list.role  ==1}"> Admin</c:when>
						<c:when test="${list.role  ==0}"> Giảng viên</c:when>
						</c:choose>
						
						</td>
						
						<td align="center"><a
							href="<spring:url value="/account/updateAccount/${list.id}"></spring:url>">
								<font color="green" size="15"><i class="fas fa-edit"></i></font>
						</a> <a
							href="<spring:url value="/account/deleteAccount/${list.username}"></spring:url>"
							style="color: #fff;" onclick="return confirm('Are you sure ???')">
								<font color="red" size="15"><i class="fas fa-trash-alt"></i></font>
						</a>
						 <a
							href="<spring:url value="/account/resetAccount/${list.id}"></spring:url>"
							style="color: #fff;" onclick="return confirm('Are you sure ???')">
								<font color="red" size="15"><i class="fas fa-sync-alt"></i></font>
						</a>
						
						</td>
					</tr>
				</c:forEach>
	</c:if>
			</tbody>
		</table>
		<%@include file="/WEB-INF/views/common/paging.jsp"%>
	</div>
</body>
</html>