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
        controller.master = this

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
                removeContact(contact)
    }

    private fun removeContact(contact: Contact) {
        println("removing contact...")
        nameColumn.children.remove(contact.name)
        numberColumn.children.remove(contact.number)
        emailColumn.children.remove(contact.email)
        instagramColumn.children.remove(contact.instagram)
        addressColumn.children.remove(contact.address)
    }

    fun addContact(contact: Contact) {
        nameColumn.children += contact.name
        numberColumn.children += contact.number
        emailColumn.children += contact.email
        instagramColumn.children += contact.instagram
        addressColumn.children += contact.address

        if (!contacts.contains(contact)) contacts += contact
    }

    @FXML
    private fun filterQueries() {
        val nameFilter = (nameColumn.children[0] as TextField).text
        val numberFilter = (numberColumn.children[0] as TextField).text
        val emailFilter = (emailColumn.children[0] as TextField).text
        val instagramField = (instagramColumn.children[0] as TextField).text
        val addressFilter = (addressColumn.children[0] as TextField).text

        if (nameFilter.isEmpty() && numberFilter.isEmpty() && emailFilter.isEmpty() && instagramField.isEmpty() && addressFilter.isEmpty())
            for (contact in contacts) addContact(contact)

        for (contact in contacts) {
            val name = contact.name.text
            val number = contact.number.text
            val email = contact.email.text
            val instagram = contact.instagram.text
            val address = contact.address.text

            if (!name.contains(nameFilter, ignoreCase = true)) // i really don't like the hardcoding here,
                removeContact(contact)      // better find a more handy way to do this
            else if (!number.contains(numberFilter, ignoreCase = true))
                removeContact(contact)
            else if (!email.contains(emailFilter, ignoreCase = true))
                removeContact(contact)
            else if (!instagram.contains(instagramField, ignoreCase = true))
                removeContact(contact)
            else if (!address.contains(addressFilter, ignoreCase = true))
                removeContact(contact)
        }
    }
}