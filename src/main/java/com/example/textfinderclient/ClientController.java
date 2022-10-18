package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private TextField searchValue;
    private CSocket cs = new CSocket();

    public void addFile() {
    }

    public void search(){
        cs.sendString(searchValue.getText());
        cs.receive();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}