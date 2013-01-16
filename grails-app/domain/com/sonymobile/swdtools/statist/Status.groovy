package com.sonymobile.swdtools.statist

class Status {
	String	name
	int		severity

	static hasMany = [statusitem: StatusItem]

    static constraints = {
		name blank: false
		severity blank: false
    }
}
