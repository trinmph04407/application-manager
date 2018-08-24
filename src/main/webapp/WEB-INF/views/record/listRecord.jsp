<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<script type="text/javascript">
	$(document).ready(
		function() {
	$("#name").select2();		
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
			$("#typeRecord").val('');
			$("#searchForm").submit();
		})

	})
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div class="container">

		


		<div>
			<spring:url value="/record" var="listAction"></spring:url>
			<form:form modelAttribute="recordSearchForm" method="GET"
				action="${listAction}" id="searchForm">
<br>
		<h1 align="center"> <spring:message code="label.record.title" /></h1>
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
                         <label for="lecturerId"> <spring:message code="lable.record.name" />: </label>
                         <form:select id="name" path="lecturerId" cssClass="form-control" cssErrorClass="form-control is-invalid">
                            <form:option value="">---<spring:message code="label.record.select" /> ---</form:option>
                            <form:options items="${lecturers}" itemValue="id" itemLabel="name"/>
                         </form:select>
                         
                     </div>


					<div class="form-group col">
						<label for="typeRecord"><spring:message code="lable.record.typeRecord" />: </label>
						<form:select class="custom-select" id="typeRecord"
							path="typeRecord" cssErrorClass="form-control is-invalid">
							<form:option value="" >---<spring:message code="label.record.select" />: ---</form:option>
							<form:option value="true" label="Khen thưởng"/>
							<form:option value="false" label="Kỷ luật" />
						</form:select>
					</div>
				</div>


				<button type="submit" class="btn btn-primary" id="btnSearch">
					<i class="fas fa-search"></i><spring:message code="common.button.search" />
				</button>
				<button type="reset" class="btn btn-warning" id="btnClear">
					<i class="fas fa-eraser"></i><spring:message code="common.button.clear" />
				</button>
			</form:form>
		</div>

		<!-- BEGIN LIST TABLE -->

		<br>
		<div class="row">
			<div class="col">
				<a href="<spring:url value="/record/createRecord"></spring:url>"
					class="btn btn-success"> <i class="fas fa-plus-square"></i>
					<spring:message code="common.button.create" />
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
					<th scope="col"><spring:message code="lable.record.name" /></th>
					<th scope="col"><spring:message code="lable.record.typeRecord" /></th>
					<th scope="col"><spring:message code="lable.record.date" /></th>
					<th scope="col"><spring:message code="lable.record.note" /></th>
					<th width="120px;" scope="col"><spring:message code="lable.record.action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items='${listRecord}' varStatus="loop">
					<tr>

						<td scope="row">${loop.count}</td>
						<td>${list.lecturerName}</td>
						<td><c:choose>
								<c:when test="${list.typeRecord =='true'}">Khen thưởng
					</c:when>
								<c:when test="${list.typeRecord =='false'}">Kỷ luật
					</c:when>
							</c:choose></td>
						<td>${list.dateRecord}</td>
						<td>${list.note}</td>

						<td align="center"><a
							href="<spring:url value="/record/updateRecord/${list.id}"></spring:url>">
								<font color="green" size="15"><i class="fas fa-edit"></i></font>
						</a> <a href="<spring:url value="/record/deleteRecord/${list.id}"></spring:url>"
							style="color: #fff;"
							onclick="return confirm('Bạn có muốn xóa không ???')"> <font
								color="red" size="15"><i class="fas fa-trash-alt"></i></font>
						</a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>