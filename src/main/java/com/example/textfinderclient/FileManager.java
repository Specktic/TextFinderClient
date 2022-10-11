package com.example.textfinderclient;
import javafx.stage.FileChooser;

import java.io.*;

public class FileManager {

    //class constructor
    public FileManager(){}

    //class methods
    public void AddToLibrary() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("TextsLibrary"));
        File text = fc.showOpenDialog(null);
        File opText = new File("TextsLibrary");
        System.out.println(text);
        System.out.println(opText);
    }
}
