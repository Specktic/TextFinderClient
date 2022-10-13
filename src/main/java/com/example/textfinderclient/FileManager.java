package com.example.textfinderclient;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    //class constructor
    public FileManager(){}

    //class methods
    public void AddToLibrary() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("Texts"));
        File text = fc.showOpenDialog(null);
        if (text != null){
            Path textName = Paths.get(String.valueOf(text));
            Path libraryName = Paths.get("TextsLibrary" + "\\" + text.getName());

            if (!((libraryName.toFile()).exists())){
                Files.copy(textName, libraryName);
            } else {
                int i = 1;
                Path altName = Paths.get("TextsLibrary" + "\\" + text.getName()
                        + " (" + String.valueOf(i) + ")");
                while ((altName.toFile().exists())){
                    i++;
                    altName = Paths.get("TextsLibrary" + "\\" + text.getName()
                            + " (" + String.valueOf(i) + ")");
                }
                Files.copy(textName, altName);
            }
        } else {
            System.out.println("no file selected");
        }
    }
}
