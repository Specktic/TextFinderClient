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

    private Socket cs;


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

    public void receive(){
        try {
            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* data flux for receiving data */
            DataInputStream bufferIn = new DataInputStream(cs.getInputStream());

            /* incoming data from the server is read */
            SocketData auxIn = new SocketData("");
            auxIn.readObject(bufferIn);

            /* prints incoming data to console  */
            System.out.println("received: " + auxIn);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
