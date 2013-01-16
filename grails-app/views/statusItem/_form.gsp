<%@ page import="com.sonymobile.swdtools.statist.StatusItem" %>



<div class="fieldcontain ${hasErrors(bean: statusItemInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="statusItem.text.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="text" required="" value="${statusItemInstance?.text}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusItemInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="statusItem.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${statusItemInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: statusItemInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="statusItem.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="status" name="status.id" from="${com.sonymobile.swdtools.statist.Status.list()}" optionKey="id" required="" value="${statusItemInstance?.status?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusItemInstance, field: 'system', 'error')} required">
	<label for="system">
		<g:message code="statusItem.system.label" default="System" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="system" name="system.id" from="${com.sonymobile.swdtools.statist.System.list()}" optionKey="id" required="" value="${statusItemInstance?.system?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusItemInstance, field: 'tag', 'error')} ">
	<label for="tag">
		<g:message code="statusItem.tag.label" default="Tag" />
		
	</label>
	<g:select name="tag" from="${com.sonymobile.swdtools.statist.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${statusItemInstance?.tag*.id}" class="many-to-many"/>
</div>

