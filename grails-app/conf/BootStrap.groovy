import com.sonymobile.swdtools.statist.*
import grails.util.Environment

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
                def tagGerrit = new Tag(name: "GERRIT")
                def tagJenkins = new Tag(name: "JENKINS")
                def tagCrashTool = new Tag(name: "CRASHTOOL")
                def tagClearCase = new Tag(name: "CLEARCASE")
                def tagSeld = new Tag(name: "SELD")
                def tagJpto = new Tag(name: "JPTO")
                def tagCnbj = new Tag(name: "CNBJ")
                tagGerrit.save()
                tagJenkins.save()
                tagSeld.save()
                tagJpto.save()
                tagCnbj.save()
                tagCrashTool.save()
                tagClearCase.save()

                def gerrit = new System(name: "Gerrit", prio: 1, archived: false, tags: [tagGerrit])
				def jenkins = new System(name: "Jenkins", prio: 4, archived: false, tags: [tagJenkins])
				def crashTool = new System(name: "CrashTool", prio: 2, archived: false, tags: [tagCrashTool])
				def clearCase = new System(name: "ClearCase", prio: 1, archived: false, tags: [tagClearCase])
				gerrit.save()
				jenkins.save()
				crashTool.save()
				clearCase.save()

				def c2d = new System(name: "c2d", prio: 5, archived: false)
				def dms = new System(name: "dms", prio: 5, archived: false)
				def mtbf = new System(name: "mtbf", prio: 3, archived: false)
				def idd = new System(name: "idd", prio: 5, archived: false)
				def licenseservers = new System(name: "licenseservers", prio: 5, archived: false)
				def sacco = new System(name: "sacco", prio: 3, archived: false)
				def flashgordon = new System(name: "flashgordon", prio: 2, archived: false)
				def semcbuild = new System(name: "semcbuild", prio: 5, archived: false)
				def qc = new System(name: "qc", prio: 4, archived: false)
				def afota = new System(name: "afota", prio: 5, archived: false)
				def source = new System(name: "source", prio: 5, archived: false)
				def emma = new System(name: "emma", prio: 5, archived: false)
				c2d.save()
				dms.save()
				mtbf.save()
				idd.save()
				licenseservers.save()
				sacco.save()
				flashgordon.save()
				semcbuild.save()
				qc.save()
				afota.save()
				source.save()
				emma.save()

				def StatusOk = new Status (name: "Ok", severity: 10)
				def Status1 = new Status (name: "1", severity: 1)
				def Status2 = new Status (name: "2", severity: 2)
				def Status3 = new Status (name: "3", severity: 3)
				def Status4 = new Status (name: "4", severity: 4)
				def Status5 = new Status (name: "5", severity: 5)
				StatusOk.save()
				Status1.save()
				Status2.save()
				Status3.save()
				Status4.save()
				Status5.save()

				def Status01 = new StatusItem(system: gerrit, text: "Replication issue 01", tag: tagSeld, date: new Date(), status: Status4)
				def Status02 = new StatusItem(system: gerrit, text: "Replication issue 02", tag: tagSeld, date: new Date(), status: Status4)
				def Status03 = new StatusItem(system: gerrit, text: "Replication issue 03", tag: tagJpto, date: new Date(), status: Status4)
				def Status04 = new StatusItem(system: gerrit, text: "Replication issue 04", tag: tagJpto, date: new Date(), status: Status4)
				def Status05 = new StatusItem(system: jenkins, text: "Build issue 05", tag: tagSeld, date: new Date(), status: Status5)
				def Status06 = new StatusItem(system: jenkins, text: "Uptime issue 06", tag: tagJpto, date: new Date(), status: Status2)
				def Status07 = new StatusItem(system: jenkins, text: "Uptime issue 07", tag: tagCnbj, date: new Date(), status: Status1)
				def Status08 = new StatusItem(system: gerrit, text: "Replication issue 08", tag: tagSeld, date: new Date(), status: Status3)
				Status01.save()
				Status02.save()
				Status03.save()
				Status04.save()
				Status05.save()
				Status06.save()
				Status07.save()
				Status08.save()

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

        new RequestMap(url: "/**", configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
        new RequestMap(url: "/system/**", configAttribute: 'ROLE_ADMIN').save()
        new RequestMap(url: "/tag/**", configAttribute: 'ROLE_ADMIN').save()
        new RequestMap(url: "/statusitem/**", configAttribute: 'ROLE_ADMIN').save()
        new RequestMap(url: "/user/**", configAttribute: 'ROLE_ADMIN').save()


    }
    def destroy = {
    }
}
