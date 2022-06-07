module com.otan.dijkstra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dijkstra to javafx.fxml;
    exports com.dijkstra;
    exports com.dijkstra.javafx;
    opens com.dijkstra.javafx to javafx.fxml;
}