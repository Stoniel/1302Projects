/** This class is the main method,which should call the methods from my other classes to fulfill the program.*/
import java.util.Scanner;
public class PizzaTester 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		String itemChoice;
		boolean b = true;
		Order o = new CustomerOrder();
		o.printHeading();
		Customer:
		while(b)
		{
		o.displayMenu();
		itemChoice = keyboard.nextLine();
		if(itemChoice.equals("1"))//These if-statements instantiate Order o to the correct type.
		{
		o = new Pizza();
		o.displayMenu();
		}
		else if(itemChoice.equals("2"))
		{
		o = new Appetizers();
		o.displayMenu();
		}
		else if(itemChoice.equals("3"))
		{
		o = new Drink();
		o.displayMenu();
		}
		o.output();
		while(b)
		{
			System.out.println("More to order? Y for yes N for no");
			String orderChoice;
			orderChoice = keyboard.nextLine().trim();
			if(orderChoice.equalsIgnoreCase("y"))
			{
				o = new CustomerOrder();
				break;
			}
			else if(orderChoice.equalsIgnoreCase("n"))
			{
				o.setCounter();
				o.printInvoice();
				while(b)
				{
				String customerExitChoice;
				System.out.println("System off. Enter N for new customer or E to exit the program.");
				customerExitChoice = keyboard.nextLine().trim();
				if(customerExitChoice.equalsIgnoreCase("n"))
				{
					o.wipeVars();
					o = new CustomerOrder();
					o.printHeading();
					continue Customer;
				}
				else if(customerExitChoice.equalsIgnoreCase("e"))
				{
					o.displaySession();
					System.exit(0);
				}
				else
				System.out.println("Please enter a valid response(n or e).");
				}
			}
			else
				System.out.println("Please enter a valid response(Y for yes or N for no).");
		}//More to order while loop
		}//While-Loop for order
	}//Main
}//PizzaTester
