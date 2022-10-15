package com.example.textfinderclient;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibraryManagement {

    //class constructor
    public LibraryManagement(){}

    //class methods
    public void addToLibrary() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("Texts"));
        File text = fc.showOpenDialog(null);
        if (text != null){
            Path textName = Paths.get(String.valueOf(text));
            Path libraryName = Paths.get("TextsLibrary" + "\\" + text.getName());
            if (!((libraryName.toFile()).exists())){    //text file to add isn't already in library
                Files.copy(textName, libraryName);
            } else {                                    //text file to add is already in library
                int i = 1;
                Path altName = Paths.get("TextsLibrary" + "\\" +
                        text.getName() + " (" + String.valueOf(i) + ")");   //adds repeat file suffix
                while ((altName.toFile().exists())){
                    i++;
                    altName = Paths.get("TextsLibrary" + "\\" +
                            text.getName() + " (" + String.valueOf(i) + ")");   //updates repeat file suffix
                }
                Files.copy(textName, altName);
            }
        } else {
            System.out.println("no file selected");
        }
    }

    public void removeFromLibrary(){

    }
}
