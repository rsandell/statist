package com.sonymobile.swdtools.statist

class StatusItem {
	String	text
	Date	date = new Date()

	static	hasOne = [status: Status]

	static	hasMany = [tag: Tag]

	static	belongsTo = [system: System]

    static	constraints = {
		text blank: false
		date blank: false
    }
}
