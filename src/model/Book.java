package model;

import java.util.Calendar;

public class Book extends ProductoBiblio {

    private int numSold;
    private String review;
    private Genre genre;
    private int paginasAdverti;
    private int paginasRead;

    public void addPaginasReadBook(){
        this.paginasRead +=1;
    }

    public int getPaginasRead() {
        return paginasRead;
    }

    public void setPaginasRead(int paginasRead) {
        this.paginasRead = paginasRead;
    }

    public Book(String name, String id, int numPages, Calendar datePublication, String uRL, double price, int numPagesRead, int numSold, String review, Genre genre) {
        
        super(name, id, numPages, datePublication, uRL, price, numPagesRead);
        this.numSold = numSold;
        this.review= review;
        this.genre = genre;
        this.paginasAdverti= 0;
        this.paginasRead =1;


    }

    public int getPaginasAdverti() {
        return paginasAdverti;
    }

    public void setPaginasAdverti(int paginasAdverti) {
        this.paginasAdverti = paginasAdverti;
    }

    public double getNumSold() {
        return numSold;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void calculateNewBooks(){
		this.numSold +=1;
	}

    public boolean showAdvertisement(){

        if (paginasAdverti == 20){

            this.paginasAdverti =0;

            return true;
        }

        return false;
    }

    public void addPagesAd(){
        this.paginasAdverti +=1;
    }

    public int compareToBook(Book o){

        if (this.getPaginasRead()>o.getPaginasRead()){

			return 1;

		}else if (this.getPaginasRead()<o.getPaginasRead()){

			return -1;
		}

        return 0;
    }



    
    
}
