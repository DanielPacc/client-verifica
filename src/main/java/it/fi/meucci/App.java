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
    static BufferedReader reader;
    static DataOutputStream writer;

    public static void main( String[] args )
    {
        try{

        OM = new ObjectMapper();
        Socket s = new Socket("localhost", 6789);

        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer = new DataOutputStream(s.getOutputStream());

       DT= new CThread(s);
       DT.start();
        
       while(true){
        try {
            String Manda = OM.writeValueAsString(DT.msg);
            writer.writeBytes(Manda+"\n");

            
            System.out.print("Scrivi quanti biglietti vuoi comprare: ");
            //writer.writeBytes("\n");
            reader.readLine();
            /*Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            
            
            Biglietto msg = new Biglietto(str);
            String toSend = OM.writeValueAsString(msg);
            
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
