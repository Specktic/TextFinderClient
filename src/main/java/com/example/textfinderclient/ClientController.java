package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private File[] libraryFiles = textLibrary.listFiles();
    private LibraryManagement lm = new LibraryManagement();
    private CSocket cs = new CSocket();

    public void addFile() throws IOException {
        lm.addToLibrary();
    }

    public void search(){
        cs.send(searchValue.getText());
        cs.receive();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i = 0;
        while (i < libraryFiles.length){
            library.getItems().add(libraryFiles[i].getName());
            i++;
        }
    }
}