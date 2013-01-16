package com.sonymobile.swdtools.statist

import org.springframework.dao.DataIntegrityViolationException

class SystemController {
	def scaffold = true

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [systemInstanceList: System.list(params), systemInstanceTotal: System.count()]
    }

    def create() {
        [systemInstance: new System(params)]
    }

    def save() {
        def systemInstance = new System(params)
        if (!systemInstance.save(flush: true)) {
            render(view: "create", model: [systemInstance: systemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'system.label', default: 'System'), systemInstance.id])
        redirect(action: "show", id: systemInstance.id)
    }

    def show(Long id) {
        def systemInstance = System.get(id)
        if (!systemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "list")
            return
        }

        [systemInstance: systemInstance]
    }

    def edit(Long id) {
        def systemInstance = System.get(id)
        if (!systemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "list")
            return
        }

        [systemInstance: systemInstance]
    }

    def update(Long id, Long version) {
        def systemInstance = System.get(id)
        if (!systemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (systemInstance.version > version) {
                systemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'system.label', default: 'System')] as Object[],
                          "Another user has updated this System while you were editing")
                render(view: "edit", model: [systemInstance: systemInstance])
                return
            }
        }

        systemInstance.properties = params

        if (!systemInstance.save(flush: true)) {
            render(view: "edit", model: [systemInstance: systemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'system.label', default: 'System'), systemInstance.id])
        redirect(action: "show", id: systemInstance.id)
    }

    def delete(Long id) {
        def systemInstance = System.get(id)
        if (!systemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "list")
            return
        }

        try {
            systemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'system.label', default: 'System'), id])
            redirect(action: "show", id: id)
        }
    }
}
