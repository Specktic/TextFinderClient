package com.example.textfinderclient;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public void openSearch(){
        FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}