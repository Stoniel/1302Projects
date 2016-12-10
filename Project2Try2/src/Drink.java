/** The Drink class takes in the quantity, and then updates the drink counters. This class is final in order to
 * prevent classes from extending beyond it. It only does this one function*/
import java.util.Scanner;
public final class Drink extends CustomerOrder
{	
private boolean b = true;
private int quantity = 0;
public void displayMenu()/*  */
{
	Scanner keyboard = new Scanner(System.in);
	
	while(b)
	{
		quantity = 0;
		System.out.println("Please enter quantity or hit any key to exit.");
		try
		{
			quantity = keyboard.nextInt();
		}
		catch(Exception e)
		{
			break;
		}
		if(quantity < 0)
			System.out.println("Please enter a positive number.");
		else
		{
			total += quantity * DRINK_PRICE;
			drinkCount += quantity;
			sessionDrinkOrders += quantity;
			break;
		}
	}
}
}
