package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{   
    static CThread DT;
    static ObjectMapper OM;
    static BufferedReader indal;
    static DataOutputStream outverso;

    public static void main( String[] args )
    {
        try{

        OM = new ObjectMapper();
        Socket s = new Socket("localhost", 6789);

        indal = new BufferedReader(new InputStreamReader(s.getInputStream()));
        outverso = new DataOutputStream(s.getOutputStream());

       DT= new CThread(s);
       DT.start();
        
       while(true){
        try {
            String Manda = OM.writeValueAsString(DT.msg);
            outverso.writeBytes(Manda+"\n");


            
            
            String in=indal.readLine();

            outverso.writeBytes(in);
            
            // Invia il messaggio*/
            
        } catch (Exception e){
            break;
        }
    }

    DT.interrupt();
    DT.join();
    
    }catch(Exception e){}
}
}
