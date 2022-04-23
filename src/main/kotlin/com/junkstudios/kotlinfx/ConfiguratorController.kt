package com.junkstudios.kotlinfx

import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage

class ConfiguratorController {

    @FXML
     lateinit var nameField: TextField

    @FXML
     lateinit var numberField: TextField

    @FXML
     lateinit var emailField: TextField

    @FXML
     lateinit var instagramField: TextField

    @FXML
     lateinit var addressField: TextField

    lateinit var stage: Stage

    lateinit var fieldToVBox: Map<TextField, ObservableList<Node>>

    @FXML
    private fun createAction() { // creates a new contact and appends it to the list
        val contact = Contact(
            Label(nameField.text),
            Label(numberField.text),
            Label(emailField.text),
            Label(instagramField.text),
            Label(addressField.text)
        )

        fieldToVBox[nameField]?.add(contact.name)
        fieldToVBox[numberField]?.add(contact.number)
        fieldToVBox[emailField]?.add(contact.email)
        fieldToVBox[instagramField]?.add(contact.instagram)
        fieldToVBox[addressField]?.add(contact.address)
    }

    @FXML
    private fun cancelAction() {
        stage.close()
    }

}