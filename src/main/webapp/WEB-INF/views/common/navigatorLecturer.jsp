<%@page pageEncoding="UTF-8"%>
<div class="container">
	<%@include file="/WEB-INF/views/common/common.jsp"%>
	<%@include file="/WEB-INF/views/common/head.jsp"%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="<c:url value="/"/>"><spring:message
				code="common.logo" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div style="padding-left: 150px;" class="collapse navbar-collapse"
			id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/viewslectuner/studentlec"/>"><spring:message
							code="navigator.student" /></a></li>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/viewslectuner/classlec"/>"><spring:message
							code="navigator.class" /></a></li>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/viewslectuner/majorlec"/>"><spring:message
							code="navigator.major" /></a></li>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/viewslectuner/subjectlec"/>"><spring:message
							code="navigator.subject" /></a></li>
			</ul>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link" href="?lang=en">EN</a></li>
				<li class="nav-item "><a class="nav-link" href="?lang=vn">VN</a></li>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/auth/logout"/>">Logout</a></li>
			</ul>
		</div>
	</nav>
</div>