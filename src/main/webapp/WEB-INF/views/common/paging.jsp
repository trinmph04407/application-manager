<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<div class="clearfix">
    <c:if test="${paging.totalRecords > 0}">
    <nav aria-label="page navigation" class="float-right">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="javascript:paging(${paging.first})" aria-label="First page">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">First</span>
                </a>
            </li>
             <c:forEach var ="index" begin ="${paging.from}" end ="${paging.to}">
                <c:if test="${index != paging.currentPage}">
                    <li class="page-item"><a class="page-link" href="javascript:paging(${index})">${index}</a></li>
                </c:if>
                <c:if test="${index == paging.currentPage}">
                    <li class="page-item active"><a class="page-link" href="javascript:paging(${index})">${index}</a></li>
                </c:if>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="javascript:paging(${paging.last})" aria-label="Last">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Last</span>
                </a>
            </li>
        </ul>
    </nav>
    </c:if>
    <c:if test="${paging.totalRecords == 0}">
    <nav aria-label="page navigation" class="float-right">
        <ul class="pagination">
            <li class="page-item">&nbsp;</li>
        </ul>
    </nav>
    </c:if>
     <div class="float-right p-2"><span><spring:message code="paging.total"/>: 
     ${paging.totalRecords} <spring:message code="paging.items"/>/${paging.totalPages} <spring:message code="page.total"/> </span></div>
</div>
