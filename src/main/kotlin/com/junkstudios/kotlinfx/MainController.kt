package com.junkstudios.kotlinfx

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.TextField
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
    private fun addNewContactAction() {
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
        deleteSelectedContacts()
    }

    private fun deleteSelectedContacts() {
        for (contact in contacts)
            if (contact.isActive)
                deleteIndividualContact(contact)
    }

    private fun deleteIndividualContact(contact: Contact) {
        println("removing contact...")
        nameColumn.children.remove(contact.name)
        numberColumn.children.remove(contact.number)
        emailColumn.children.remove(contact.email)
        instagramColumn.children.remove(contact.instagram)
        addressColumn.children.remove(contact.address)
    }

    @FXML
    private fun filterQueries() {
        println("nigga?")
        val nameFilter = (nameColumn.children[0] as TextField).text
        val numberFilter = (numberColumn.children[0] as TextField).text
        val emailFilter = (emailColumn.children[0] as TextField).text
        val instagramField = (instagramColumn.children[0] as TextField).text
        val addressFilter = (addressColumn.children[0] as TextField).text

        if (nameFilter.isEmpty() && numberFilter.isEmpty() && emailFilter.isEmpty() && instagramField.isEmpty() && addressFilter.isEmpty())
            for (contact in contacts) {
                nameColumn.children += contact.name
                numberColumn.children += contact.number
                emailColumn.children += contact.email
                instagramColumn.children += contact.instagram
                addressColumn.children += contact.address
            }

        for (contact in contacts)
            if (!contact.name.text.contains(nameFilter, ignoreCase = true))
                deleteIndividualContact(contact)
            else if (!contact.number.text.contains(numberFilter, ignoreCase = true))
                deleteIndividualContact(contact)
            else if (!contact.email.text.contains(emailFilter, ignoreCase = true))
                deleteIndividualContact(contact)
            else if (!contact.instagram.text.contains(instagramField, ignoreCase = true))
                deleteIndividualContact(contact)
            else if (!contact.address.text.contains(addressFilter, ignoreCase = true))
                deleteIndividualContact(contact)
    }
}