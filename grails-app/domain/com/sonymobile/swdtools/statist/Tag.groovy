package com.sonymobile.swdtools.statist


class Tag {
    String name

    static constraints = {
		name blank: false
    }

    String toString() {name}
}
