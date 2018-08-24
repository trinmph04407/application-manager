<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statics</title>
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navigator.jsp"%>

	<div class="container">
		<br>
		<h1 align="center"><spring:message code="lable.statics.title" /></h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th><spring:message code="language.lecturer.title1" /></th>
					<th><spring:message code="language.lecturer.title2" /></th>
					<th><spring:message code="label.statics.achievement" /></th>
					<th><spring:message code="label.statics.discipline" /></th>
					<th><spring:message code="label.statics.total" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${arrays}" varStatus="count">
					<tr>
						<td>${count.count}</td>
						<td>${a[0]}</td>
						<td>${a[1]}</td>
						<td>${a[2]}</td>
						<td>${a[3]}</td>
						<td>${a[2] + a[3]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>