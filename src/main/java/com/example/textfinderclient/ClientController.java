package com.example.textfinderclient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    /** Attribute 1, a JavaFX TextField */
    @FXML
    private TextField searchField;

    /** Attribute 1, a JavaFX TextField */
    @FXML
    private ListView results;

    /** Attribute 3, a client object */
    private Socket client;

    /** Gets the text from the TextField, sends it to the server for searching and reads the result */
    public void search() {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            inputStreamReader = new InputStreamReader(client.getInputStream());
            outputStreamWriter = new OutputStreamWriter(client.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String search = searchField.getText();

            bufferedWriter.write(search);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String results = bufferedReader.readLine();

            this.results.getItems().add(results);

            System.out.println(results);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addFile() {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        FileChooser fc = new FileChooser();

        fc.setInitialDirectory(new File("Texts"));
        File file = fc.showOpenDialog(null);

        if (file != null) {

            String filePath = file.getName();

            try {

                inputStreamReader = new InputStreamReader(client.getInputStream());
                outputStreamWriter = new OutputStreamWriter(client.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(filePath);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println(bufferedReader.readLine());

            } catch (Exception e){
                e.printStackTrace();
            }
        }

        else {
            System.out.println("No file selected");
        }
    }

    public void removeFile() {}

    public void initializeLibrary() {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            inputStreamReader = new InputStreamReader(client.getInputStream());
            outputStreamWriter = new OutputStreamWriter(client.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("@LOAD@");
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