package ui;

import model.Controller;

import java.util.Scanner;
import java.util.Calendar;



public class Executable {

    private Scanner reader;
    private Controller controller;


    public Executable() {

        reader= new Scanner(System.in);
        controller = new Controller();
    }


    public static void main(String[] args) {
        
        Executable ejecutable = new Executable();
        ejecutable.menu();
        
    }

    private void menu(){

        System.out.println("Welcome to the Integradora 3");
        System.out.println("-----------------------------------------------------------------------------------------");

        boolean flag = false;

        while (!flag) {

			System.out.println("1. Register users (Regular or Premium)"); //Ready
			System.out.println("2. Register, modify and delete books and magazines"); //Ready
			System.out.println("3. Purchase a book"); //Ready
			System.out.println("4. Subscribe to a magazine"); //Ready
            System.out.println("5. Simulate reading session"); //Ready
			System.out.println("6. Show the Library of a User (AD only here)"); //Ready
            System.out.println("7. Generate Reports"); //Ready -parcialmente
			System.out.println("8. Salir ");
			int option = reader.nextInt();

			switch (option) {

			case 1:
                registerUsers();
				break;
			case 2:
				req2();
				break;
			case 3:
				sellBook();
				break;
			case 4:
                System.out.println("1.Buy Magazines 2.Unsubscribe a magazine");
                int optionBasic = reader.nextInt();
                if (optionBasic==1){
                    sellMagazine();
                }else{
                    unsubscribe();
                }
				break;
			case 5:
                sesionDeLectura();
				break;
			case 6:
				mostrarBiblotecaUser();
                break;
			case 7:
                req8();
                break;
            case 8:
                flag = true;
				break;
			}
		}

    }
    private void req2(){

        System.out.println("1.Register book");
        System.out.println("2.Modify book");
        System.out.println("3.Delete book");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("4.Register magazine");
        System.out.println("5.Modify magazine");
        System.out.println("6.Delete magazine");
        int option = reader.nextInt();

        switch(option){
            case 1:
            registerBooks();
            break;
            case 2:
            modifyBook();
            break;
            case 3:
            deleteBook();
            break;
            case 4:
            registerMagazine();
            break;
            case 5:
            modifyMagazine();
            break;
            case 6:
            deleteMagazine();
            break;

        }
    }
/**Method title: registerBooks
*Description: The method allows you to register objects Book, where you will be asked for all the necessary information
*Return: Registering a new object of the Book class
*/
    private void registerBooks(){

        reader.nextLine();

        System.out.println("Enter a id, only for this book (3 hexadecimal characters)");
        String id = reader.nextLine();

        System.out.println("Enter the name of the book");
        String nameBook = reader.nextLine();

        System.out.println("Enter the number of pages");
        int numPages = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter a short review");
        String review = reader.nextLine();

        System.out.println("Enter the date of publication");
        System.out.println("Enter the day");
        int dayInicial= reader.nextInt();
        System.out.println("Enter the month");
        int monthInicial= reader.nextInt();
        System.out.println("Enter the year");
        int yearInicial= reader.nextInt();

        System.out.println("Enter the genre (1.FANTASY, 2.HISTORICAL_NOVEL, 3.SCIENCE_FICTION)");
        int genre = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter the URL");
        String uRL = reader.nextLine();

        System.out.println("Enter the price en dolars");
        double price = reader.nextDouble();

        System.out.println("Enter the number of copies sold");
        int numSold = reader.nextInt();

        if (controller.registerBook(nameBook, id, numPages, controller.crearCalendar(dayInicial, monthInicial, yearInicial), uRL, price, 0, numSold, review, genre)){

            System.out.println("The book has been successfully registered");
        }else{

            System.out.println("The book has not been successfully registered");
        }

        
    }
/**Method title: modifyBooks
*Description: The method allows you to modify atributes of Book, where you will be asked for all the necessary information
*Return: Modifies an object of the Book class
*/
    private void modifyBook(){

        String query = controller.consultRegisterBooks();

        int dayInicial=0;
        int monthInicial=0;
        int yearInicial=0;

        if(query.equals("")){

			System.out.println("There is no books register");

		} else{
			System.out.println(query);
			System.out.println("Enter the book do you want to modify");
			int optionBook = reader.nextInt();

            System.out.println("Enter what atribute do you want to modify");

            System.out.println("1.Enter a id, only for this book (3 hexadecimal characters)");
            System.out.println("2.Enter the name of the book");
            System.out.println("3.Enter the number of pages");
            System.out.println("4.Enter a short review");
            System.out.println("5.Enter the genre FANTASY, HISTORICAL_NOVEL, SCIENCE_FICTION (you need to write exactly)");
            System.out.println("6.Enter the URL");
            System.out.println("7.Enter the price en dolars");
            System.out.println("8.Enter the number of copies sold");
            System.out.println("9.Enter the date of publication");
            int opcionMenu = reader.nextInt();
            if (opcionMenu==9){
                System.out.println("Enter the day");
                dayInicial= reader.nextInt();
                System.out.println("Enter the month");
                monthInicial= reader.nextInt();
                System.out.println("Enter the year");
                yearInicial= reader.nextInt();

                controller.crearCalendar(dayInicial, monthInicial, yearInicial);

                if (controller.modifyDateBook(dayInicial, monthInicial, yearInicial,optionBook-1, opcionMenu)){

                    System.out.println("The modification has been succesfully");
                
                }else{

                    System.out.println("The modificacion has not been posible");
                }
            }

            if (opcionMenu!=9){

                reader.nextLine();
                System.out.println("Enter the new atribute");
                String modificacion = reader.nextLine();

                if (controller.modifyBook(optionBook-1, opcionMenu, modificacion)){

                System.out.println("The modification has been succesfully");
                
                }else{

                System.out.println("The modificacion has not been posible");
                }

            }           
        }
    }
/**Method title: deleteBooks
*Description: The method allows you to delete objects Book
*Return: Deletes an object of the Book class
*/   
    private void deleteBook(){

        String query = controller.consultRegisterBooks();

        if (query.equals("")){
            System.out.println("There is not books registered");

        } else {

            System.out.println("This is the list of books in the system");

            System.out.println(query);

            System.out.println("Enter the book you want to delete");
            int opcionBookDelete = reader.nextInt();

            System.out.println(controller.deleteBookAndMagazine(opcionBookDelete-1));
        }

    }
/**Method title: consultBooks
*Description: The method allows you to consult objects Book
*Return: Consults an object of the Book class
*/
    private void consultBooks(){
            
        System.out.println("This is the info on the system");

        String consulta=controller.consultRegisterBooks();

        if (consulta.equals("")){
            System.out.println("There is no books register");
        }else {
            System.out.println(consulta);
        }
    }
/**Method title: registerMagazine
*Description: The method allows you to register objects Magazine, where you will be asked for all the necessary information
*Return: Registering a new object of the Magazine class
*/
    private void registerMagazine(){

        System.out.println("Enter a id, only for this magazine (3 hexadecimal characters)");
        String id = reader.nextLine();

        System.out.println("Enter the name of the magazine");
        String nameBook = reader.nextLine();

        System.out.println("Enter the number of pages");
        int numPages = reader.nextInt();

        System.out.println("Enter the date of publication");
        System.out.println("Enter the day");
        int dayInicial= reader.nextInt();
        System.out.println("Enter the month");
        int monthInicial= reader.nextInt();
        System.out.println("Enter the year");
        int yearInicial= reader.nextInt();

        System.out.println("Enter the category (1.CIENTIFIC, 2.DESIGN, 3.VARIETIES)");
        int category = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter the URL");
        String uRL = reader.nextLine();

        System.out.println("Enter the price en dolars of the suscription");
        double price = reader.nextDouble();

        reader.nextLine();

        System.out.println("Enter the emision of the magazine (Montly, Semestral, etc)");
        String periodicalEmision = reader.nextLine();


        if (controller.registerMagazine(nameBook, id, numPages, controller.crearCalendar(dayInicial, monthInicial, yearInicial), uRL, price, numPages, periodicalEmision, 0, category)){

            System.out.println("The magazine has been successfully registered");
        }else{

            System.out.println("The magazine has not been successfully registered");
        }

    }
/**Method title: modifyMagazine
*Description: The method allows you to modify atributes of Magazine
*Return: Modify an object of the Magazine class
*/
    private void modifyMagazine(){

        String query = controller.consultRegisterMagazine();

        int dayInicial=0;
        int monthInicial=0;
        int yearInicial=0;

        if(query.equals("")){

			System.out.println("There is no magazine register");

		} else{
			System.out.println(query);
			System.out.println("Enter the magazine do you want to modify");
			int optionMagazine = reader.nextInt();

            System.out.println("Enter what atribute do you want to modify");

            System.out.println("1.Enter a id, only for this magazine (3 hexadecimal characters)");
            System.out.println("2.Enter the name of the magazine");
            System.out.println("3.Enter the number of pages");
            System.out.println("4.Enter the category CIENTIFIC, DESIGN, VARIETIES) (you need to write exactly)");
            System.out.println("5.Enter the URL");
            System.out.println("6.Enter the price en dolars");
            System.out.println("7.Enter way is publish");
            System.out.println("8.Enter the date of publication");
            int opcionMenu = reader.nextInt();
            if (opcionMenu==9){
                System.out.println("Enter the day");
                dayInicial= reader.nextInt();
                System.out.println("Enter the month");
                monthInicial= reader.nextInt();
                System.out.println("Enter the year");
                yearInicial= reader.nextInt();

                controller.crearCalendar(dayInicial, monthInicial, yearInicial);

                if (controller.modifyDateBook(dayInicial, monthInicial, yearInicial,optionMagazine-1, opcionMenu)){

                    System.out.println("The modification has been succesfully");
                
                }else{

                    System.out.println("The modificacion has not been posible");
                }

            }
            reader.nextLine();
            System.out.println("Enter the new atribute");
            String modificacion = reader.nextLine();

            if (controller.modifyMagazine(optionMagazine-1, opcionMenu, modificacion)){

                System.out.println("The modification has been succesfully");
            }else{

                System.out.println("The modificacion has not been posible");
            }
        }
    }
/**Method title: deleteMagazine
*Description: The method allows you to delete objects Magazine
*Return: Deletes an object of the Magazine class
*/
    private void deleteMagazine(){

        String query = controller.consultRegisterMagazine();
    
        if (query.equals("")){
            System.out.println("There is not magazines registered");
    
        } else {
    
            System.out.println("This is the list of magazines in the system");
    
            System.out.println(query);
    
            System.out.println("Enter the book you want to delete");
            int opcionMagazineDelete = reader.nextInt();
    
            System.out.println(controller.deleteBookAndMagazine(opcionMagazineDelete-1));
        }
    
    }
/**Method title: registerUsers
*Description: The method allows you to register objects Users, where you will be asked for all the necessary information
*Return: Registering a new object of the Users class, depends the type of user. Regular or Premium
*/ 
    private void registerUsers(){

        System.out.println("Enter the next info in order to register a user");

        System.out.println("Do you want to be Regular (1) or Premimum user (2)");
        int optionUser = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter your name");
        String nameUser= reader.nextLine();

        System.out.println("Enter your ID");
        String iD= reader.nextLine();

        if (optionUser==1){

            if (controller.registerRegular(nameUser, iD, Calendar.getInstance())){

                System.out.println("The Regular User has been successfully registered");

            }else{

                System.out.println("The Regular User has not been successfully registered");
            }
        } if (optionUser==2){

            if (controller.registerPremium(nameUser, iD, Calendar.getInstance())){

                System.out.println("The Premium User has been successfully registered");
            }else{

                System.out.println("The Premium User has not been successfully registered");
            }

        } 
    }
/**Method title: sellBooks
*Description: The method allows you to buy objects Book
*Return: Buying an object of the Book class
*/
    private void sellBook() {

        String query = controller.consultRegisterUser();

		String query2 = controller.getBookList();

		if (query.equals("")) {

			System.out.println("There is not users registered");
		} else {

			System.out.println("This is the info in the system");

			System.out.println(query);

            System.out.println("Enter the user");
            int optionUser= reader.nextInt();

            if (query2.equals("")){
                System.out.println("There is not books registered");
            } else {

                System.out.println(query2);

                System.out.println("Enter the book do you want to buy");
			    int optionBook = reader.nextInt();

			    if (controller.sellBook1(optionBook-1, optionUser-1)) {

				System.out.println("Transaction succesfully");

			    } else {

				System.out.println("Error in the transaction");
			}
        }
	}

}
/**Method title: sellMagazine
*Description: The method allows you to suscribe objectos Magazine
*Return: Suscribe to a objecto of the Magazine class
*/ 
    private void sellMagazine() {

		String query = controller.getMagazineList();

        String query2 = controller.consultRegisterUser();

		if (query2.equals("")) {

			System.out.println("There is not users registered");
		} else {

			System.out.println("This is the info in the system");

			System.out.println(query2);

            System.out.println("Enter the user");
            int optionUser = reader.nextInt();

            if (query.equals("")){
                System.out.println("There are not magazines registered");
            }else{

                System.out.println(query);

                System.out.println("Enter the magazine do you want to buy");
			    int optionMagazine = reader.nextInt();

			    if (controller.sellMagazine1(optionMagazine-1,optionUser-1)) {

				    System.out.println("Transaction succesfully");

			    }else {

				System.out.println("Error in the transaction");
			    }
            }
		}

	}

