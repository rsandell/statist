import com.sonymobile.swdtools.statist.*
import grails.util.Environment

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
				def Gerrit = new System(name: "Gerrit", prio: 1, archived: 0).save()
				def Jenkins = new System(name: "Jenkins", prio: 1, archived: 0).save()
				def CrashTool = new System(name: "CrashTool", prio: 3, archived: 0).save()
				def ClearCase = new System(name: "ClearCase", prio: 1, archived: 1).save()
				def TagGerrit = new Tag(name: "GERRIT").save()
				def TagJenkins = new Tag(name: "JENKINS").save()
				def TagSeld = new Tag(name: "SELD").save()
				def TagJpto = new Tag(name: "JPTO").save()
				def TagCnbj = new Tag(name: "CNBJ").save()
				def StatusOk = new Status(name: "Ok", severity: 10).save()
				def Status1 = new Status (name: "1", severity: 1).save()
				def Status2 = new Status (name: "2", severity: 2).save()
				def Status3 = new Status (name: "3", severity: 3).save()
				def Status4 = new Status (name: "4", severity: 4).save()
				def Status5 = new Status (name: "5", severity: 5).save()
				def Status01 = new StatusItem(system: Gerrit, text: "Replication issue 01", tag: TagSeld, date: new Date(), status: Status4).save()
				def Status02 = new StatusItem(system: Gerrit, text: "Replication issue 02", tag: TagSeld, date: new Date(), status: Status4).save()
				def Status03 = new StatusItem(system: Gerrit, text: "Replication issue 03", tag: TagJpto, date: new Date(), status: Status4).save()
				def Status04 = new StatusItem(system: Gerrit, text: "Replication issue 04", tag: TagJpto, date: new Date(), status: Status4).save()
				def Status05 = new StatusItem(system: Jenkins, text: "Build issue 05", tag: TagSeld, date: new Date(), status: Status5).save()
				def Status06 = new StatusItem(system: Jenkins, text: "Uptime issue 06", tag: TagJpto, date: new Date(), status: Status2).save()
				def Status07 = new StatusItem(system: Jenkins, text: "Uptime issue 07", tag: TagCnbj, date: new Date(), status: Status1).save()
				def Status08 = new StatusItem(system: Gerrit, text: "Replication issue 08", tag: TagSeld, date: new Date(), status: Status3).save()

                break
			case Environment.PRODUCTION:
				break
        }
        //Security
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def adminUser = User.findByUsername('admin') ?: new User(
                username: 'admin',
                //password: springSecurityService.encodePassword('admin'),
                password: 'admin',
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole, true
        }

    }
    def destroy = {
    }
}
