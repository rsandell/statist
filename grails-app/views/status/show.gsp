
<%@ page import="com.sonymobile.swdtools.statist.Status" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'status.label', default: 'Status')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-status" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-status" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list status">
			
				<g:if test="${statusInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="status.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${statusInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${statusInstance?.severity}">
				<li class="fieldcontain">
					<span id="severity-label" class="property-label"><g:message code="status.severity.label" default="Severity" /></span>
					
						<span class="property-value" aria-labelledby="severity-label"><g:fieldValue bean="${statusInstance}" field="severity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${statusInstance?.statusitem}">
				<li class="fieldcontain">
					<span id="statusitem-label" class="property-label"><g:message code="status.statusitem.label" default="Statusitem" /></span>
					
						<g:each in="${statusInstance.statusitem}" var="s">
						<span class="property-value" aria-labelledby="statusitem-label"><g:link controller="statusItem" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${statusInstance?.id}" />
					<g:link class="edit" action="edit" id="${statusInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
