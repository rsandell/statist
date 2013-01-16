<%@ page import="com.sonymobile.swdtools.statist.Status" %>



<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="status.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${statusInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'severity', 'error')} required">
	<label for="severity">
		<g:message code="status.severity.label" default="Severity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="severity" type="number" value="${statusInstance.severity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'statusitem', 'error')} ">
	<label for="statusitem">
		<g:message code="status.statusitem.label" default="Statusitem" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${statusInstance?.statusitem?}" var="s">
    <li><g:link controller="statusItem" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="statusItem" action="create" params="['status.id': statusInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'statusItem.label', default: 'StatusItem')])}</g:link>
</li>
</ul>

</div>

