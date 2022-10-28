package com.example.textfinderclient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/** A class for establishing server connection and reading server data */
public class Client {

    /** Class constructor */
    public Client(Socket socket) {
        this.cs = socket;
    }

    /** Attribute 1, a socket */
    private final Socket cs;

    /** Sends a given string to the server */
    public void send(String search){
        try {
            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* data flux for sending data */
            DataOutputStream bufferOut = new DataOutputStream(cs.getOutputStream());

            /* data is written on the output flux */
            SocketData auxOut = new SocketData(search);
            auxOut.writeObject(bufferOut);

            /* prints data sent to console */
            System.out.println ("sent: " + auxOut);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Reads incoming data from the server */
    public String receive() throws IOException {
        /* waits for client to read data */
        cs.setSoLinger(true, 10);

        /* data flux for receiving data from client */
        DataInputStream bufferIn = new DataInputStream (cs.getInputStream());

        /* object to be read is created and assigned data from the flux */
        SocketData auxIn = new SocketData("");
        auxIn.readObject (bufferIn);

        System.out.println ("received: " + auxIn);
        return auxIn.toString();
    }
}
