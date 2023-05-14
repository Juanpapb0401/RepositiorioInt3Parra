package model;

import java.util.Calendar;

public class Magazine extends ProductoBiblio{
   
    private String periodicalEmission;
    private int numSuscripActives;
    private Category category;

    public Magazine(String name, String id, int numPages, Calendar datePublication, String uRL, double price,int numPagesRead, String periodicalEmission, int numSuscripActives, Category category) {
        
        super(name, id, numPages, datePublication, uRL, price, numPagesRead);
        this.periodicalEmission = periodicalEmission;
        this.numSuscripActives = 0;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPeriodicalEmission() {
        return periodicalEmission;
    }

    public void setPeriodicalEmission(String periodicalEmission) {
        this.periodicalEmission = periodicalEmission;
    }

    public int getNumSuscripActives() {
        return numSuscripActives;
    }

    public void setNumSuscripActives(int numSuscripActives) {
        this.numSuscripActives = numSuscripActives;
    }

    

    
}
