package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Controller {

    private ArrayList <ProductoBiblio> products;
    private ArrayList <User> users;
    private final String ad1;
    private final String ad2;
    private final String ad3;
    private ArrayList<Book> bookList;
    private ArrayList<Magazine> magazineList;
  

    public Controller(){
        this.products = new ArrayList<ProductoBiblio>();
        this.users = new ArrayList<User>();
        this.ad1 ="¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
        this.ad2 ="Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito";
        this.ad3 = "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas";
        this.bookList = new ArrayList<Book>();
        this.magazineList = new ArrayList<Magazine>();

        testCases();
    }


    public void testCases(){

        products.add(new Book("Aladin", "Z1T", 40, crearCalendar(0, 0, 0), "www.Aladin.org",40, 0, 0, "Excelent book the best", Genre.FANTASY));
        products.add(new Book("CienciaFiccion", "Q6T", 120, crearCalendar(0, 0, 0), "www.Selva.org", 80, 0, 0, "The best bok", Genre.SCIENCE_FICTION));
        products.add(new Book("HistoricalNovel", "Z8T", 0, crearCalendar(0, 0, 0), "www.cienciaficcion", 20, 0, 0, "El error imposible", Genre.HISTORICAL_NOVEL));
        products.add(new Magazine("Animal Planet", "F6G", 30, crearCalendar(0, 0, 0), "www.Animal.org", 12, 0, "Each month", 0, Category.CIENTIFIC)); 
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


    public boolean sellBook1(int bookSell, int userSell){

        if (products.get(bookSell) instanceof Book){

            Book book = ((Book)products.get(bookSell));

            Transaction newTransaction = new Transaction(book.getPrice(), book.getName());

            if (users.get(userSell) instanceof Regular){

                if (((Regular)users.get(userSell)).getBooksSell()<5){


                 return users.get(userSell).getTransactionUser().add(newTransaction) &&  users.get(userSell).getProductsUser().add(book);

                }
            }else {

                return users.get(userSell).getTransactionUser().add(newTransaction)  &&  users.get(userSell).getProductsUser().add(book);
            }

            ((Book)users.get(userSell).getProductsUser().get(users.get(userSell).getProductsUser().size()-1)).calculateNewBooks();
        }
        return false;
    }

    public boolean sellMagazine1(int magazineSell, int userSell){

        if (products.get(magazineSell) instanceof Magazine){

            Magazine magazine = ((Magazine)products.get(magazineSell));

            Transaction newTransaction = new Transaction(magazine.getPrice(), magazine.getName());

            if (users.get(userSell) instanceof Regular){

                if (((Regular)users.get(userSell)).getMagazineSell()<2){

                    return users.get(userSell).getTransactionUser().add(newTransaction) && users.get(userSell).getProductsUser().add(magazine);

                }
            }else{
                return users.get(userSell).getTransactionUser().add(newTransaction) && users.get(userSell).getProductsUser().add(magazine);
            }

            ((Magazine)users.get(userSell).getProductsUser().get(users.get(userSell).getProductsUser().size()-1)).calculateNewMagazines();
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

    public String deleteSuscripcionMagazine(int magazinePosition, int positionUser){

        if (products.get(magazinePosition)instanceof Magazine){

            users.get(positionUser).getProductsUser().remove(magazinePosition);

        }

        return "The product has been removed";
               
    }

    public String verificarProductsMagazine() {

		String msg = "";

		for (int i = 0; i < users.get(i).getProductsUser().size(); i++) {
		
            if (users.get(i).getProductsUser().get(i) instanceof Magazine){

			msg += "\n" + (i + 1) + ". " + users.get(i).getProductsUser().get(i).getName()+ " - " + users.get(i).getProductsUser().get(i).getPrice();

            }
			
		}
        
		return msg;
	}

    public boolean modifyMagazine(int posicionMagazine, int atributo, String modificacion){

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
     public String printStringMatrix(int userPositon) {
        String print = "";
		//print += " 0 \t 1 \t 2 \t 3 \t 4  \n";
        //print += " 0 \n \n 1 \n \n 2 \n \n 3 \n \n 4 ";

    
        if (users.get(userPositon)instanceof Premium){

            pasardeArryListAMatrix(userPositon);

            Premium premium = ((Premium)users.get(userPositon));

        for (int p=0; p<premium.getMatrixPremium().size();p++){

            for (int i=0; i<premium.getMatrixPremium().get(p).length;i++){

			for (int j=0; j<premium.getMatrixPremium().get(p)[0].length;j++){

                if(premium.getMatrixPremium().get(p)[i][j]==null){
                    print+= "---\t";    
                }else{
                    print+= premium.getMatrixPremium().get(p)[i][j]+ "\t";
                }

				
			}
			print += "\n";
		    }
    }   }


        if (users.get(userPositon)instanceof Regular){

            pasardeArryListAMatrix(userPositon);

            Regular regular = ((Regular)users.get(userPositon));

            for (int i=0; i<regular.getMatrixRegular().length;i++){

			    for (int j=0; j<regular.getMatrixRegular()[0].length;j++){

                    if(regular.getMatrixRegular()[i][j]==null){
                    print+= "___\t";    
                    }else{
                    print+= regular.getMatrixRegular()[i][j]+ "\t";
                    }

				
			    }
			print += "\n";
		}
    }
		return print;
	}

    public String consultRegisterUser(){

        String msg="";

        for (int i = 0; i < users.size(); i++){
            
            if (users.get(i) instanceof Regular){

                msg += "\n"+(i+1)+". "+users.get(i).getNameUser();
            }
            if (users.get(i) instanceof Premium){

                msg += "\n"+(i+1)+". "+users.get(i).getNameUser();
            }
        }
        return msg;
    }
    

    public String simulacionLectura1(int userPosition, String codigoProducto){

        String msg = "\nSesion de lectura en progreso:";
        int counter=0;

        for (int i = 0; i < users.get(userPosition).getProductsUser().size(); i++) {

            if (codigoProducto.equals(users.get(userPosition).getProductsUser().get(i).getId())) {

                msg +="\nLeyendo: "+users.get(userPosition).getProductsUser().get(i).getName();

                msg +="\nLeyendo pagina: "+ users.get(userPosition).getProductsUser().get(i).getPagesReadTemp()+ " de "+ users.get(userPosition).getProductsUser().get(i).getNumPages();
                
                if (users.get(i) instanceof Regular) {

                    if(users.get(userPosition).getProductsUser().get(i) instanceof Book){

                        if (((Book)users.get(userPosition).getProductsUser().get(i)).showAdvertisement()) {

                            Random rand = new Random();
                            int r = rand.nextInt(3);

                            switch (r) {
                                case 0:

                                    msg+= ad1;
                                    
                                    break;

                                case 1:

                                    msg+= ad2;

                                    break;

                                case 2:

                                    msg += ad3;

                                    break;
                            }
                        
                        }
                    }else{

                        if (((Magazine) users.get(userPosition).getProductsUser().get(i)).showAdvertisement()) {
                            
                            Random rand = new Random();
                            int r = rand.nextInt(3);

                            switch (r) {
                                case 0:

                                    msg+= ad1;
                                    
                                    break;

                                case 1:

                                    msg+= ad2;

                                    break;

                                case 2:

                                    msg += ad3;

                                    break;
                            }

                        }
                    }
                      
                }

            }

            else{

                counter++;

            }
            
        }

        if (counter == users.get(userPosition).getProductsUser().size()) {

            msg+="\nEste producto bibliografico no se encuentra entre su productos comprados";
            
        }      

        return msg;
    
    }    

   


    public void adReadingSesion(int userPosition, String productoCodigo, String optionMenuSimu){

        if(optionMenuSimu.equals("A")){

            for (int i = 0; i < users.get(userPosition).getProductsUser().size(); i++) {

                if (productoCodigo.equals(users.get(userPosition).getProductsUser().get(i).getId())) {
    
                    if (users.get(userPosition).getProductsUser().get(i).getNumPagesRead() >1 && users.get(userPosition).getProductsUser().get(i).getPagesReadTemp() < users.get(userPosition).getProductsUser().get(i).getNumPages()) {

                        System.out.println("A");

                        users.get(userPosition).getProductsUser().get(i).removePagesReadTemp();

                        if ( users.get(userPosition).getProductsUser().get(i) instanceof Book) {

                            ((Book)users.get(userPosition).getProductsUser().get(i)).addPagesAd();
                            ((Book)users.get(userPosition).getProductsUser().get(i)).addPaginasReadBook();;
                        }
    
                        if ( users.get(userPosition).getProductsUser().get(i) instanceof Magazine) {

                            ((Magazine)users.get(userPosition).getProductsUser().get(i)).addPagesAdM();
                            ((Magazine)users.get(userPosition).getProductsUser().get(i)).addPagesReadM();;
                            
                        }
                    }
                   
                }  
            }
        }

        if(optionMenuSimu.equals("S")){

            for (int i = 0; i < users.get(userPosition).getProductsUser().size(); i++) {

                if (productoCodigo.equals(users.get(userPosition).getProductsUser().get(i).getId())) {
    
                    if (users.get(userPosition).getProductsUser().get(i).getPagesReadTemp() >0 && users.get(userPosition).getProductsUser().get(i).getPagesReadTemp() < users.get(userPosition).getProductsUser().get(i).getNumPages()) {

                        users.get(userPosition).getProductsUser().get(i).addPagesReadTemp();
    
                        if ( users.get(userPosition).getProductsUser().get(i) instanceof Book) {
                            ((Book) users.get(userPosition).getProductsUser().get(i)).addPagesAd();
                            ((Book)users.get(userPosition).getProductsUser().get(i)).addPaginasReadBook();
                        }
    
                        if ( users.get(userPosition).getProductsUser().get(i) instanceof Magazine) {
                            ((Magazine) users.get(userPosition).getProductsUser().get(i)).addPagesAdM();
                            ((Magazine)users.get(userPosition).getProductsUser().get(i)).addPagesReadM();
                        
                        }
                    }
                   
                }
                
            }

        }
        if(optionMenuSimu.equals("B")){

            for (int i = 0; i < users.get(userPosition).getProductsUser().size(); i++) {

                if (productoCodigo.equalsIgnoreCase(users.get(userPosition).getProductsUser().get(i).getId())) {
    
                    users.get(userPosition).getProductsUser().get(i).setPagesReadTempFinal();

                }
                
            }

        }
    }




    public boolean verificarId(String codigoProducto){

        for (int i=0; i<products.size();i++){

            if (codigoProducto.equals(products.get(i).getId())){

                return true;
            }
        }

        return false;
    }


public String totalNumberOfPagesRead(){

    String msg = "";
    int bookPageCounter = 0;
    int magazinePageCounter = 0;

    for (int j = 0; j < users.size() ; j++) {

        for (int i = 0; i < users.get(j).getProductsUser().size(); i++) {

            if (users.get(j).getProductsUser().get(i) instanceof Book) {

                bookPageCounter +=  ((Book) users.get(j).getProductsUser().get(i)).getPaginasRead();

            }

            if (users.get(j).getProductsUser().get(i) instanceof Magazine) {

                magazinePageCounter += ((Magazine) users.get(j).getProductsUser().get(i)).getPaginasReadM();
            }

        }
    }

    msg +="Se leyeron "+bookPageCounter+" paginas en los libros \nSe leyeron "+magazinePageCounter+" paginas en las revistas";

    return msg;
}




public String genreMostReadBook(){

    String msg = "";
    int sumaCienciaFiccion = 0;
    int sumaFantasia = 0;
    int sumaNovelaHistorica = 0;

    for (int i = 0; i < users.size(); i++) {

        for (int j = 0; j < users.get(i).getProductsUser().size(); j++) {

            if (users.get(i).getProductsUser().get(j) instanceof Book) {

                if (((Book)users.get(i).getProductsUser().get(j)).getGenre() == Genre.SCIENCE_FICTION) {

                    sumaCienciaFiccion += ((Book)users.get(i).getProductsUser().get(j)).getPaginasRead();
                    
                }

                else if (((Book)users.get(i).getProductsUser().get(j)).getGenre() == Genre.FANTASY) {

                    sumaFantasia = ((Book)users.get(i).getProductsUser().get(j)).getPaginasRead();
                        
                }

                else if (((Book)users.get(i).getProductsUser().get(j)).getGenre() == Genre.HISTORICAL_NOVEL) {

                    sumaNovelaHistorica = ((Book)users.get(i).getProductsUser().get(j)).getPaginasRead();
                        
                }
                
            }
            
        }
    }
    
    if ((sumaCienciaFiccion > sumaFantasia) && (sumaCienciaFiccion > sumaNovelaHistorica)) {

        msg+= "Los libros de genero ciencia ficcion tienen el mayor numero de hojas leidas con "+sumaCienciaFiccion;
        
    }

    else if ((sumaFantasia > sumaCienciaFiccion) && (sumaFantasia > sumaNovelaHistorica)) {

        msg+= "Los libros de genero fantasia tienen el mayor numero de hojas leidas con "+sumaFantasia;

    }

    else if((sumaNovelaHistorica > sumaCienciaFiccion) && (sumaNovelaHistorica > sumaFantasia)) {

        msg+= "Los libros de genero novela historica tienen el mayor numero de hojas leidas con "+sumaNovelaHistorica;

    }

    return msg;
}


public String categryMostReadMagazine(){

    String msg = "";
    int sumaCientific = 0;
    int sumaDesign = 0;
    int sumaVarieties = 0;

    for (int i = 0; i < users.size(); i++) {

        for (int j = 0; j < users.get(i).getProductsUser().size(); j++) {

            if (users.get(i).getProductsUser().get(j) instanceof Magazine) {

                if (((Magazine)users.get(i).getProductsUser().get(j)).getCategory() == Category.CIENTIFIC) {

                    sumaCientific += ((Magazine)users.get(i).getProductsUser().get(j)).getPaginasReadM();
                    
                }

                else if (((Magazine)users.get(i).getProductsUser().get(j)).getCategory() == Category.DESIGN) {

                    sumaDesign = ((Magazine)users.get(i).getProductsUser().get(j)).getPaginasReadM();
                        
                }

                else if (((Magazine)users.get(i).getProductsUser().get(j)).getCategory() == Category.VARIETIES) {

                    sumaVarieties = ((Magazine)users.get(i).getProductsUser().get(j)).getPaginasReadM();
                        
                }
                
            }
            
        }
    }
    
    if ((sumaCientific > sumaDesign) && (sumaCientific > sumaVarieties)) {

        msg+= "Las revistas de cateregoria cientific tienen el mayor numero de hojas leidas con "+sumaCientific;
        
    }

    else if ((sumaDesign > sumaCientific) && (sumaDesign > sumaVarieties)) {

        msg+= "Las revistas de cateregoria design tienen el mayor numero de hojas leidas con "+sumaDesign;

    }

    else if((sumaVarieties > sumaCientific) && (sumaVarieties > sumaDesign)) {

        msg+= "Las revistas de cateregoria varieties tienen el mayor numero de hojas leidas con "+sumaVarieties;

    }

    return msg;
}

public String pasardeArryListAMatrix(int opcionUser) {
    boolean flag = false;
    boolean flag1 = false;
    boolean noIguales = false;
    String msg = "";

    for (int i = 0; i < users.get(opcionUser).getProductsUser().size(); i++) {
        ProductoBiblio product = users.get(opcionUser).getProductsUser().get(i);

        if (users.get(opcionUser) instanceof Regular) {
            Regular regular = (Regular) users.get(opcionUser);

            for (int l = 0; l < regular.getMatrixRegular().length && !flag; l++) {
                for (int j = 0; j < regular.getMatrixRegular()[0].length && !flag; j++) {
                    if (regular.getMatrixRegular()[l][j] == null) {
                        for (int m = 0; m < regular.getMatrixRegular().length; m++) {
                            for (int n = 0; n < regular.getMatrixRegular()[0].length; n++) {
                                if (regular.getMatrixRegular()[m][n] != null && regular.getMatrixRegular()[m][n].equals(product.getId())) {
                                    noIguales = true;
                                    flag=true;
                                }
                            }
                            if (noIguales) {
                                msg = "Ya existe ese producto";
                            }
                        }

                        if (!noIguales) {
                            regular.getMatrixRegular()[l][j] = product.getId();
                            flag = true;
                        }
                    }
                }
            }
            flag = false;
        }

        if (users.get(opcionUser) instanceof Premium){

            Premium premium = ((Premium)users.get(opcionUser));

            String[][] matrixPremium1 = new String[5][5];

            premium.getMatrixPremium().add(matrixPremium1);

            for (int p=0; p<premium.getMatrixPremium().size();p++){

                for (int q=0; i<premium.getMatrixPremium().get(p).length && !flag1;i++){

                    for (int j=0; j<premium.getMatrixPremium().get(p)[0].length && !flag1;j++){

                        if (premium.getMatrixPremium().get(p)[q][j]==null){

                            for (int m = 0; m < premium.getMatrixPremium().get(p).length; m++) {
                                for (int n = 0; n < premium.getMatrixPremium().get(p)[0].length; n++) {
                                    if (premium.getMatrixPremium().get(p)[m][n] != null && premium.getMatrixPremium().get(p)[m][n].equals(product.getId())) {
                                        noIguales = true;
                                        flag1=true;
                                    }
                                }
                                if (noIguales) {
                                    msg = "Ya existe ese producto";
                                }
                            }

                            if (!noIguales) {
                                premium.getMatrixPremium().get(p)[q][j] = product.getId();
                                flag1 = true;
                            }
                    }        
                }
            }
            flag1= false;
        }
    }
    }
    return msg;
}

public String mostSoldBookMagazines(){

    String msg = "\nLibros:";
    int cienciaFiccionBookCounter = 0;
    int cienciaFiccionBookPriceSum = 0;

    int fantasyBookCounter = 0;
    int fantasyBookPriceSum = 0;

    int historyNovelBookCounter = 0;
    int historyNovelBookPriceSum = 0;

    int variedadMagazineCounter = 0;
    int variedadMagazinePriceSum =0;

    int designMagazineCounter = 0;
    int designMagazinePriceSum =0;

    int cientificMagazineCounter = 0;
    int cientificMagazinePriceSum = 0;

    for (int i=0; i<users.size();i++){

        for (int p=0; p<users.get(i).getProductsUser().size();i++){

            if (users.get(i).getProductsUser().get(p) instanceof Book) {

                if (((Book)users.get(i).getProductsUser().get(p)).getGenre() == Genre.SCIENCE_FICTION) {
    
                    cienciaFiccionBookCounter += ((Book)users.get(i).getProductsUser().get(p)).getNumSold();
    
                    cienciaFiccionBookPriceSum += ((Book)users.get(i).getProductsUser().get(p)).getPrice();
    
                }
    
                else if (((Book)users.get(i).getProductsUser().get(p)).getGenre() == Genre.FANTASY) {
    
                    fantasyBookCounter += ((Book)users.get(i).getProductsUser().get(p)).getNumSold();
                    fantasyBookPriceSum += ((Book)users.get(i).getProductsUser().get(p)).getPrice();
    
                }
    
                else if (((Book)users.get(i).getProductsUser().get(p)).getGenre()== Genre.HISTORICAL_NOVEL) {
    
                    historyNovelBookCounter += ((Book)users.get(i).getProductsUser().get(p)).getNumSold();
                    historyNovelBookPriceSum += ((Book)users.get(i).getProductsUser().get(p)).getPrice();
    
                }
                
            }

            if (products.get(i) instanceof Magazine) {


                if (((Magazine)users.get(i).getProductsUser().get(p)).getCategory() == Category.VARIETIES) {
    
                    variedadMagazineCounter += ((Magazine)users.get(i).getProductsUser().get(p)).getNumSuscripActives();
    
                    variedadMagazinePriceSum += ((Magazine)users.get(i).getProductsUser().get(p)).getPrice();
    
                }
    
                else if (((Magazine)users.get(i).getProductsUser().get(p)).getCategory()== Category.DESIGN) {
    
                    designMagazineCounter += ((Magazine)users.get(i).getProductsUser().get(p)).getNumSuscripActives();
                    designMagazinePriceSum += ((Magazine)users.get(i).getProductsUser().get(p)).getPrice();;
    
                }
    
                else if (((Magazine)users.get(i).getProductsUser().get(p)).getCategory() == Category.CIENTIFIC) {
    
                    cientificMagazineCounter += ((Magazine)users.get(i).getProductsUser().get(p)).getNumSuscripActives();
                    cientificMagazinePriceSum += ((Magazine)users.get(i).getProductsUser().get(p)).getPrice();
    
                }
            }
        }
    }
    

    msg+= "\nCiencia ficcion: \nUnidades: "+cienciaFiccionBookCounter+" \nPrecio total: "+cienciaFiccionBookPriceSum+ "\n";

    msg+= "\nFantasia: \nUnidades: "+fantasyBookCounter+" \nPrecio total: "+fantasyBookPriceSum+ "\n";

    msg+= "\nNovela historica: \nUnidades: "+historyNovelBookCounter+" \nPrecio total: "+historyNovelBookPriceSum+ "\n";

    msg+= "\nRevistas";

    msg+= "\nVariedades: \nUnidades: "+variedadMagazineCounter+" \nPrecio total: "+variedadMagazinePriceSum+ "\n" ;

    msg+= "\nDiseño: \nUnidades: "+designMagazineCounter+" \nPrecio total: "+designMagazinePriceSum+ "\n";

    msg+= "\nCientific: \nUnidades: " + cientificMagazineCounter+ " \nPrecio total: "+ cientificMagazinePriceSum+ "\n";

    return msg;

}

public void fillBookList(){

    for (int i = 0; i < users.size(); i++) {

        for (int j = 0; j < users.get(i).getProductsUser().size(); j++) {

            if (users.get(i).getProductsUser().get(j) instanceof Book) {

                bookList.add((Book)users.get(i).getProductsUser().get(j));

            }
            
        }
        
    }
}

public void fillMagazineList(){

    for (int i = 0; i < users.size(); i++) {

        for (int j = 0; j < users.get(i).getProductsUser().size(); j++) {

            if (users.get(i).getProductsUser().get(j) instanceof Magazine) {

                magazineList.add((Magazine)users.get(i).getProductsUser().get(j));

            }
            
        }
        
    }
}

public String top5Book(){

    fillBookList();

    String msg = "\nLibro: ";
    
    int respuesta = 0;
    int counter = 0;

    while (counter < bookList.size()) {

        if (bookList == null){

            counter = bookList.size();
        }

        for (int i = 0; i < bookList.size()-1; i++) {

            Book book1 = bookList.get(i);
            Book book2 = bookList.get(i+1);
            
            respuesta = book1.compareToBook(book2);

            if (respuesta == -1) {

                bookList.set(i+1, book1);

                bookList.set(i, book2);
                
            }

            if (respuesta >-1) {

                counter++;
                
            }	
        }
        
    }

    for (int i = 0; i < bookList.size(); i++) {

        if (i<5){
            msg +="\nName: "+bookList.get(i).getName() + "\nGenre: " +bookList.get(i).getGenre() + "\nPages read: " + bookList.get(i).getPaginasRead();

        }
    }

    return msg;
}

public String top5Magazine(){

    fillMagazineList();

    String msg = "\nMagazine: ";
    
    int respuesta = 0;
    int counter = 0;

    while (counter < magazineList.size()) {

        if (magazineList == null){

            counter = magazineList.size();
        }

        for (int i = 0; i < bookList.size()-1; i++) {

            Magazine magazine1 = magazineList.get(i);
            Magazine magazine2 = magazineList.get(i+1);
            
            respuesta = magazine1.compareToMagazine(magazine2);

            if (respuesta == -1) {

                magazineList.set(i+1, magazine1);

                magazineList.set(i, magazine2);
                
            }

            if (respuesta >-1) {

                counter++;
                
            }	
        }
        
    }

    for (int i = 0; i < magazineList.size(); i++) {

        if (i<5){
            msg +="\nName: "+magazineList.get(i).getName() + "\nGenre: " +magazineList.get(i).getCategory() + "\nPages read: " + magazineList.get(i).getPaginasReadM();

        }
    }

    return msg;

}














}




    
