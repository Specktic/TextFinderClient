module com.example.textfinderclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textfinderclient to javafx.fxml;
    exports com.example.textfinderclient;
}