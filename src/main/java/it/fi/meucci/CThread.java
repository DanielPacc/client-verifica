package it.fi.meucci;

import java.io.*;
import java.net.*;
import java.util.*;

import java.net.Socket;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CThread extends Thread {
    ServerSocket server = null;
    Socket socket = null;
    String stringaRicevuta = null;
    BufferedReader indalClient;
    DataOutputStream outversoClient;
    ObjectMapper mapper;
    Messaggio msg;

    ArrayList <Biglietto> Big = new ArrayList();


    public CThread(Socket s) throws Exception {
        socket = s;
        mapper = new ObjectMapper();
        indalClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outversoClient = new DataOutputStream(socket.getOutputStream());
    
    }

    public void run() {
        try {
            stringaRicevuta = indalClient.readLine();
            Messaggio B = mapper.readValue(stringaRicevuta,Messaggio.class);
            System.out.println("ricevuto: " + B.toString());

            String str=indalClient.readLine();
            System.out.print(str);
        } catch (Exception e) {
        }
        
    }

}