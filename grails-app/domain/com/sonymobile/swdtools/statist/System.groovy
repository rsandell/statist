package com.sonymobile.swdtools.statist

class System {
    String name
    int prio
    boolean archived

    static hasMany = [tags: Tag]

    static constraints = {
		name blank:false
		prio blank: false
		archived blank: false
    }
    String toString() {name}
}
