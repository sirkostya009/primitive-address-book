package com.junkstudios.kotlinfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.stage.Stage

class MainClass : Application() {
    override fun start(stage: Stage) {
        stage.scene = Scene(FXMLLoader(this.javaClass.getResource("main-view.fxml")).load())
        stage.title = "Contact book"
        stage.show()
    }
}

fun main() {
    Application.launch(MainClass::class.java)
}