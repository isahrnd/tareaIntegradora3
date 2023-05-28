package ui;

import java.util.Scanner;
import model.Controller;

/**
 * Clase que contiene el método main y maneja la interfaz de usuario para interactuar con el sistema de ReaderX.
 */
public class Executable {

	private Scanner reader;
	private Controller rXSystem;

    
    /**
	 * Constructor de la clase Executable.
	 * Inicializa el escáner y el controlador del sistema ReaderX.
	 */
	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

    /**
	 * Método principal que crea una instancia de Executable y llama al método de menú.
	 * @param args Los argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

    /**
	 * Método que muestra el menú principal y maneja las opciones seleccionadas por el usuario.
	 */

	private void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Registra un producto");
			System.out.println("3. Eliminar un usuario");
			System.out.println("4. Eliminar un libro");
			System.out.println("5. Modificar un libro");
			System.out.println("6. Vender un libro");
			System.out.println("7. Vender una suscripcion");
			System.out.println("8. Cancelar una suscripcion");
			System.out.println("9. Mostrar biblioteca del usuario");
			System.out.println("10. Simulacion de lectura");
			System.out.println("11. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				registerProducts();
				break;
			case 3:
				deletUser();
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				editProduct();
				break;
			case 6:
				saleBook();
				break;
			case 7:
				saleMagazine();
				break;
			case 8:
				unsubscribe();
				break;
			case 9:
				viewLibrary();
				break;
			case 10:
				break;
			case 11:
				System.out.println("Gracias por usar ReaderX!");
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida, digite una opcion valida");
				break;

			}

		}

	}

    
	/**
	 * Método que registra un nuevo usuario en el sistema.
	 */

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion del usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite numero cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		System.out.println("Digite el tipo de usuario \n1.Regular \n2.Premium");
		int userType = reader.nextInt();

		if (rXSystem.registerUser(id, name, nickname, userType)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}


	}
    
	/**
	 * Método que registra un nuevo usuario en el sistema.
	 */

     /**
     * Registra productos en el sistema.
     */
	private void registerProducts(){

		System.out.println("Ingrese el id del producto:");
		String id = reader.nextLine();

		System.out.println("Ingrese el nombre del libro:");
		String name = reader.nextLine();

		System.out.println("Ingrese el numero de paginas:");
		int numberPages = reader.nextInt();

		System.out.println("Ingrese el dia de publicacion del producto");
		int pDay = reader.nextInt();

		System.out.println("Ingrese el mes de publicacion del producto");
		int pMounth = reader.nextInt();

		System.out.println("Ingrese el año de publicacion del producto");
		int pYear = reader.nextInt();

		System.out.println("Digite la URl que lleva a la pagina del libro:");
		String url = reader.nextLine();


		System.out.println("Digite el tipo de producto que desea registrar \n 1. Libro \n 2. Revista");
		int typeProduct = reader.nextInt();
		reader.nextLine();

		if(typeProduct == 1){

			System.out.println("Digite una pequeña reseña del libro:");
			String review = reader.nextLine();

			System.out.println("Digite el genero del libro: \n 1. ciencia ficcion \n 2. fantasia \n 3. novelas historicas ");
			int genre = reader.nextInt();
			
			System.out.println("Digite el valor del producto:");
			double price = reader.nextInt();

			if(rXSystem.registerProduct(id, name, numberPages, review, genre, price, numberPages, genre, typeProduct, url, pDay, pMounth, pYear)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("No se ha podido registrar");
			}

		}else{

			System.out.println("Digite la frecuencia del producto \n 1. semanal  \n 2. mensual \n 3. quincenal");
			int periodicity = reader.nextInt();

			System.out.println("Digite el genero del libro \n 1. variedades \n 2. cientifica \n 3. diseño");
			int category = reader.nextInt();
	
			System.out.println("Digite el valor de la suscripcion");
			double price = reader.nextDouble();

			if(rXSystem.registerProduct(id, name, numberPages, name, numberPages, price, category, periodicity, typeProduct, url, pDay, pMounth, pYear)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("No se ha podido registrar");
			}



		

		}
	}

    /**
     * Registra productos en el sistema.
     */
	private void deletUser(){

		System.out.println("Ingrese el usuario que desea eliminar");
		System.out.println(rXSystem.printUs());
		int query1 = reader.nextInt();
		
		if(rXSystem.verifier(query1) == true){
			rXSystem.deletUser(query1);
		}else{
			System.out.println("Opcion invalida, ingrese una opcion valida");
		}

	}

        /**
     * Elimina un producto del sistema.
     */

	private void deleteProduct(){

		String query1 = rXSystem.showProducts();
		
		System.out.println(query1);
		System.out.println("\n Ingrese el producto que desea eliminar: ");
		int query2 = reader.nextInt();
		
		if(rXSystem.verifier(query2-1) == true){
			rXSystem.deletProduct(query2);
			System.out.println("Se ha eliminado correctamente");
		}else{
			System.out.println("Ingrese una opcion valida");
		}

	}

    /**
     * Edita un producto existente en el sistema.
     */
	private void editProduct(){

		String query1 = rXSystem.showProducts();
		System.out.println(query1);
		System.out.println("Ingrese el producto que desea editar : \n");
		int query2 = reader.nextInt();
		
		if(rXSystem.verifier(query2-1) == true){
			
			if(rXSystem.typeProduct(query2) == 1){
				System.out.println("1. Todo");
				System.out.println("2. ID");
				System.out.println("3. Nombre");
				System.out.println("4. El número de páginas");
				System.out.println("5. La reseña");
				System.out.println("6. El género");
				System.out.println("7. La URL");
				System.out.println("8. Valor de venta");
				int param = reader.nextInt();

				switch (param) {
					case 1:
					System.out.println(" Digite el nuevo nombre : \n ");


						break;
					case 2:
					System.out.println("Digite el nuevo nombre : \n ");
						break; 
					default:
						break;
				}
				
			}else{

			}

		}else{
			System.out.println("Esta opcion es ivalida");
		}


	}

    /**
     * Realiza la venta de un libro a un usuario.
     */

	private void saleBook(){

		printus();
		System.out.println("A que usuario desea venderle el libro: ");
		int user = reader.nextInt();

		if(rXSystem.verifier(user) == true){

			System.out.println(rXSystem.showBook());
			reader.nextLine();
			System.out.println("\n" + "Que libro desea vender: ");
			String sale = reader.nextLine();

			if(rXSystem.verifierId(sale)){
				if(rXSystem.saleProduct(user-1, sale) == true){
					System.out.println("\n" + "Libro vendido correctamente ");
				}else{
					System.out.println("\n" + "La biblioteca esta llena");
				}
			}else{
				System.out.println("Este libro no se encuentra disponible ");
			}

		}else{
			System.out.println("El usuario ingresado no esta registrado ");
		}

	}

     /**
     * Realiza la suscripción de un usuario a una revista.
     */
	private void saleMagazine(){

		printus();
		System.out.println("A que usuario desea suscribir a la revista: ");
		int user = reader.nextInt();

		if(rXSystem.verifier(user) == true){
			
			System.out.println(rXSystem.showMagazine());
			reader.nextLine();
			System.out.println("\n" + "A que revista desea suscribirle: ");
			String sale = reader.nextLine();

			if(rXSystem.verifierId(sale)){
				if(rXSystem.saleProduct(user-1, sale) == true){
					System.out.println("\n" + "suscripcion hecha correctamente ");
				}else{
					System.out.println("\n" + "La biblioteca esta llena");
				}
			}else{
				System.out.println("Esta revista no se encuentra disponible ");
			}

		}else{
			System.out.println("El usuario ingresado no esta registrado");
		}

	}

    /**
     * Cancela la suscripción de un usuario a una revista.
     */

	private void unsubscribe(){

		printus();
		System.out.println("A que usuario desea cancelarle suscripcion: ");
		int user = reader.nextInt();

		if(rXSystem.verifier(user) == true){
		
		reader.nextLine();
		System.out.println(rXSystem.userPrintMagazine(user));
		System.out.println("Digite el id de la revista que desea eliminar: ");
		String magazine = reader.nextLine();				

		if(rXSystem.verifierId(magazine) == true){

			if(rXSystem.unSuscribe(user,magazine)){
				System.out.println("Suscripcion borrada exitosamente");
			}else{
				System.out.println("No fue posible eliminar la suscripcion");
			}

		}else{
			System.out.println("Revista no encontrada ");
		}

		}else{
			System.out.println("Este usuario no esta registrado: ");
		}


	}

    /**
     * Muestra la biblioteca de un usuario.
     */
	private void viewLibrary(){
		
		printus();
		System.out.println("De que usuario desea ver la biblioteca ");
		int user = reader.nextInt();

		if(rXSystem.verifier(user) == true){
			
			System.out.println("no hay problema rey");
			System.out.println(rXSystem.viewLibrary(user));

		}else{
			System.out.println("Este usuario no esta registrado: ");
		}


	}


    
	private void printus(){
		System.out.println(rXSystem.printUs());
	}

}