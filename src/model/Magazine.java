package model;

import java.util.Calendar;

public class Magazine extends ProductoBiblio{
   
    private String periodicalEmission;
    private int numSuscripActives;
    private Category category;
    private int paginasAdvertiM;
    private int paginasReadM;

    public void addPagesReadM(){
        this.paginasReadM +=1;
    }

    public int getPaginasAdvertiM() {
        return paginasAdvertiM;
    }

    public void setPaginasAdvertiM(int paginasAdvertiM) {
        this.paginasAdvertiM = paginasAdvertiM;
    }

    public int getPaginasReadM() {
        return paginasReadM;
    }

    public void setPaginasReadM(int paginasReadM) {
        this.paginasReadM = paginasReadM;
    }

    public Magazine(String name, String id, int numPages, Calendar datePublication, String uRL, double price,int numPagesRead, String periodicalEmission, int numSuscripActives, Category category) {
        
        super(name, id, numPages, datePublication, uRL, price, numPagesRead);
        this.periodicalEmission = periodicalEmission;
        this.numSuscripActives = 0;
        this.category = category;
        this.paginasAdvertiM =0;
        this.paginasReadM =1;
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

    public void calculateNewMagazines(){
		this.numSuscripActives +=1;
	}

    public boolean showAdvertisement(){

        if (paginasAdvertiM == 5){

            this.paginasAdvertiM =0;

            return true;
        }

        return false;
    }


    public void addPagesAdM(){
        this.paginasAdvertiM +=1;
    }

    public int compareToMagazine(Magazine o){

        if (this.getPaginasReadM()>o.getPaginasReadM()){

			return 1;

		}else if (this.getPaginasReadM()<o.getPaginasReadM()){

			return -1;
		}

        return 0;
    }



    
}
