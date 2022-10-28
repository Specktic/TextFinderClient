package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    /** Attribute 1, a JavaFX TextField */
    @FXML
    private TextField searchField;

    /** Attribute 2, a client object */
    private Client client;

    /** Asks the server to add a given file to the TextsLibrary directory */
    public void addFile() {
    }

    /** Gets the text from the TextField and sends it to the server for searching */
    public void search(){
        String search = searchField.getText();
        if (!search.isEmpty()) {
            client.send(search);
            searchField.clear();
            //client.receive();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            client = new Client(new Socket("localhost", 6174));
            System.out.println("connected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}