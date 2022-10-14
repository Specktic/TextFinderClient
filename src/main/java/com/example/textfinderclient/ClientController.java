package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private ListView library;
    @FXML
    private TextField searchValue;
    private File textLibrary = new File("TextsLibrary");
    private File[] libraryContent = textLibrary.listFiles();
    private LibraryManagement lm = new LibraryManagement();

    public void addText() throws IOException {
        lm.addToLibrary();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        library.getItems().addAll(libraryContent);
    }
}