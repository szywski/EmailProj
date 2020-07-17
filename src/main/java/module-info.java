module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;
    requires slf4j.api;
    requires slf4j.simple;


    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}