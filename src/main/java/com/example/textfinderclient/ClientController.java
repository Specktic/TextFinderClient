package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private TextField searchField;
    private Client client;

    public void addFile() {
    }

    public void search(){
        String search = searchField.getText();
        if (!search.isEmpty()) {
            client.send(search);
            //client.receive();
            searchField.clear();
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