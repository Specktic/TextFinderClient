package com.example.textfinderclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * A class for establishing server connection and reading server data
 */
public class ClientSocket{
    public void send(String outputFlux){
        try {
            /* client socket is created */
            Socket cs = new Socket("localhost", 6174);
            System.out.println("connected to server");

            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* data flux for sending data to server */
            DataOutputStream bufferSalida = new DataOutputStream (cs.getOutputStream());

            /* data is written on the output flux */
            SocketData aux = new SocketData (outputFlux);
            aux.writeObject (bufferSalida);

            /* prints data sent to console */
            System.out.println ("sent: " + aux.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
