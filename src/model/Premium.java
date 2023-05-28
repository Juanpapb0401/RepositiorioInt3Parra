package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Premium extends User{

    private ArrayList<String[][]> matrixPremium;

    public Premium(String nameUser, String iD, Calendar dateVincu) {
        super(nameUser, iD, dateVincu);
        this.matrixPremium=new ArrayList<String[][]>();
        
    }

    public ArrayList<String[][]> getMatrixPremium() {
        return matrixPremium;
    }

    public void setMatrixPremium(ArrayList<String[][]> matrixPremium) {
        this.matrixPremium = matrixPremium;
    }



    
    
}
