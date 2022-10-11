package com.example.textfinderclient;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    FileManager fl = new FileManager();

    public void openSearch() throws IOException {
        fl.AddToLibrary();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}