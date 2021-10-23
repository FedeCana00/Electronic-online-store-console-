/**
 * 
 */
package assignment_1;

import java.util.Scanner;

import assignment_1.classes.Operations;
import assignment_1.managers.CredentialsManager;
import assignment_1.managers.ProductsManager;
import assignment_1.models.Amministrator;
import assignment_1.models.Credentials;
import assignment_1.models.Employee;
import assignment_1.models.Product;
import assignment_1.models.User;

/**
 * This class represents the access point of the program.
 * 
 * @author Federico Canali
 */
public class Main {
	
	/* CONSTANTS */
	private static final String LOG_IN = "l";
	private static final String SIGN_UP = "s";

	/**
	 * This method is the method that will be executed when the program is run.
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		
		System.out.println("WELCOME to my e-commerce");
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Do you want to Log in (key : l) or Sign Up (key : s) ?");
			String action = scanner.nextLine();
			
			
			switch(action) {
				case LOG_IN:
					logIn();
					break;
				case SIGN_UP:
					signUp();
					break;
				default:
					System.out.println("Key inserted not valid... Retry!");
			}
			
		}

	}
	
	/* used to initialize some users and some products */
	private static void init() {
		Amministrator myself = new Amministrator("Federico", "Canali", new Credentials("fede","f"));
		User user = new User("Bob", "Smith", new Credentials("bob","b"));
		Employee employee = new Employee("Alice", "Jones", new Credentials("ali","jS"));
		
		CredentialsManager.getInstance().signUp(myself);
		CredentialsManager.getInstance().signUp(user);
		CredentialsManager.getInstance().signUp(employee);
		
		Product computer = new Product("Computer HP", "HP", 55600, 10);
		Product earphones = new Product("Earphones", "AKG", 3550, 2);
		Product tvXiaomi = new Product("Mi TV LED", "Xiaomi", 27900, 40);
		Product iPad = new Product("iPad", "Apple", 99999, 5);
		Product iPhone = new Product("iPhone X", "Apple", 129999, 2);
		
		ProductsManager.getInstance().addProduct(computer);
		ProductsManager.getInstance().addProduct(earphones);
		ProductsManager.getInstance().addProduct(tvXiaomi);
		ProductsManager.getInstance().addProduct(iPad);
		ProductsManager.getInstance().addProduct(iPhone);
	}
	
	/* used to log in into e-commerce and do some actions*/
	private static void logIn() {
		boolean isLoggedIn = false;
		
		do {
			
			isLoggedIn = CredentialsManager.getInstance().logIn();
			
		} while(!isLoggedIn);
		
		loop : while(true) {
			String operation = Operations.askUserOperation();
			
			if(operation != null) {
				switch(operation) {
					case Operations.SEARCH:
						if(checkIfUserHavePermissions(CredentialsManager.USER, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().searcProducts();
						break;
					case Operations.BUY:
						if(checkIfUserHavePermissions(CredentialsManager.USER, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().buySomeProducts(Operations.BUY);
						break;
					case Operations.SHIP_TO_CUSTOMER:
						if(checkIfUserHavePermissions(CredentialsManager.EMPLOYEE, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().buySomeProducts(Operations.SHIP_TO_CUSTOMER);
						break;
					case Operations.UPDATE_PRODUCT:
						if(checkIfUserHavePermissions(CredentialsManager.EMPLOYEE, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().updateProduct();
						break;
					case Operations.NEW_EMPLOYEE:
						if(checkIfUserHavePermissions(CredentialsManager.ADMINISTRATOR, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							CredentialsManager.getInstance().addNewEmployee();
						break;
					case Operations.NEW_PRODUCT:
						if(checkIfUserHavePermissions(CredentialsManager.ADMINISTRATOR, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().newProduct();
						break;
					case Operations.REMOVE_PRODUCT:
						if(checkIfUserHavePermissions(CredentialsManager.ADMINISTRATOR, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							ProductsManager.getInstance().removeProduct();
						break;
					case Operations.PRINT_EMPLOYEE:
						if(checkIfUserHavePermissions(CredentialsManager.ADMINISTRATOR, CredentialsManager.getInstance().getTypeOfPersonLoggedIn()))
							CredentialsManager.getInstance().printAllEmployees();
						break;
					case Operations.PRINT_PRODUCT:
						ProductsManager.getInstance().printAllProducts();
						break;
					case Operations.LOGOUT:
						CredentialsManager.getInstance().logout();
						break loop;
					default:
						//do nothing
						System.out.println("Oops.. No operations found!");
				}
			}
			
		}
	}
	
	
	/* used to sign up into e-commerce and then used to log in inside it */
	private static void signUp() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insert your name...");
		String name = scanner.nextLine();
		
		System.out.println("Insert your lastname...");
		String lastname = scanner.nextLine();
		
		System.out.println("Insert username...");
		String username = scanner.nextLine();
		
		System.out.println("Insert password...");
		String password = scanner.nextLine();
		
		
		if(name == null && lastname == null && username == null && password == null) {
			System.out.println("One or more fields were not compiled correctly! Retry!");
			return;
		}
		
		if(CredentialsManager.getInstance().signUp(new User(name, lastname, new Credentials(username, password)))) {
			System.out.println("Registration was successful!");
			logIn();
		}
	}
	
	/* used to check if user have the permission to do that type of action */
	private static boolean checkIfUserHavePermissions(int permissionRequired, int yourPermissions) {
		if(permissionRequired == yourPermissions)
			return true;
		
		System.out.println("I'm sorry but you don't have the permissions to do this operation...");
		return false;
	}

}
