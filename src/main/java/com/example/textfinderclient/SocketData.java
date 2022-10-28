package com.example.textfinderclient;
import java.io.*;

public class SocketData implements Serializable{
    /** Class constructor */
    public SocketData(String data){
        if (data != null){
            this.len = data.length();
            this.word = data;
        }
    }

    /** Attribute 1, a string */
    private String word;

    /** Attribute 2, an int */
    private int len;

    /** Returns data fluxes as strings */
    public String toString(){
        String word1;
        word1 = word;
        return word1;

    }

    /** Writes the word attribute to the data output flux */
    public void writeObject(DataOutputStream out) throws IOException{
        out.writeInt (len +1);
        out.writeBytes(word);
        out.writeByte('\0');
    }

    /** Reads the incoming data from the data input flux */
    public void readObject(DataInputStream in) throws IOException{
        len = in.readInt() - 1;
        byte [] aux;

        aux = new byte[len];           // byte array size
        in.read(aux, 0, len);      // Reads bytes
        word = new String (aux);       // turns into a string
        in.read(aux,0,1);      // reads \0
    }
}
