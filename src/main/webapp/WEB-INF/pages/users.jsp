<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <form method="post" action="${pageContext.request.contextPath}/Users">

    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
        <a href="${pageContext.request.contextPath}/addUser" class="btn btn-primary btn-lg" role="button"> Add User</a>
        <button class="btn btn-secondary" type="submit">Invoice</button>
    </c:if>
    <c:forEach var="user" items="${users}" varStatus="status" >
        <div class="row">
            <div class="col-md">
                <input value="${user.id}" name="user_ids" type="checkbox";/>
            </div>
            <div class="col-md-4">${user.username}</div>
            <div class="col-md-4">${user.email}</div>
            <div class="col-md-3">${user.position}</div>
        </div>
    </c:forEach>
    </form>
    <div>Invoices: </div>
    <c:forEach var="username" items="${invoices}" varStatus="status">
        ${username}
    </c:forEach>
</t:pageTemplate>