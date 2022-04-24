package com.junkstudios.kotlinfx

import javafx.fxml.FXML
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

    lateinit var master: MainController

    @FXML
    private fun createAction() { // creates a new contact and adds it to main controller
        val contact = Contact(
            Label(nameField.text),
            Label(numberField.text),
            Label(emailField.text),
            Label(instagramField.text),
            Label(addressField.text)
        )

        master.addContact(contact)
        stage.close()
    }

    @FXML
    private fun cancelAction() {
        stage.close()
    }

}