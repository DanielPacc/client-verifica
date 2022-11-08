package it.fi.meucci;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Messaggio {

    ArrayList <Biglietto> bgl = new ArrayList();

    public Messaggio (@JsonProperty("bgl") ArrayList <Biglietto> bgl) 
    {
        this.bgl=bgl;
    }

    public ArrayList<Biglietto> getBgl() {
        return bgl;
    }

    public void setBgl(ArrayList<Biglietto> bgl) {
        this.bgl = bgl;
    }
    @Override
    public String toString() {
        String r="";
        for (int i=0; i<bgl.size();i++){
            r=r+bgl.get(i).toString();
        }
        return r;
    }
    

    
}