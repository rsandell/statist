
<%@ page import="com.sonymobile.swdtools.statist.StatusItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'statusItem.label', default: 'StatusItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-statusItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table">
				<thead>
					<tr>
					
						<g:sortableColumn property="text" title="${message(code: 'statusItem.text.label', default: 'Text')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'statusItem.date.label', default: 'Date')}" />
					
						<th><g:message code="statusItem.status.label" default="Status" /></th>
					
						<th><g:message code="statusItem.system.label" default="System" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${statusItemInstanceList}" status="i" var="statusItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${statusItemInstance.id}">${fieldValue(bean: statusItemInstance, field: "text")}</g:link></td>
					
						<td><g:formatDate date="${statusItemInstance.date}" /></td>
					
						<td>${fieldValue(bean: statusItemInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: statusItemInstance, field: "system")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
					<div class="nav" role="navigation">
		<g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</div>
			
			<div class="pagination">
				<g:paginate total="${statusItemInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