    private void unsubscribe(){

        String query = controller.verificarProductsMagazine();

        String query2 = controller.consultRegisterUser();

		if (query2.equals("")) {

			System.out.println("There is not users registered");
		} else {

			System.out.println("This is the info in the system");

			System.out.println(query2);

            System.out.println("Enter the user");
            int optionUser = reader.nextInt();

            if (query.equals("")){
                System.out.println("There are not magazines registered");
            }else{

                System.out.println(query);

                System.out.println("Enter the magazine do you want to unsubscribe");
			    int optionMagazine = reader.nextInt();

                System.out.println(controller.deleteSuscripcionMagazine(optionMagazine-1, optionUser-1));
            }
        }

    }
    /* 

    private void sesionDeLectura1(){

        String query = controller.consultRegisterUser();

        if (query.equals("")) {

			System.out.println("There is not users registered");
		} else {

			System.out.println("This is the info in the system");

			System.out.println(query);
            
            System.out.println("Enter the user");

			int optionUser = reader.nextInt();
        
            System.out.println(controller.printStringMatrix(optionUser-1));

            int pages = 1;
            int pagesRead = 0;
            String optionMenuSimu;
    
            System.out.println("Digite el codigo del producto bibliografico para la simulacion de lectura");

            reader.nextLine();
            String codigoProducto = reader.nextLine();
            if (controller.verificarId(codigoProducto)){

                do{
            
                System.out.println(controller.simulacionLectura1(optionUser-1, codigoProducto));
                System.out.println("Digite A (en mayuscula) para la anterior pagina");
                System.out.println("Digite S (en mayuscula) para la siguiente pagina");
                System.out.println("Digite B (en mayuscula) para salir");
                optionMenuSimu = reader.nextLine();

            if (optionMenuSimu.equals("A")){
                if (pages!=1){
                    pages--;
                    pagesRead++;
                }else{
                    System.out.println("Digite una opcion correcta");
                }
            }else if (optionMenuSimu.equals("S")){
                pages++;
                pagesRead++;
            }else{
                System.out.println("Elegiste salir");
            }

            System.out.println("Has leido un total de "+pagesRead + " paginas");
            controller.simulacionLectura(optionUser-1, codigoProducto, pagesRead, pages);
            controller.adReadingSesion(optionUser-1, codigoProducto, optionMenuSimu);

            }while(!optionMenuSimu.equals("B"));
            
        }
    }

}
*/

private void sesionDeLectura(){

    String msg = "\nSesion de lectura en progreso:";
    msg+="\nEste producto bibliografico no se encuentra entre su productos comprados";

    System.out.println("Digita tu usuario");

    System.out.println(controller.consultRegisterUser());
    int userPosition = reader.nextInt();

    String query = controller.printStringMatrix(userPosition-1);

    reader.nextLine();

    System.out.println(query);

    System.out.println("Digite el codico del producto");
    String productId = reader.nextLine();

    boolean flag = false;

    while (!flag) {

        System.out.println(controller.simulacionLectura1(userPosition-1, productId));

        if (!controller.simulacionLectura1(userPosition-1, productId).equals(msg)) {

            System.out.println("\nDigite A para ir a la antrior pagina");
            System.out.println("\nDigite S para ir a la siguiente pagina");
            System.out.println("\nDigite B para volver a la biblioteca");
            String optionMenu = reader.nextLine();

            controller.adReadingSesion(userPosition-1, productId, optionMenu);

            if (optionMenu.equals("B")){

                flag = true;

            }
        }

        else{

            flag = true;

        }

    }

}

    private void mostrarBiblotecaUser(){

        String query = controller.consultRegisterUser();

        if (query.equals("")) {

			System.out.println("There is not users registered");
		} else {

			System.out.println("This is the info in the system");

			System.out.println(query);
            
            System.out.println("Enter the user");

			int optionUser = reader.nextInt();

           System.out.println(controller.printStringMatrix(optionUser-1));
        } 
    }
        
            
    private void req8(){

        System.out.println("1.Product Biblio pages read");
        System.out.println("2.Gener or Category the one most read");
        System.out.println("3.Top 5 Book & Magazine most read");
        System.out.println("4.Genre num sold, total value, Category num active, total value");
        int option = reader.nextInt();

        switch(option){
            case 1:
            System.out.println(controller.totalNumberOfPagesRead()); 
            break;
            case 2:
            System.out.println(controller.genreMostReadBook());
            System.out.println(controller.categryMostReadMagazine());
            break;
            case 3:
            System.out.println(controller.top5Book());
            System.out.println(controller.top5Magazine());
            break;
            case 4:
            System.out.println(controller.mostSoldBookMagazines());
            break;
            

        }
    }















}