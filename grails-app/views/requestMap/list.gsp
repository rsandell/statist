
<%@ page import="com.sonymobile.swdtools.statist.RequestMap" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'requestMap.label', default: 'RequestMap')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
		<g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</div>
		<div id="list-requestMap" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="url" title="${message(code: 'requestMap.url.label', default: 'Url')}" />
					
						<g:sortableColumn property="configAttribute" title="${message(code: 'requestMap.configAttribute.label', default: 'Config Attribute')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${requestMapInstanceList}" status="i" var="requestMapInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${requestMapInstance.id}">${fieldValue(bean: requestMapInstance, field: "url")}</g:link></td>
					
						<td>${fieldValue(bean: requestMapInstance, field: "configAttribute")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${requestMapInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
