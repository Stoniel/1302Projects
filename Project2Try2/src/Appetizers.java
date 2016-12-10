/**The  Appetizers class handles everything to be done if the customer orders an appetizer. It updates the counters
 * and the totals. It extends from CustomerOrder and is final in order to prevent any other classes from extending off it*/
import java.util.Scanner;

public final class Appetizers extends CustomerOrder
{
	private String appChoice;
	private AppType appType;
	private boolean b = true;
	private int quantity = 0;
public enum AppType
{
	Salad,Soup
}
public void displayMenu()
{
	App:
	while(b)
	{
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter Appetizer choice(1-2) or hit any key to exit");
	System.out.println("1)Salad" + "\n" + "2)Soup");
	appChoice = keyboard.nextLine().trim();
	switch(appChoice)//This switch checks their appChoice and sets enums appropriately.
	{
	case("1"):
		appType = AppType.Salad;
		break;
	case("2"):
		appType = AppType.Soup;
		break;
	default:
		break App;
	}	
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
			break App;
		}
		if(quantity < 0)
			System.out.println("Please enter a positive number.");
		else
		{
			sessionAppOrders += quantity;
			if(appType.equals(AppType.Salad))
			{
			total += SALAD_PRICE * quantity;
			saladCount += quantity;
			continue App;
			}
			else if(appType.equals(AppType.Soup))
			{
				total += SOUP_PRICE * quantity;
				soupCount += quantity;
				continue App;
			}
			else
				System.out.println("Error when calculating total.");
		}
	}//Quantity While-Loop
	}//AppChoice While-Loop
}//Display Menu public String method(String s)
}//Appetizers
