package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.text.Position;

import java.util.ArrayList;

public class Controller {

    private ArrayList<Users> users;
	private ArrayList<Invoice> invoices;
    private ArrayList<Products> products;
	



	public Controller() {

		products = new ArrayList<Products>();
		users = new ArrayList<Users>();
		invoices = new ArrayList<Invoice>();

		testCases();
		
	}
    public void testCases() {
	
		Calendar datePublish1 = new GregorianCalendar(1992, 05-1, 02);
		Calendar datePublish2 = new GregorianCalendar(2011, 06-1, 26);
		Calendar datePublish3 = new GregorianCalendar(2000, 02-1, 20);
		Calendar datePublish4 = new GregorianCalendar(1980, 10-1, 30);

        users.add(new Regular("110855", "Samuel", "Samu"));
		users.add(new Premium("114408", "Karen", "Karencita"));

		products.add(new Book("Ratatouille", 300, datePublish1,"https://www.sensacine.com/peliculas/pelicula-46211/", "Es una rata que cocina a traves de un humano chef", 66, 35.000, "A33"));
		products.add(new Book("More beautiful for having been broken", 430, datePublish2,"https://www.imdb.com/title/tt7326320/", "un amor hermoso", 3, 50.000, "A20"));

		products.add(new Magazine("SCIENCE ISSN", 20, datePublish3, "https://www.science.org/journal/science", 2, 37.600, 2, "9.178"));
		products.add(new Magazine("REVISTA", 15, datePublish4, "buena revista", 2, 8.2, 1, "PW22"));

		saleProduct(1, "A21");
		saleProduct(1, "O33");

	}



    
/**
	 * Returns a String containing the list of all registered users.
	 *
	 * @return A String containing the list of all registered users.
	 */

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
			}

		}

		return msg;

	}

	/**
	 * Registers a new user with the given ID, name, nickname, user type, and
	 * category.
	 *
	 * @param id       The ID of the new user.
	 * @param name     The name of the new user.
	 * @param nickname The nickname of the new user.
	 * @param userType The type of user (1 for regular, 2 for premium).
	 * @param category The category of the premium user (1 for silver, 2 for gold, 3
	 *                 for diamond).
	 * @return True if the user was successfully registered, false otherwise.
	 */

	public boolean registerUser(String id, String name, String nickname, int userType) {

		if(userType == 1){
			users.add(new Regular(id, name, nickname));
			return true;
		}else{
			users.add(new Premium(id, name, nickname));
			return true;
		}

	}


	public boolean registerProduct(String id, String name, int numberPages, String review, int genre, double price, int category, int periodicity, int typeProduct, String url, int pDay, int pMounth, int pYear){

		Calendar publicationDate = new GregorianCalendar(pYear, pMounth-1, pDay);

		if(typeProduct == 1){

			products.add(new Book(name, numberPages, publicationDate, url, review, genre, price, id));

			return true;
		}else{

			products.add(new Magazine(name, numberPages, publicationDate, url, category, pYear, periodicity, id));

			return true;
		}

	}

	/**
     * Deletes a user from the system.
     *
     * @param position the position of the user in the list
     * @return true if the user is deleted successfully, false otherwise
     */

	public boolean deletUser(int position){

		users.remove(position-1);
		return true;
		
	}

	/**
     * Deletes a product from the system.
     *
     * @param position the position of the product in the list
     * @return true if the product is deleted successfully, false otherwise
     */
	
	public boolean deletProduct(int position){

		products.remove(position-1);
		return true;
		
	}

	public boolean saleProduct(int  user, String product){
		
		int position = -1;
		for(int i = 0; i<products.size(); i++){
			String comparator = products.get(i).getIdentifier(); 
			if(comparator.equals(product)){
				position = i;
			}
		}
		
		if(position == -1){
			return false;
		}
		if(products.get(position) instanceof Book){ 
			Book sale = (Book)products.get(position);
			users.get(user).addBook(sale);
			invoices.add(new Invoice(products.get(position).getIdentifier(), sale.getName(), sale.getPrice()));
			Double sold = sale.getTotalsold();
			sale.setTotalsold(sold++);
			return true;
		}else{
			Magazine sale = (Magazine)products.get(position);
			users.get(user).addMagazine(sale);
			Invoice.add(new Invoice(products.get(position).getIdentifier(), sale.getName(), sale.getValueSuscription()));
			int suscribe = sale.getActiveSuscription();
			sale.setActiveSuscription(suscribe++);;
			return true;
		}
		
	
	}

	public boolean verifier(int position){

		if(users.get(position-1) != null){
			return true;
		}

		return false;
	}

	public boolean verifierId(String position){

		for(int i = 0; i<products.size(); i++){
			if(products.get(i).getIdentifier().equals(position)){
				return true;
			}
		}

		return false;
	}

	public String showProducts(){

		String msg = "";
		msg += "\n" + "|   Name   |	  Type	  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

			msg +=  "\n " + (i+1) + " | " + products.get(i).toString() + " | " +" \n "; 
			msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
		}

		}

		return msg;

	}

	public String showBook(){

		String msg = "";
		msg += "\n" + "|   	     Name 		  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

			if(products.get(i) instanceof Book){
				msg +=  "\n " + products.get(i).getIdentifier() + " | " + products.get(i).getName() + " | " +" \n "; 
				msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
			}
		}

		}
		return msg;
	}

	public String showMagazine(){

		String msg = "";
		msg += "\n" + "|   	     Name 		  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

			if(products.get(i) instanceof Magazine){
				msg +=  "\n " + products.get(i).getIdentifier() + " | " + products.get(i).getName() + " | " +" \n "; 
				msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
			}
		}

		}
		return msg;
	}

	public String printUs(){

		String msg = "";

		for(int i = 0; i<users.size(); i++){

			if(users.get(i) != null){

				msg += "\n" +(i+1) + " - " + users.get(i).toString(); 

			}

		}

		return msg;

	}

	 public int typeProduct(int position){

			if(products.get(position) instanceof Magazine){
				return 1;
			}

		return 2;
	 }
	 
	 public Boolean unSuscribe(int user, String product){

		users.get(user-1).magazineDelete(product);

		return true;
	 }

	 public String userPrintMagazine(int position){

		String msg = ((Regular) users.get(position-1)).printMagazine();

		return msg ;

	 }
	
	 public String viewLibrary(int user){

		String msg = ((Regular) users.get(user-1)).viewLibrary();

		return msg;

	 }

}