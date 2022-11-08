package it.fi.meucci;


public class Biglietto {

    private static int PRG=1;
    int ID;
    String infoB;

    public Biglietto(String s){
    infoB= s;
    this.up();
    }    
    
    private void up(){
        this.ID=PRG;
        PRG++;
    }


    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getInfoB() {
        return infoB;
    }

    public void setInfoB(String infoB) {
        this.infoB = infoB;
    }

    @Override
    public String toString() {
        return "Biglietto [ID=" + ID + ", infoB=" + infoB + "]";
    }



   
}
