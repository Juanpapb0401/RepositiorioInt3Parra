package model;

import java.util.Calendar;

public class Regular extends User{

    private String[][] matrixRegular;
    private int booksSell;
    private int magazineSell;

    public int getBooksSell() {
        return booksSell;
    }

    public void setBooksSell(int booksSell) {
        this.booksSell = booksSell;
    }

    public int getMagazineSell() {
        return magazineSell;
    }

    public void setMagazineSell(int magazineSell) {
        this.magazineSell = magazineSell;
    }

    public Regular(String nameUser, String iD, Calendar dateVincu) {
        super(nameUser, iD, dateVincu);
        this.matrixRegular=new String[5][5];
        
    }

    public String[][] getMatrixRegular() {
        return matrixRegular;
    }

    public void setMatrixRegular(String[][] matrixRegular) {
        this.matrixRegular = matrixRegular;
    }



    
    
}
