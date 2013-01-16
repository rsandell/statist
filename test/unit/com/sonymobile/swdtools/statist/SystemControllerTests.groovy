package com.sonymobile.swdtools.statist



import org.junit.*
import grails.test.mixin.*

@TestFor(SystemController)
@Mock(System)
class SystemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/system/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.systemInstanceList.size() == 0
        assert model.systemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.systemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.systemInstance != null
        assert view == '/system/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/system/show/1'
        assert controller.flash.message != null
        assert System.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/system/list'

        populateValidParams(params)
        def system = new System(params)

        assert system.save() != null

        params.id = system.id

        def model = controller.show()

        assert model.systemInstance == system
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/system/list'

        populateValidParams(params)
        def system = new System(params)

        assert system.save() != null

        params.id = system.id

        def model = controller.edit()

        assert model.systemInstance == system
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/system/list'

        response.reset()

        populateValidParams(params)
        def system = new System(params)

        assert system.save() != null

        // test invalid parameters in update
        params.id = system.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/system/edit"
        assert model.systemInstance != null

        system.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/system/show/$system.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        system.clearErrors()

        populateValidParams(params)
        params.id = system.id
        params.version = -1
        controller.update()

        assert view == "/system/edit"
        assert model.systemInstance != null
        assert model.systemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/system/list'

        response.reset()

        populateValidParams(params)
        def system = new System(params)

        assert system.save() != null
        assert System.count() == 1

        params.id = system.id

        controller.delete()

        assert System.count() == 0
        assert System.get(system.id) == null
        assert response.redirectedUrl == '/system/list'
    }
}
