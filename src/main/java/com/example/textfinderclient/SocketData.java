package com.example.textfinderclient;
import java.io.*;

/** data to be sent to server */
public class SocketData implements Serializable{
    /** constructor 1 */
    public SocketData(String data){
        if (data != null){
            this.len = data.length();
            this.word = data;
        }
    }

    /** attribute 1, a string */
    private String word;

    /** attribute 2, an int */
    private int len;

    /** method for reading data fluxes as strings */
    public String toString(){
        String word1;
        word1 = word;
        return word1;

    }

    /** method for writing attributes as a DataOutputStream */
    public void writeObject(DataOutputStream out) throws IOException{
        out.writeInt (len +1);
        out.writeBytes(word);
        out.writeByte('\0');
    }

    /** method for reading the attributes of a DataInputStream */
    public void readObject(DataInputStream in) throws IOException{
        len = in.readInt() - 1;
        byte [] aux;

        aux = new byte[len];           // byte array size
        in.read(aux, 0, len);      // Reads bytes
        word = new String (aux);       // turns into a string
        in.read(aux,0,1);      // reads \0
    }
}
