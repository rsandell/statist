
<%@ page import="com.sonymobile.swdtools.statist.Status"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'status.label', default: 'Status')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div id="list-status" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table class="table">
			<thead>
				<tr>

					<g:sortableColumn property="name"
						title="${message(code: 'status.name.label', default: 'Name')}" />

					<g:sortableColumn property="severity"
						title="${message(code: 'status.severity.label', default: 'Severity')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${statusInstanceList}" status="i" var="statusInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${statusInstance.id}">
								${fieldValue(bean: statusInstance, field: "name")}
							</g:link></td>

						<td>
							${fieldValue(bean: statusInstance, field: "severity")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="nav" role="navigation">
			<g:link class="btn btn-primary" action="create">
				<g:message code="default.new.label" args="[entityName]" />
			</g:link>
			</li>
		</div>

		<div class="pagination">
			<g:paginate total="${statusInstanceTotal}" />
		</div>
	</div>
</body>
</html>
