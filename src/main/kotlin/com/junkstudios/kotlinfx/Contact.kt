package com.junkstudios.kotlinfx

import javafx.scene.control.Label

class Contact(
    val name: Label,
    val number: Label,
    val email: Label,
    val instagram: Label,
    val address: Label) {

    fun contains(label: Label): Boolean {
        if (name == label) return true
        if (number == label) return true
        if (email == label) return true
        if (instagram == label) return true
        if (address == label) return true
        return false
    }
}