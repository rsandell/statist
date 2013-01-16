package com.sonymobile.swdtools.statist

class Tag {
	String name

	static belongsTo = [system: System]

    static constraints = {
		name blank: false
    }
}
