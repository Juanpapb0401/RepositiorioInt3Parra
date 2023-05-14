package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

    private ArrayList <ProductoBiblio> products;
    private ArrayList <User> users;
    private ArrayList <Transaction> transactions;

    public Controller(){
        this.products = new ArrayList<ProductoBiblio>();
        this.users = new ArrayList<User>();
        this.transactions = new ArrayList<Transaction>();
        testCases();
    }


    public void testCases(){

        products.add(new Book("Aladin", "Z1T", 40, crearCalendar(0, 0, 0), "www.Aladin.org",40, 0, 120, "Excelent book the best", Genre.FANTASY));
        products.add(new Magazine("Animal Planet", "4FG", 30, crearCalendar(0, 0, 0), "www.Animal.org", 12, 0, "Each month", 36879, Category.CIENTIFIC));
        users.add(new Regular("Pepito", "736", crearCalendar(0, 0, 0)));
        users.add(new Premium("Ramirez", "493", crearCalendar(0, 0, 0)));

    }
    public Calendar crearCalendar(int day, int month, int year){

        Calendar calendar = new GregorianCalendar(day,month,year);

        return calendar;

    }
    public boolean registerBook(String name, String id, int numPages, Calendar datePublication, String uRL, double price, int numPagesRead, int numSold, String review, int genre){

        Genre genreBook = Genre.FANTASY;


        switch(genre){
            case 1:
            genreBook = Genre.FANTASY;
            break;
            case 2:
            genreBook = Genre.HISTORICAL_NOVEL;
            break;
            case 3:
            genreBook = Genre.SCIENCE_FICTION;
            break;
        }


        Book newBook = new Book(name, id, numPages, datePublication, uRL, price, numPagesRead, numSold, review, genreBook);

        return products.add(newBook);
        
    }
    public String consultRegisterBooks(){

        String msg="";

        for (int i = 0; i < products.size(); i++){
            
            if (products.get(i) instanceof Book){

                msg += "\n"+(i+1)+". "+products.get(i).getName();
            }

            
        }

        return msg;
    }
    public String consultRegisterMagazine(){

        String msg="";

        for (int i = 0; i < products.size(); i++){
            
            if (products.get(i) instanceof Magazine){

                msg += "\n"+(i+1)+". "+products.get(i).getName();
            }

            
        }
        return msg;
    }
    public boolean registerMagazine(String name, String id, int numPages, Calendar datePublication, String uRL, double price,int numPagesRead, String periodicalEmission, int numSuscripActives, int category){

        Category categoryMagazine = Category.CIENTIFIC;

        switch(category){
            case 1:
            categoryMagazine = Category.CIENTIFIC;
            break;
            case 2:
            categoryMagazine = Category.DESIGN;
            break;
            case 3:
            categoryMagazine = Category.VARIETIES;
            break;
        }

        Magazine newMagazine = new Magazine(name, id, numPages, datePublication, uRL, price, numPagesRead, periodicalEmission, numSuscripActives, categoryMagazine);
        
        return products.add(newMagazine);
    }
    public boolean registerRegular(String nameUser, String iD, Calendar dateVincu){

        Regular newRegular = new Regular(nameUser, iD, dateVincu);

        return users.add(newRegular);
    }
    public boolean registerPremium(String nameUser, String iD, Calendar dateVincu){

        Premium newPremium = new Premium(nameUser, iD, dateVincu);

        return users.add(newPremium);
    }
    public String getBookList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

            if (products.get(i) instanceof Book){

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

            }
			
		}
		return msg;
	}
    public String getMagazineList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

		
            if (products.get(i) instanceof Magazine){

			msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

            }
			
		}
		return msg;
	}
    public boolean sellBook(int bookSell) {

        if (products.get(bookSell) instanceof Book){

            Book book = ((Book)products.get(bookSell));

            Transaction newTransaction = new Transaction(book.getPrice(), book.getName());

            book.calculateNewBooks(1);

            
            return transactions.add(newTransaction);
                
            
        }
		return false;
	}
    public boolean sellMagazine(int MagazineSell) {

        if (products.get(MagazineSell) instanceof Magazine){

            Magazine magazine = ((Magazine)products.get(MagazineSell));

            Transaction newTransaction = new Transaction(magazine.getPrice(), magazine.getName());

            return transactions.add(newTransaction);
            
        }
		return false;
	}

    public boolean modifyBook(int posicionBook, int atributo, String modificacion){

            if (products.get(posicionBook) instanceof Book){

                  switch(atributo){
                    case 1:
                    ((Book)products.get(posicionBook)).setId(modificacion);
                    return true;
                    case 2:
                    ((Book)products.get(posicionBook)).setName(modificacion);
                    return true;
                    case 3:
                    int numPages = Integer.parseInt(modificacion);
                    ((Book)products.get(posicionBook)).setNumPages(numPages);
                    return true;
                    case 4:
                    ((Book)products.get(posicionBook)).setReview(modificacion);
                    return true;
                    case 5:
                    Genre genreBook = null;
                    switch(modificacion){
                        case "FANTASY":
                        genreBook = Genre.FANTASY;
                        break;
                        case "HISTORICAL_NOVEL":
                        genreBook = Genre.HISTORICAL_NOVEL;
                        break;
                        case "SCIENCE_FICTION":
                        genreBook = Genre.SCIENCE_FICTION;
                        break;
                    }
                    ((Book)products.get(posicionBook)).setGenre(genreBook);
                    return true;
                    case 6:
                    ((Book)products.get(posicionBook)).setuRL(modificacion);
                    return true;
                    case 7:
                    double price = Double.parseDouble(modificacion);
                    ((Book)products.get(posicionBook)).setPrice(price);
                    return true;
                    case 8:
                    int numPagesSold = Integer.parseInt(modificacion);
                    ((Book)products.get(posicionBook)).setNumSold(numPagesSold);
                    return true;
                }

            }
        return false;
    }

    public boolean modifyDateBook(int day, int month, int year, int posicionBook, int atributo){

        switch (atributo){

            case 9:
            ((Book)products.get(posicionBook)).setDatePublication(crearCalendar(day,month,year));
            return true;

        }

        return false;
    }

    public boolean modifyDateMagazine(int day, int month, int year, int posicionBook, int atributo){

        switch (atributo){
            case 8:
            ((Magazine)products.get(posicionBook)).setDatePublication(crearCalendar(day,month,year));
            return true;
        }
        return false;
    }

    public String deleteBookAndMagazine(int bookPosition) {

        products.remove(bookPosition);

            
        return "The product has been deleted";

      }

    public boolean modifyMagazine(int posicionMagazine, int atributo, String modificacion){

        System.out.println("1.Enter a id, only for this magazine (3 hexadecimal characters)");
            System.out.println("2.Enter the name of the magazine");
            System.out.println("3.Enter the number of pages");
            System.out.println("4.Enter the category CIENTIFIC, DESIGN, VARIETIES) (you need to write exactly)");
            System.out.println("5.Enter the URL");
            System.out.println("6.Enter the price en dolars");
            System.out.println("7.Enter way is publish");
            System.out.println("8.Enter the date of publication");

        if (products.get(posicionMagazine) instanceof Magazine){

              switch(atributo){
                case 1:
                ((Magazine)products.get(posicionMagazine)).setId(modificacion);
                return true;
                case 2:
                ((Magazine)products.get(posicionMagazine)).setName(modificacion);
                return true;
                case 3:
                int numPages = Integer.parseInt(modificacion);
                ((Magazine)products.get(posicionMagazine)).setNumPages(numPages);
                return true;
                case 4:
                Category categoryMagazine= null;
                switch(modificacion){
                    case "CIENTIFIC":
                    categoryMagazine = Category.CIENTIFIC;
                    break;
                    case "DESIGN":
                    categoryMagazine = Category.DESIGN;
                    break;
                    case "VARIETIES":
                    categoryMagazine = Category.VARIETIES;
                    break;
                }
                ((Magazine)products.get(posicionMagazine)).setCategory(categoryMagazine);
                return true;
                case 5:
                ((Magazine)products.get(posicionMagazine)).setuRL(modificacion);;
                return true;
                case 6:
                double price = Double.parseDouble(modificacion);
                ((Magazine)products.get(posicionMagazine)).setPrice(price);
                return true;
            }
        }
        return false;
    }

    
















}




    
