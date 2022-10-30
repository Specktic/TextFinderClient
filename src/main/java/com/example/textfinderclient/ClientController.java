package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    /** Attribute 1, a JavaFX TextField */
    @FXML
    private TextField searchField;

    /** Attribute 2, a client object */
    private Socket client;

    /** Asks the server to add a given file to the TextsLibrary directory */
    public void addFile() {
    }

    /** Gets the text from the TextField and sends it to the server for searching */
    public void search() {

        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        try {

            inputStreamReader = new InputStreamReader(client.getInputStream());
            outputStreamWriter = new OutputStreamWriter(client.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String search = searchField.getText();

            bufferedWriter.write(search);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println(bufferedReader.readLine());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            client = new Socket("localhost", 6174);
            System.out.println("connected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}