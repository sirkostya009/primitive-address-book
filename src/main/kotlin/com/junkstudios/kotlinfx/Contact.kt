package com.junkstudios.kotlinfx

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderWidths
import javafx.scene.paint.Color

class Contact(
    val name: Label,
    val number: Label,
    val email: Label,
    val instagram: Label,
    val address: Label) {

    var isActive = false

    init {
        val filter = EventHandler<MouseEvent> {
            isActive = !isActive

            setStyle(name)
            setStyle(number)
            setStyle(email)
            setStyle(instagram)
            setStyle(address)
        }

        name.addEventFilter(MouseEvent.MOUSE_CLICKED, filter)
        number.addEventFilter(MouseEvent.MOUSE_CLICKED, filter)
        email.addEventFilter(MouseEvent.MOUSE_CLICKED, filter)
        instagram.addEventFilter(MouseEvent.MOUSE_CLICKED, filter)
        address.addEventFilter(MouseEvent.MOUSE_CLICKED, filter)
    }

    fun contains(label: Label): Boolean {
        if (name == label) return true
        if (number == label) return true
        if (email == label) return true
        if (instagram == label) return true
        if (address == label) return true
        return false
    }

    private fun setStyle(to: Label) {
        if (isActive)
            to.style = "-fx-border-color: #f00"
        else to.style= "-fx-border-color: transparent"
    }
}