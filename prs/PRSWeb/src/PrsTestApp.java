import java.util.ArrayList;
import java.util.List;

import prs.util.Console;

public class PrsTestApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS Tester");
		System.out.println();
		
		ProductDB productDB = new ProductDB();
		String command = "";

		while (!command.equalsIgnoreCase("4")) {
			displayMenu();
		command = Console.getString("Enter command: ");
				if (command.equals("1")) {
					List<Product> products = productDB.getAll();
					for (Product p : products) {
						System.out.println(p);
					}
					
				}
				else if (command.equals("2")) {
					String criteria = Console.getString("Search users by first name, last name: ");
					List<Product> products = new ArrayList<>();
					if (criteria.equalsIgnoreCase("g")) {
						String partNumber = Console.getString("Please enter the product's part number: ");
						int vendorID = Console.getInt("Please enter the vendor ID: ");
						products = productDB.get(partNumber, vendorID);
						
						
					}
					else if (criteria.equalsIgnoreCase("l")) {
						String length = Console.getString("Enter show length? 30, 60, 90");
						products = productDB.get(length);
						
					}
					
					System.out.println("Result of search: ");
					for (Product p : products) {
						System.out.println(p);
					}
					
				} else if (command.equals("4")) {
					String userName = Console.getString("Please enter username: ");
					String password = Console.getString("Please enter password: ");
					String firstName = Console.getString("Please enter first name: ");
					String lastName = Console.getString("Please enter last name: ");
					String phoneNumber = Console.getString("Please enter phone number: ");
					String email = Console.getString("Please enter email: ");
					UserDB.add(userName, password, firstName, lastName, phoneNumber, email);
				}
				else if (!command.equals("3")) {
					System.out.println("Invalid command, try again.");
				}
				displayMenu();
		}
		System.out.println("Bye!");

	}
	
	
	
	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("COMMAND MENU \n");
		sb.append("1 - List Products \n");
		sb.append("2 - Search for Product \n");
		sb.append("3 - Add a Product \n");
		sb.append("4 - Exit Program \n");
		System.out.println(sb);
	}

	
	
}
