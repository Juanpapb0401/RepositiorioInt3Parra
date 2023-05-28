package model;

import java.util.Calendar;

public abstract class ProductoBiblio {
    
    private String name;
    private String id;
    private int numPages;
    private Calendar datePublication;
    private String uRL;
    private double price;
    private int numPagesRead;
    private int pagesReadTemp;


   

    public ProductoBiblio(String name, String id, int numPages, Calendar datePublication, String uRL, double price, int numPagesRead) {

        this.name = name;
        this.id = id;
        this.numPages = numPages;
        this.datePublication = datePublication;
        this.uRL = uRL;
        this.price = price;
        this.numPagesRead = numPagesRead;
        this.pagesReadTemp =1;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public int getNumPages() {
        return numPages;
    }


    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }


    public Calendar getDatePublication() {
        return datePublication;
    }


    public void setDatePublication(Calendar datePublication) {
        this.datePublication = datePublication;
    }


    public String getuRL() {
        return uRL;
    }


    public void setuRL(String uRL) {
        this.uRL = uRL;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumPagesRead() {
        return numPagesRead;
    }


    public void setNumPagesRead(int numPagesRead) {
        this.numPagesRead = numPagesRead;
    }

   
    public void addPagesRead(){
        this.numPagesRead +=1;
    }

    public void addPagesReadTemp(){
        this.pagesReadTemp += 1;

    }

    public void removePagesReadTemp(){

        this.pagesReadTemp -= 1;

    }

    public void setPagesReadTempFinal(){

        this.pagesReadTemp = 1;

    }

    public int getPagesReadTemp() {
        return pagesReadTemp;
    }


    public void setPagesReadTemp(int pagesReadTemp) {
        this.pagesReadTemp = pagesReadTemp;
    }


}
