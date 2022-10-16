package com.example.textfinderclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * A class for establishing server connection and reading server data
 */
public class CSocket {
    public void communicate(String outputFlux){
        try {
            /* client socket is created */
            Socket cs = new Socket("localhost", 6174);
            System.out.println("connected to server");

            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* data fluxes for sending and receiving data */
            DataOutputStream bufferOut = new DataOutputStream(cs.getOutputStream());
            DataInputStream bufferIn = new DataInputStream(cs.getInputStream());

            /* data is written on the output flux */
            SocketData auxOut = new SocketData (outputFlux);
            auxOut.writeObject(bufferOut);

            /* prints data sent to console */
            System.out.println ("sent: " + auxOut.toString());

            /* incoming data from the server is read */
            SocketData auxIn = new SocketData("");
            auxIn.readObject(bufferIn);

            /* prints incoming data to console  */
            System.out.println("received: " + auxIn.toString());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
