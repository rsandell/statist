
<%@ page import="com.sonymobile.swdtools.statist.System" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'system.label', default: 'System')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-system" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-system" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list system">
			
				<g:if test="${systemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="system.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${systemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${systemInstance?.prio}">
				<li class="fieldcontain">
					<span id="prio-label" class="property-label"><g:message code="system.prio.label" default="Prio" /></span>
					
						<span class="property-value" aria-labelledby="prio-label"><g:fieldValue bean="${systemInstance}" field="prio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${systemInstance?.archived}">
				<li class="fieldcontain">
					<span id="archived-label" class="property-label"><g:message code="system.archived.label" default="Archived" /></span>
					
						<span class="property-value" aria-labelledby="archived-label"><g:formatBoolean boolean="${systemInstance?.archived}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${systemInstance?.tags}">
				<li class="fieldcontain">
					<span id="tags-label" class="property-label"><g:message code="system.tags.label" default="Tags" /></span>
					
						<g:each in="${systemInstance.tags}" var="t">
						<span class="property-value" aria-labelledby="tags-label"><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${systemInstance?.id}" />
					<g:link class="edit" action="edit" id="${systemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
