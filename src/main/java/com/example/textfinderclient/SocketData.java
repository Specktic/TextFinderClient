package com.example.textfinderclient;

import java.io.*;

/** data to be sent to server */
public class SocketData implements Serializable{
    /** constructor */
    public SocketData(String data){
        if (data != null){
            l = data.length();
            d = data;
        }
    }
    /** attribute 1, a string */
    private String d;

    /** attribute 2, an int */
    private int l;

    /** method for reading data fluxes as strings */
    public String toString(){
        String d1;
        d1 = d;
        return d1;

    }

    /** method for writing attributes as a DataOutputStream */
    public void writeObject(DataOutputStream out) throws IOException{
        out.writeInt (l+1);
        out.writeBytes(d);
        out.writeByte('\0');
    }

    /** method for reading the attributes of a DataInputStream */
    public void readObject(DataInputStream in) throws IOException{
        l = in.readInt() - 1;
        byte [] aux = null;

        aux = new byte[l];              // byte array size
        in.read(aux, 0, l);         // Reads bytes
        d = new String (aux);           // turns into a string
        in.read(aux,0,1);       // reads \0
    }
}
