package com.sonymobile.swdtools.statist

import org.springframework.dao.DataIntegrityViolationException

class StatusItemController {
	def scaffold = true

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [statusItemInstanceList: StatusItem.list(params), statusItemInstanceTotal: StatusItem.count()]
    }

    def create() {
        [statusItemInstance: new StatusItem(params)]
    }

    def save() {
        def statusItemInstance = new StatusItem(params)
        if (!statusItemInstance.save(flush: true)) {
            render(view: "create", model: [statusItemInstance: statusItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), statusItemInstance.id])
        redirect(action: "show", id: statusItemInstance.id)
    }

    def show(Long id) {
        def statusItemInstance = StatusItem.get(id)
        if (!statusItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "list")
            return
        }

        [statusItemInstance: statusItemInstance]
    }

    def edit(Long id) {
        def statusItemInstance = StatusItem.get(id)
        if (!statusItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "list")
            return
        }

        [statusItemInstance: statusItemInstance]
    }

    def update(Long id, Long version) {
        def statusItemInstance = StatusItem.get(id)
        if (!statusItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (statusItemInstance.version > version) {
                statusItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'statusItem.label', default: 'StatusItem')] as Object[],
                          "Another user has updated this StatusItem while you were editing")
                render(view: "edit", model: [statusItemInstance: statusItemInstance])
                return
            }
        }

        statusItemInstance.properties = params

        if (!statusItemInstance.save(flush: true)) {
            render(view: "edit", model: [statusItemInstance: statusItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), statusItemInstance.id])
        redirect(action: "show", id: statusItemInstance.id)
    }

    def delete(Long id) {
        def statusItemInstance = StatusItem.get(id)
        if (!statusItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "list")
            return
        }

        try {
            statusItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'statusItem.label', default: 'StatusItem'), id])
            redirect(action: "show", id: id)
        }
    }
}
