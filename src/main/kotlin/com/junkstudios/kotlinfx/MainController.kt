package com.junkstudios.kotlinfx

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.VBox
import javafx.stage.Stage

class MainController {

    @FXML
    private lateinit var nameColumn: VBox

    @FXML
    private lateinit var numberColumn: VBox

    @FXML
    private lateinit var emailColumn: VBox

    @FXML
    private lateinit var instagramColumn: VBox

    @FXML
    private lateinit var addressColumn: VBox

    private val contacts = ArrayList<Contact>()

    @FXML
    private fun addNewContactAction() { // TODO KILL NIGGAS
        val stage = Stage()
        val fxmlLoader = FXMLLoader(this.javaClass.getResource("configurator-view.fxml"))
        val root = fxmlLoader.load<VBox>()

        val controller = fxmlLoader.getController<ConfiguratorController>() // we need to manually get
        controller.stage = stage                                            // configuration controller to add
        controller.fieldToVBox = mapOf(                                     // entered data into main stage
            controller.nameField      to nameColumn.children,
            controller.numberField    to numberColumn.children,
            controller.emailField     to emailColumn.children,
            controller.instagramField to instagramColumn.children,
            controller.addressField   to addressColumn.children
        )
        controller.contactsList = contacts

        stage.scene = Scene(root)
        stage.title = "New Contact"
        stage.show()
    }

    @FXML
    private fun deleteSelectedContactsAction() {
        deleteLogic()
    }

    private fun deleteLogic() {
        for (contact in contacts)
            if (contact.isActive) {
                nameColumn.children.remove(contact.name)
                numberColumn.children.remove(contact.number)
                emailColumn.children.remove(contact.email)
                instagramColumn.children.remove(contact.instagram)
                addressColumn.children.remove(contact.address)
            }
    }

}