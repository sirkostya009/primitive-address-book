package com.junkstudios.kotlinfx

import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.HBox
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

    @FXML
    private fun addNewContactAction() {
        val stage = Stage()
        val fxmlLoader = FXMLLoader(this.javaClass.getResource("configurator-view.fxml"))
        stage.scene = Scene(fxmlLoader.load())

        val controller = fxmlLoader.getController<ConfiguratorController>()
        controller.stage = stage
        controller.fieldToVBox = mapOf(
            controller.nameField      to nameColumn.children,
            controller.numberField    to numberColumn.children,
            controller.emailField     to emailColumn.children,
            controller.instagramField to instagramColumn.children,
            controller.addressField   to addressColumn.children
        )

        stage.title = "New Contact"
        stage.show()
    }

    @FXML
    private fun deleteSelectedContactsAction() {
    }

}