package model;

import java.util.Calendar;

public class Book extends ProductoBiblio {

    private int numSold;
    private String review;
    private Genre genre;

    public Book(String name, String id, int numPages, Calendar datePublication, String uRL, double price, int numPagesRead, int numSold, String review, Genre genre) {
        
        super(name, id, numPages, datePublication, uRL, price, numPagesRead);
        this.numSold = numSold;
        this.review= review;
        this.genre = genre;

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

    public void calculateNewBooks(int unitsSold){
		this.numSold = this.numSold+unitsSold;
	}


    
    
}
