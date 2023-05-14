package model;

import java.util.Calendar;

public abstract class User {

    private String nameUser;
    private String iD;
    private Calendar dateVincu;
    
    public User(String nameUser, String iD, Calendar dateVincu) {
        
        this.nameUser = nameUser;
        this.iD = iD;
        this.dateVincu = dateVincu;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public Calendar getDateVincu() {
        return dateVincu;
    }

    public void setDateVincu(Calendar dateVincu) {
        this.dateVincu = dateVincu;
    }

    
    



}
