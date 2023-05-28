package model;

import java.util.ArrayList;
import java.util.Calendar;


public abstract class User {

    private String nameUser;
    private String iD;
    private Calendar dateVincu;
    private ArrayList<Transaction> transactionUser;
    private ArrayList<ProductoBiblio> productsUser;

    
    public User(String nameUser, String iD, Calendar dateVincu) {
        
        this.nameUser = nameUser;
        this.iD = iD;
        this.dateVincu = dateVincu;
        this.transactionUser=new ArrayList<Transaction>();
        this.productsUser = new ArrayList<ProductoBiblio>();

    }

   

    public ArrayList<Transaction> getTransactionUser() {
        return transactionUser;
    }

    public void setTransactionUser(ArrayList<Transaction> transactionUser) {
        this.transactionUser = transactionUser;
    }

    public ArrayList<ProductoBiblio> getProductsUser() {
        return productsUser;
    }

    public void setProductsUser(ArrayList<ProductoBiblio> productsUser) {
        this.productsUser = productsUser;
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
