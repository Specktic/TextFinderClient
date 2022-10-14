package com.example.textfinderclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * A class for establishing server connection and reading server data
 */
public class ClientSocket{
    public static void main(String[] args){
        new ClientSocket();
    }

    /**
     * creates the client socket and reads data
     */
    public ClientSocket(){
        try{
            /* FX controller object */
            ClientController cntrl = new ClientController();

            /* a client socket is created */
            Socket cs = new Socket("localhost", 87312);
            System.out.println("connected to server");

            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* gets a reading stream for object reading */
            DataInputStream bufferedIn = new DataInputStream(cs.getInputStream());

            /* data flux for sending data to server */
            DataOutputStream bufferSalida =
                    new DataOutputStream (cs.getOutputStream());

            /* data is written on the output flux */
            SocketData aux = new SocketData (cntrl.search());
            aux.writeObject (bufferSalida);

            System.out.println ("sent: " + aux.toString());

        } catch (Exception e){
            e.printStackTrace();
        }

    }


}
