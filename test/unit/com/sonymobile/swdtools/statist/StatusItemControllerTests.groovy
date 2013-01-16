package com.sonymobile.swdtools.statist



import org.junit.*
import grails.test.mixin.*

@TestFor(StatusItemController)
@Mock(StatusItem)
class StatusItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/statusItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.statusItemInstanceList.size() == 0
        assert model.statusItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.statusItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.statusItemInstance != null
        assert view == '/statusItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/statusItem/show/1'
        assert controller.flash.message != null
        assert StatusItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/statusItem/list'

        populateValidParams(params)
        def statusItem = new StatusItem(params)

        assert statusItem.save() != null

        params.id = statusItem.id

        def model = controller.show()

        assert model.statusItemInstance == statusItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/statusItem/list'

        populateValidParams(params)
        def statusItem = new StatusItem(params)

        assert statusItem.save() != null

        params.id = statusItem.id

        def model = controller.edit()

        assert model.statusItemInstance == statusItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/statusItem/list'

        response.reset()

        populateValidParams(params)
        def statusItem = new StatusItem(params)

        assert statusItem.save() != null

        // test invalid parameters in update
        params.id = statusItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/statusItem/edit"
        assert model.statusItemInstance != null

        statusItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/statusItem/show/$statusItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        statusItem.clearErrors()

        populateValidParams(params)
        params.id = statusItem.id
        params.version = -1
        controller.update()

        assert view == "/statusItem/edit"
        assert model.statusItemInstance != null
        assert model.statusItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/statusItem/list'

        response.reset()

        populateValidParams(params)
        def statusItem = new StatusItem(params)

        assert statusItem.save() != null
        assert StatusItem.count() == 1

        params.id = statusItem.id

        controller.delete()

        assert StatusItem.count() == 0
        assert StatusItem.get(statusItem.id) == null
        assert response.redirectedUrl == '/statusItem/list'
    }
}
