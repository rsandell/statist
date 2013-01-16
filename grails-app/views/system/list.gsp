
<%@ page import="com.sonymobile.swdtools.statist.System"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'system.label', default: 'System')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>

	<div id="list-system" class="content scaffold-list" role="main">
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
						title="${message(code: 'system.name.label', default: 'Name')}" />

					<g:sortableColumn property="prio"
						title="${message(code: 'system.prio.label', default: 'Prio')}" />

					<g:sortableColumn property="archived"
						title="${message(code: 'system.archived.label', default: 'Archived')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${systemInstanceList}" status="i" var="systemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${systemInstance.id}">
								${fieldValue(bean: systemInstance, field: "name")}
							</g:link></td>

						<td>
							${fieldValue(bean: systemInstance, field: "prio")}
						</td>

						<td><g:formatBoolean boolean="${systemInstance.archived}" /></td>

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
			<g:paginate total="${systemInstanceTotal}" />
		</div>
	</div>
</body>
</html>
