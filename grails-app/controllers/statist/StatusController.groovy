package statist

import com.sonymobile.swdtools.statist.StatusItem
import com.sonymobile.swdtools.statist.System

class StatusController {

    def status = {
        [systems: System.list(sort: "prio", order: "desc"),
         status: StatusItem.list(offset: params.offset, max: 25, order: "date")]
    }

    def index() { redirect( action:status ) }
}
