module tech.altier.jproxyclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens tech.altier.jproxyclient to javafx.fxml;
    exports tech.altier.jproxyclient;
}