package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private ListView library = new ListView();
    private File textLibrary = new File("TextsLibrary");
    private File[] libraryContent = textLibrary.listFiles();
    private FileManager fl = new FileManager();

    public void addText() throws IOException {
        fl.addToLibrary();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        library.getItems().addAll(libraryContent);
    }
}