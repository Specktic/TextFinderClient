package com.example.textfinderclient;
import java.io.File;

public class FileManager {
    //class attributes
    private String file;

    //class constructor
    public FileManager(String File){
        this.file = File;
    }

    //class methods
    public String getFile() {return file;}
    public void setFile(String file) {this.file = file;}

    public void moveFile(String file){
        File originalFile = new File(file);

    }


}
