package statist

import com.sonymobile.swdtools.statist.StatusItem
import com.sonymobile.swdtools.statist.System

class StatusController {

    def status = {
        def systems = System.findAllByArchived(false, [sort: "prio", order: "asc"]);
        def sysStatus = [:]
        systems.each { sys ->
            def item = StatusItem.findBySystemAndStatusIsNotNull(sys)
            sysStatus[sys] = item;

        }
        [systems: systems,
         status: StatusItem.list(offset: params.offset, max: 25, order: "date"),
         sysStatus: sysStatus]
    }

    def index() { redirect( action:status ) }
}
