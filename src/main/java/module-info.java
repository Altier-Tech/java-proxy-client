module tech.altier.JProxyClient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jackson.databind;
    requires jackson.core;
    requires javafx.web;
//    requires javafx.media;
//    requires javafx.web;

    opens tech.altier.JProxyClient to javafx.fxml;
    exports tech.altier.JProxyClient;
}