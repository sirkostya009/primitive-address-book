module com.junkstudios.kotlinfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.junkstudios.kotlinfx to javafx.fxml;
    exports com.junkstudios.kotlinfx;
}