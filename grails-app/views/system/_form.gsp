<%@ page import="com.sonymobile.swdtools.statist.System" %>



<div class="fieldcontain ${hasErrors(bean: systemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="system.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${systemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemInstance, field: 'prio', 'error')} required">
	<label for="prio">
		<g:message code="system.prio.label" default="Prio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="prio" type="number" value="${systemInstance.prio}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemInstance, field: 'archived', 'error')} ">
	<label for="archived">
		<g:message code="system.archived.label" default="Archived" />
		
	</label>
	<g:checkBox name="archived" value="${systemInstance?.archived}" />
</div>

<div class="fieldcontain ${hasErrors(bean: systemInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="system.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${com.sonymobile.swdtools.statist.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${systemInstance?.tags*.id}" class="many-to-many"/>
</div>

