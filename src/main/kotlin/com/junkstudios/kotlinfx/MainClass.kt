package com.junkstudios.kotlinfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
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