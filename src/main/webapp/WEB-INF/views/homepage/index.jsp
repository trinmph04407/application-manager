<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>
	<div class="container">
		<br>
		<h1 style="padding-left: 360px;">Welcome to PRO211</h1>
		<br>
		<br>
		<table class="table table-hover">
			<tr>
				<th><spring:message code="language.lecturer.table2" /></th>
				<th><spring:message code="language.lecturer.table3" /></th>
				<th><spring:message code="language.lecturer.table4" /></th>
				<th><spring:message code="label.statics.total.achievement" /></th>
			</tr>
			<c:forEach var="a" items="${home}">
				<tr>
					<c:if test="${a[3] >=3 }">
						<td>${a[0]}</td>
						<td>${a[1]}</td>
						<td><c:if test="${not empty a[2]}">
								<img src="upload/${a[2]}" height="150px" width="150px" />
							</c:if> <c:if test="${empty a[2] }">
								<img src="upload/default-user-image.jpg" height="150px"
									width="150px" />
							</c:if></td>
						<td>${a[3]}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>